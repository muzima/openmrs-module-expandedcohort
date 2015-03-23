package org.openmrs.module.cumulativecohort.web.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.cumulativecohort.api.CohortCriteriaDataService;
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;
import org.openmrs.module.cumulativecohort.web.utils.WebConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/module/cumulativecohort/cohortdefinitions.json")
public class CohortDefinitionsController{
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllExpandedCohortDefinitions(){
        System.out.println("in getAllExpandedCohortDefinitions()");
        Map<String, Object> response = new HashMap<String, Object>();
        CohortCriteriaDataService expandedCohortDataService = Context.getService(CohortCriteriaDataService.class);
        List<Object> objects = new ArrayList<Object>();
        for(CohortCriteriaData cohortCriteriaData : expandedCohortDataService.getAllCohortCriteriaData()){
            objects.add(WebConverter.convertCohortCriteriaData(cohortCriteriaData));
        }
        System.out.println("found definitions: "+objects.size());
                response.put("objects", objects);
        System.out.println("response size:"+response.size());

        return response;
    }
}
