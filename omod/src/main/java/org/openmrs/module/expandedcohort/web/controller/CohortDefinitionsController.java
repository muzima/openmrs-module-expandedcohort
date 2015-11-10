package org.openmrs.module.expandedcohort.web.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.expandedcohort.api.CohortDefinitionDataService;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;
import org.openmrs.module.expandedcohort.web.utils.WebConverter;
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
@RequestMapping(value = "/module/expandedcohort/cohortdefinitions.json")
public class CohortDefinitionsController{
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllExpandedCohortDefinitions(){
        Map<String, Object> response = new HashMap<String, Object>();
        CohortDefinitionDataService expandedCohortDataService = Context.getService(CohortDefinitionDataService.class);
        List<Object> objects = new ArrayList<Object>();
        for(CohortDefinitionData cohortCriteriaData : expandedCohortDataService.getAllCohortDefinitionData()) {
            objects.add(WebConverter.convertCohortDefinitionData(cohortCriteriaData));
        }
        response.put("objects", objects);
        return response;
    }
}
