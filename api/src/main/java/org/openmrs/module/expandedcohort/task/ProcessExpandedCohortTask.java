package org.openmrs.module.expandedcohort.task;

/**
 * Created by savai on 3/10/15.
 */
import org.openmrs.scheduler.tasks.AbstractTask;
import org.openmrs.api.context.Context;
public class ProcessExpandedCohortTask extends AbstractTask{
    private ExpandedCohortProcessor processor;
    public ProcessExpandedCohortTask(){
        this.processor=new ExpandedCohortProcessor();
    }
    @Override
    public void execute() {
        System.out.println("generating cohort");
                Context.openSession();
        processor.processExpandedCohorts();
        Context.closeSession();
    }
}
