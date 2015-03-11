package org.openmrs.module.cumulativecohort.api.impl;


import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.cumulativecohort.api.CohortCriteriaDataService;
import org.openmrs.module.cumulativecohort.api.db.CohortCriteriaDataDao;
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

import java.util.List;

/**
 * Created by savai on 3/10/15.
 */
public class CohortCriteriaDataServiceImpl extends BaseOpenmrsService implements CohortCriteriaDataService {
    private final Log log = LogFactory.getLog(this.getClass());

    private CohortCriteriaDataDao dao;

    public void setDao(CohortCriteriaDataDao dao) {
        this.dao = dao;
    }

    public CohortCriteriaDataDao getDao() {
        return dao;
    }

    public CohortCriteriaData getCohortCriteriaDataById(final Integer id){
        return dao.getById(id);
    }

    public CohortCriteriaData saveCohortCriteriaData(final CohortCriteriaData cohortCriteriaData){
        return dao.saveOrUpdate(cohortCriteriaData);

    }
    public void deleteCohortCriteriaData(final CohortCriteriaData cohortCriteriaData){
        dao.delete(cohortCriteriaData);
    }
    public List<CohortCriteriaData> getAllCohortCriteriaData(){
        return dao.getAll();
    }

    public Number countCohortCriteriaData(){
        return dao.count();
    }
}
