package org.openmrs.module.cumulativecohort.web.utils;

import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by savai on 3/23/15.
 */
public class WebConverter {
    public static Map<String, Object> convertCohortCriteriaData(final CohortCriteriaData cohortCriteriaData){
        Map<String, Object> map = new HashMap<String, Object>();
        if(cohortCriteriaData!=null){
            map.put("criteria",cohortCriteriaData.getCriteria());
            map.put("isScheduled",true);
            map.put("name","name");
            map.put("description","description");
        }
        return map;
    }
}
