package org.openmrs.module.cumulativecohort.api.db.hibernate;

import org.openmrs.module.cumulativecohort.api.db.CohortCriteriaDataDao;
import org.openmrs.module.cumulativecohort.api.model.CohortCriteriaData;

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
public class HibernateCohortCriteriaDataDao implements CohortCriteriaDataDao{
    @Autowired
    protected SessionFactory sessionFactory;
    protected Class mappedClass =CohortCriteriaData.class;

    public HibernateCohortCriteriaDataDao(){
        super();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public CohortCriteriaData getById(Integer id){
        return (CohortCriteriaData)sessionFactory.getCurrentSession().get(mappedClass,id);
    }


    public List<CohortCriteriaData> getAll(){;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(mappedClass);
        return (List<CohortCriteriaData>) criteria.list();
    }


    public CohortCriteriaData saveOrUpdate(CohortCriteriaData object){
        sessionFactory.getCurrentSession().saveOrUpdate(object);
        return object;
    }


    public CohortCriteriaData update(CohortCriteriaData object){
        sessionFactory.getCurrentSession().update(object);
        return object;
    }


    public void delete(CohortCriteriaData object){
        sessionFactory.getCurrentSession().delete(object);
    }


    public Number count(){
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(mappedClass);
        criteria.add(Restrictions.eq("voided", Boolean.FALSE));
        criteria.setProjection(Projections.rowCount());
        return (Number) criteria.uniqueResult();
    }
}
