package org.openmrs.module.expandedcohort.api;

/**
 * Created by savai on 3/11/15.
 */
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

public interface ExpandedCohortProcessorService{
    void process(CohortDefinitionData cohortDefinitionData);
}
