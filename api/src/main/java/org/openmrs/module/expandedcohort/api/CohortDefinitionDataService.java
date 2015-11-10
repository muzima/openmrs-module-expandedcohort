package org.openmrs.module.expandedcohort.api;

/**
 * Created by savai on 3/10/15.
 */

import org.openmrs.api.OpenmrsService;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

import java.util.List;

public interface CohortDefinitionDataService  extends OpenmrsService {
    CohortDefinitionData getCohortDefinitionDataById(final Integer id);
    CohortDefinitionData getCohortDefinitionDataByUuid(final String uuid);
    CohortDefinitionData saveCohortDefinitionData(final CohortDefinitionData cohortDefinitionData);
    void deleteCohortDefinitionData(final CohortDefinitionData cohortDefinitionData);
    List<CohortDefinitionData> getAllCohortDefinitionData();
    List<CohortDefinitionData> getAllScheduledCohortDefinitionData();
    Number countCohortDefinitionData();
}
