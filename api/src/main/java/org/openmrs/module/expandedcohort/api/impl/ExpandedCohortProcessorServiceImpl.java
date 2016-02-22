/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
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
