package org.openmrs.module.cumulativecohort.api.impl;

import org.openmrs.api.context.Context;
import org.openmrs.module.cumulativecohort.api.CumulativeCohortProcessorService;
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;
import org.openmrs.Cohort;
import org.openmrs.module.reportingcompatibility.service.ReportingCompatibilityService;

public class CumulativeCohortProcessorServiceImpl implements CumulativeCohortProcessorService {
    public void process(CohortCriteriaData cohortCriteriaData){
        Cohort savedCohort = Context.getCohortService().getCohort(cohortCriteriaData.getCohortId());
        System.out.println("Got savedCohort: "+savedCohort.toString()+" Description="+savedCohort.getDescription());

        ReportingCompatibilityService reportingCompatibilityService = Context.getService(ReportingCompatibilityService.class);
        Cohort newCohort = reportingCompatibilityService.getPatientsBySqlQuery(cohortCriteriaData.getCriteria());
        System.out.println("Got newCohort: "+newCohort.toString()+" Description="+newCohort.getDescription());

        savedCohort.getMemberIds().addAll(newCohort.getMemberIds());
        System.out.println("Cohort to save: "+savedCohort.toString()+" Description="+savedCohort.getDescription());
        Context.getCohortService().saveCohort(savedCohort);

        savedCohort = Context.getCohortService().getCohort(cohortCriteriaData.getCohortId());
        System.out.println("RESULT COHORT: "+savedCohort.toString()+" Description="+savedCohort.getDescription());
    }
}
