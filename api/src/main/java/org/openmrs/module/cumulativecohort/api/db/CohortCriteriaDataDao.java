package org.openmrs.module.cumulativecohort.api.db;

import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by savai on 3/10/15.
 */
public interface CohortCriteriaDataDao {
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    CohortCriteriaData getById(Integer id);

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    List<CohortCriteriaData> getAll();

    @Transactional
    CohortCriteriaData saveOrUpdate(CohortCriteriaData object);

    @Transactional
    CohortCriteriaData update(CohortCriteriaData object);

    @Transactional
    void delete(CohortCriteriaData object);

    Number count();
}
