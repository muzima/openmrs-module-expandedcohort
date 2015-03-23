package org.openmrs.module.cumulativecohort.api.model;

import org.openmrs.BaseOpenmrsData;
import java.io.Serializable;

/**
 * Created by savai on 3/10/15.
 */
public class CohortCriteriaData  extends BaseOpenmrsData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer cohortId;
    private String criteria;

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

    public String getCriteria(){
        return criteria;
    }

    public void setCriteria(String criteria){
        this.criteria=criteria;
    }
}
