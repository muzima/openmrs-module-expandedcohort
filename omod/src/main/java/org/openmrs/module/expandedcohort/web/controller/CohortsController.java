package org.openmrs.module.expandedcohort.web.controller;

import org.openmrs.Cohort;
import org.openmrs.api.context.Context;
import org.openmrs.module.expandedcohort.api.CohortDefinitionDataService;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;
import org.openmrs.module.expandedcohort.web.utils.WebConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CohortsController {
    @RequestMapping(method = RequestMethod.GET,value = "/module/expandedcohort/cohorts.json")
    @ResponseBody
    public Map<String, Object> getAllCohorts(){
        Map<String, Object> response = new HashMap<String, Object>();
        List<Object> objects = new ArrayList<Object>();
        for(Cohort cohort : Context.getCohortService().getAllCohorts()) {
            objects.add(WebConverter.convertCohort(cohort));
        }
        response.put("objects", objects);
        return response;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/module/expandedcohort/cohortswithoutdefinition.json")
    @ResponseBody
    public Map<String, Object> getCohortsWithoutDefinition(){
        Map<String, Object> response = new HashMap<String, Object>();
        List<Object> objects = new ArrayList<Object>();
        List<Cohort> cohortsWithDefinition = new ArrayList<Cohort>();
        CohortDefinitionDataService expandedCohortDataService = Context.getService(CohortDefinitionDataService.class);

        for(CohortDefinitionData cohortDefinitionData : expandedCohortDataService.getAllCohortDefinitionData()) {
            cohortsWithDefinition.add(Context.getCohortService().getCohort(cohortDefinitionData.getCohortId()));
        }
        for(Cohort cohort : Context.getCohortService().getAllCohorts()) {
            if(!cohortsWithDefinition.contains(cohort)) {
                objects.add(WebConverter.convertCohort(cohort));
            }
        }
        response.put("objects",objects);
        return response;
    }
}
