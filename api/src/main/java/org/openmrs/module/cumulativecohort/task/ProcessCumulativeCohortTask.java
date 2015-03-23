package org.openmrs.module.cumulativecohort.task;

/**
 * Created by savai on 3/10/15.
 */
import org.openmrs.scheduler.tasks.AbstractTask;
import org.openmrs.api.context.Context;
public class ProcessCumulativeCohortTask extends AbstractTask{
    private CumulativeCohortProcessor processor;
    public ProcessCumulativeCohortTask(){
        this.processor=new CumulativeCohortProcessor();
    }
    @Override
    public void execute() {
        System.out.println("generating cohort");
                Context.openSession();
        processor.processCumulativeCohorts();
        Context.closeSession();
    }
}
