package org.openmrs.module.cumulativecohort.api;

/**
 * Created by savai on 3/11/15.
 */
import org.openmrs.api.CohortService;
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

public interface CumulativeCohortProcessorService extends CohortService{
    void process(CohortCriteriaData cohortCriteriaData);
}
