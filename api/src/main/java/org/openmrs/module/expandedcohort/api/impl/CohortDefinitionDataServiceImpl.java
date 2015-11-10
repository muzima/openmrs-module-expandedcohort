package org.openmrs.module.expandedcohort.api.impl;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.expandedcohort.api.CohortDefinitionDataService;
import org.openmrs.module.expandedcohort.api.db.CohortDefinitionDataDao;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

import java.util.List;

/**
 * Created by savai on 3/10/15.
 */
public class CohortDefinitionDataServiceImpl extends BaseOpenmrsService implements CohortDefinitionDataService {
    private final Log log = LogFactory.getLog(this.getClass());

    private CohortDefinitionDataDao dao;

    public void setDao(CohortDefinitionDataDao dao) {
        this.dao = dao;
    }

    public CohortDefinitionDataDao getDao() {
        return dao;
    }

    public CohortDefinitionData getCohortDefinitionDataById(final Integer id){
        return dao.getById(id);
    }

    public CohortDefinitionData getCohortDefinitionDataByUuid(final String uuid){
        return dao.getByUuid(uuid);
    }

    public CohortDefinitionData saveCohortDefinitionData(final CohortDefinitionData cohortDefinitionData){
        return dao.saveOrUpdate(cohortDefinitionData);

    }
    public void deleteCohortDefinitionData(final CohortDefinitionData cohortDefinitionData){
        dao.delete(cohortDefinitionData);
    }
    public List<CohortDefinitionData> getAllCohortDefinitionData(){
        return dao.getAll();
    }
    public List<CohortDefinitionData> getAllScheduledCohortDefinitionData(){
        return dao.getByScheduled(true);
    }
    public Number countCohortDefinitionData(){
        return dao.count();
    }
}
