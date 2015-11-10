package org.openmrs.module.expandedcohort.api.model;

import org.openmrs.BaseOpenmrsData;
import java.io.Serializable;

/**
 * Created by savai on 3/10/15.
 */
public class CohortDefinitionData  extends BaseOpenmrsData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer cohortId;
    private String definition;
    private boolean scheduled;

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getCohortId(){
        return cohortId;
    }

    public void setCohortId(final Integer cohortId){
        this.cohortId=cohortId;
    }

    public String getDefinition(){
        return definition;
    }

    public void setDefinition(String definition){
        this.definition=definition;
    }

    public void setScheduled(boolean scheduled){
        this.scheduled=scheduled;
    }

    public boolean getScheduled(){
        return scheduled;
    }
}
