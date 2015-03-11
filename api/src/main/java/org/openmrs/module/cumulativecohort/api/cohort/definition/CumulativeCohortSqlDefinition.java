package org.openmrs.module.cumulativecohort.api.cohort.definition;

/**
 * Created by savai on 3/11/15.
 */
import org.openmrs.module.reporting.cohort.definition.SqlCohortDefinition;
public class CumulativeCohortSqlDefinition extends SqlCohortDefinition {
    public CumulativeCohortSqlDefinition(){
        super();
    }

    public CumulativeCohortSqlDefinition(String query){
        super(query);
    }
}
