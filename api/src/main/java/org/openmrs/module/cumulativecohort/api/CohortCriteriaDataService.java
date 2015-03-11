package org.openmrs.module.cumulativecohort.api;

/**
 * Created by savai on 3/10/15.
 */

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

import java.util.List;

public interface CohortCriteriaDataService  extends OpenmrsService {
    CohortCriteriaData getCohortCriteriaDataById(final Integer id);
    CohortCriteriaData saveCohortCriteriaData(final CohortCriteriaData cohortCriteriaData);
    void deleteCohortCriteriaData(final CohortCriteriaData cohortCriteriaData);
    List<CohortCriteriaData> getAllCohortCriteriaData();
    Number countCohortCriteriaData();
}
