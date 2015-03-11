package org.openmrs.module.cumulativecohort.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.cumulativecohort.api.CohortCriteriaDataService;
import org.openmrs.module.cumulativecohort.api.CumulativeCohortProcessorService;
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by savai on 3/10/15.
 */
public class CumulativeCohortProcessor {
    private final Log log = LogFactory.getLog(CumulativeCohortProcessor.class);
    private CohortCriteriaDataService cohortCriteriaDataService;

    private static Boolean isRunning = false;
    public void process() {
        if (!isRunning) {
            log.info("Starting up cumulative cohort processor ...");
            processCumulativeCohorts();
        } else {
            log.info("Cumulative cohort processor aborting (another processor already running)!");
        }
    }

    private void processCumulativeCohorts(){
        try {
            isRunning = true;
            CohortCriteriaDataService cohortCriteriaDataService = Context.getService(CohortCriteriaDataService.class);
            CumulativeCohortProcessorService cumulativeCohortProcessorService = Context.getService(CumulativeCohortProcessorService.class);
            List<CohortCriteriaData> cohortCriteriaDataList = cohortCriteriaDataService.getAllCohortCriteriaData();

            Iterator<CohortCriteriaData> cohortCriteriaDataIterator = cohortCriteriaDataList.iterator();
            while(cohortCriteriaDataIterator.hasNext()){
                CohortCriteriaData cohortCriteriaData=cohortCriteriaDataIterator.next();
                    try{
                        cumulativeCohortProcessorService.process(cohortCriteriaData);
                    }catch(Exception e){
                        log.error("unable to process cumulative cohort due to "+ e.getMessage());
                    }
            }
        } finally {
            isRunning = false;
        }
    }
}
