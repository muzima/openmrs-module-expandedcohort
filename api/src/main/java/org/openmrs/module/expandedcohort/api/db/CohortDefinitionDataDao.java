package org.openmrs.module.expandedcohort.api.db;

import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by savai on 3/10/15.
 */
public interface CohortDefinitionDataDao {
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    CohortDefinitionData getById(Integer id);

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    CohortDefinitionData getByUuid(String uuid);

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    List<CohortDefinitionData> getAll();

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    List<CohortDefinitionData> getByScheduled(Boolean scheduled);

    @Transactional
    CohortDefinitionData saveOrUpdate(CohortDefinitionData object);

    @Transactional
    CohortDefinitionData update(CohortDefinitionData object);

    @Transactional
    void delete(CohortDefinitionData object);

    Number count();
}
