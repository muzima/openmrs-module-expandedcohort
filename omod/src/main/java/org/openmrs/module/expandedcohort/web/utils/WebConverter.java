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
package org.openmrs.module.expandedcohort.web.utils;

import org.openmrs.Cohort;
import org.openmrs.api.context.Context;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

import java.util.HashMap;
import java.util.Map;

public class WebConverter {
    public static Map<String, Object> convertCohortDefinitionData(final CohortDefinitionData cohortDefinitionData){
        Map<String, Object> map = new HashMap<String, Object>();
        if(cohortDefinitionData!=null){
            Cohort cohort = Context.getCohortService().getCohort(cohortDefinitionData.getCohortId());
            map.put("cohortid",cohortDefinitionData.getCohortId());
            map.put("name",cohort.getName());
            map.put("description",cohort.getDescription());
            map.put("definition",cohortDefinitionData.getDefinition());
            map.put("isscheduled",cohortDefinitionData.getScheduled());
            map.put("uuid",cohortDefinitionData.getUuid());
        }
        return map;
    }
    public static Map<String, Object> convertCohort(final Cohort cohort){
        Map<String, Object> map = new HashMap<String, Object>();
        if(cohort!=null){
            System.out.println("convert add "+cohort.getName());
            map.put("id",cohort.getId());
            map.put("name",cohort.getName());
            map.put("description",cohort.getDescription());
        }
        System.out.println("added map "+map.toString());
        return map;
    }
}
    
