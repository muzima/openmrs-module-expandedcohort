package org.openmrs.module.expandedcohort.web.controller;

import org.openmrs.api.context.Context;
import org.openmrs.module.expandedcohort.api.CohortDefinitionDataService;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;
import org.openmrs.module.expandedcohort.web.utils.WebConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/module/expandedcohort/cohortdefinition.json")
public class CohortDefinitionController {

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getCohortDefinitionData(final @RequestParam(value = "uuid") String uuid) {
        CohortDefinitionDataService expandedCohortDataService = Context.getService(CohortDefinitionDataService.class);
        CohortDefinitionData cohortDefinitionData = expandedCohortDataService.getCohortDefinitionDataByUuid(uuid);
        return WebConverter.convertCohortDefinitionData(cohortDefinitionData);
    }
    @RequestMapping(method = RequestMethod.POST)
    public void saveCohortDefinition(final @RequestBody Map<String, Object> map){
        if (Context.isAuthenticated()) {
            String uuid = (String) map.get("uuid");
            String definition = (String) map.get("definition");
            Integer cohortId = (Integer) map.get("cohortid");
            boolean isScheduled = (Boolean) map.get("isscheduled");

            CohortDefinitionDataService expandedCohortDataService = Context.getService(CohortDefinitionDataService.class);

            if (StringUtils.isNotBlank(uuid)) {
                CohortDefinitionData cohortDefinitionData = expandedCohortDataService.getCohortDefinitionDataByUuid(uuid);
                cohortDefinitionData.setCohortId(cohortId);
                cohortDefinitionData.setDefinition(definition);
                cohortDefinitionData.setScheduled(isScheduled);
                expandedCohortDataService.saveCohortDefinitionData(cohortDefinitionData);
            } else {
                CohortDefinitionData cohortDefinitionData = new CohortDefinitionData();
                cohortDefinitionData.setCohortId(cohortId);
                cohortDefinitionData.setDefinition(definition);
                cohortDefinitionData.setScheduled(isScheduled);
                expandedCohortDataService.saveCohortDefinitionData(cohortDefinitionData);
            }
        }

    }
}
