package org.openmrs.module.expandedcohort.api.impl;

import org.openmrs.api.context.Context;
import org.openmrs.module.expandedcohort.api.ExpandedCohortProcessorService;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;
import org.openmrs.Cohort;
import org.openmrs.module.reportingcompatibility.service.ReportingCompatibilityService;

public class ExpandedCohortProcessorServiceImpl implements ExpandedCohortProcessorService {
    public void process(CohortDefinitionData cohortDefinitionData){
        Cohort savedCohort = Context.getCohortService().getCohort(cohortDefinitionData.getCohortId());

        ReportingCompatibilityService reportingCompatibilityService = Context.getService(ReportingCompatibilityService.class);
        Cohort newCohort = reportingCompatibilityService.getPatientsBySqlQuery(cohortDefinitionData.getDefinition());

        savedCohort.getMemberIds().addAll(newCohort.getMemberIds());
        Context.getCohortService().saveCohort(savedCohort);

        savedCohort = Context.getCohortService().getCohort(cohortDefinitionData.getCohortId());
    }
}
