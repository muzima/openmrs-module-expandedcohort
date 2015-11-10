package org.openmrs.module.expandedcohort.web.utils;

import org.openmrs.Cohort;
import org.openmrs.api.context.Context;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by savai on 3/23/15.
 */
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
    
