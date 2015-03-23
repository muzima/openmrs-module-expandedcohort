package org.openmrs.module.cumulativecohort.api;

/**
 * Created by savai on 3/11/15.
 */
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

public interface CumulativeCohortProcessorService{
    void process(CohortCriteriaData cohortCriteriaData);
}