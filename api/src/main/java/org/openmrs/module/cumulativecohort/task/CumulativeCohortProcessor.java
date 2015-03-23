package org.openmrs.module.cumulativecohort.task;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.cumulativecohort.api.CohortCriteriaDataService;
import org.openmrs.module.cumulativecohort.api.CumulativeCohortProcessorService;
import org.openmrs.module.cumulativecohort.api.impl.CumulativeCohortProcessorServiceImpl;
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
    public void processCumulativeCohorts() {
        if (!isRunning) {
            log.info("Starting up cumulative cohort processor ...");
            process();
        } else {
            log.info("Cumulative cohort processor aborting (another processor already running)!");
        }
    }

    private void process(){
        try {
            isRunning = true;
            System.out.println("in cumulativecohortprocessor.process()");
            CohortCriteriaDataService cohortCriteriaDataService = Context.getService(CohortCriteriaDataService.class);
            CumulativeCohortProcessorService cumulativeCohortProcessorService = new CumulativeCohortProcessorServiceImpl();
            List<CohortCriteriaData> cohortCriteriaDataList = cohortCriteriaDataService.getAllCohortCriteriaData();

            Iterator<CohortCriteriaData> cohortCriteriaDataIterator = cohortCriteriaDataList.iterator();
            while(cohortCriteriaDataIterator.hasNext()){
                System.out.println("in cumulativecohortprocessor.process() iterator");
                CohortCriteriaData cohortCriteriaData=cohortCriteriaDataIterator.next();
                   // try{
                        cumulativeCohortProcessorService.process(cohortCriteriaData);
                   // }catch(Exception e){
                   //     log.error("unable to process cumulative cohort due to "+ e.getStackTrace());
                    //}
            }
        } finally {
            isRunning = false;
        }
    }
}
