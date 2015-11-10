package org.openmrs.module.expandedcohort.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.expandedcohort.api.CohortDefinitionDataService;
import org.openmrs.module.expandedcohort.api.ExpandedCohortProcessorService;
import org.openmrs.module.expandedcohort.api.impl.ExpandedCohortProcessorServiceImpl;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by savai on 3/10/15.
 */
public class ExpandedCohortProcessor {
    private final Log log = LogFactory.getLog(ExpandedCohortProcessor.class);
    private CohortDefinitionDataService cohortDefinitionDataService;

    private static Boolean isRunning = false;
    public void processExpandedCohorts() {
        if (!isRunning) {
            log.info("Starting up Expanded cohort processor ...");
            process();
        } else {
            log.info("Expanded cohort processor aborting (another processor already running)!");
        }
    }

    private void process(){
        try {
            isRunning = true;
            CohortDefinitionDataService cohortDefinitionDataService = Context.getService(CohortDefinitionDataService.class);
            ExpandedCohortProcessorService expandedCohortProcessorService = new ExpandedCohortProcessorServiceImpl();
            List<CohortDefinitionData> cohortDefinitionDataList = cohortDefinitionDataService.getAllScheduledCohortDefinitionData();

            Iterator<CohortDefinitionData> cohortCriteriaDataIterator = cohortDefinitionDataList.iterator();
            while(cohortCriteriaDataIterator.hasNext()){
                CohortDefinitionData cohortCriteriaData=cohortCriteriaDataIterator.next();
                System.out.println("Processing cohort:"+cohortCriteriaData.getCohortId());
                expandedCohortProcessorService.process(cohortCriteriaData);
            }
        } finally {
            isRunning = false;
        }
    }
}
