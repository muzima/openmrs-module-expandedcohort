package org.openmrs.module.cumulativecohort.api.model;

import org.openmrs.BaseOpenmrsData;
import java.io.Serializable;

/**
 * Created by savai on 3/10/15.
 */
public class CohortCriteriaData  extends BaseOpenmrsData implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer cohort_id;
    private String criteria;
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(final Integer id) {
        this.id = id;
    }

    public Integer getCohortId(){
        return cohort_id;
    }

    public void setCohort_id(final Integer cohort_id){
        this.cohort_id=cohort_id;
    }

    public String getCriteria(){
        return criteria;
    }

    public void setCriteria(String criteria){
        this.criteria=criteria;
    }
}
