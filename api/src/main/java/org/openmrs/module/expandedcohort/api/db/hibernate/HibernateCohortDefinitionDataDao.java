package org.openmrs.module.expandedcohort.api.db.hibernate;

import org.openmrs.module.expandedcohort.api.db.CohortDefinitionDataDao;
import org.openmrs.module.expandedcohort.api.model.CohortDefinitionData;

import org.hibernate.SessionFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Created by savai on 3/10/15.
 */
public class HibernateCohortDefinitionDataDao implements CohortDefinitionDataDao{
    @Autowired
    protected SessionFactory sessionFactory;
    protected Class mappedClass =CohortDefinitionData.class;

    public HibernateCohortDefinitionDataDao(){
        super();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public CohortDefinitionData getById(Integer id){
        return (CohortDefinitionData)sessionFactory.getCurrentSession().get(mappedClass,id);
    }

    public CohortDefinitionData getByUuid(String uuid){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(mappedClass);
        criteria.add(Restrictions.eq("uuid", uuid));
        criteria.add(Restrictions.eq("voided", Boolean.FALSE));
        return (CohortDefinitionData)criteria.uniqueResult();
    }

    public List<CohortDefinitionData> getAll(){;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(mappedClass);
        return (List<CohortDefinitionData>) criteria.list();
    }

    public List<CohortDefinitionData> getByScheduled(Boolean scheduled){;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(mappedClass);
        criteria.add(Restrictions.eq("scheduled", scheduled));
        return (List<CohortDefinitionData>) criteria.list();
    }

    public CohortDefinitionData saveOrUpdate(CohortDefinitionData object){
        sessionFactory.getCurrentSession().saveOrUpdate(object);
        return object;
    }

    public CohortDefinitionData update(CohortDefinitionData object){
        sessionFactory.getCurrentSession().update(object);
        return object;
    }

    public void delete(CohortDefinitionData object){
        sessionFactory.getCurrentSession().delete(object);
    }

    public Number count(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(mappedClass);
        criteria.add(Restrictions.eq("voided", Boolean.FALSE));
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
}
