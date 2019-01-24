package com.netcracker.dao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BasicDAO<T> {

    @Autowired
    public Class<T> typeClass;
    @Autowired
    SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    protected void persist(Object entity){
        getSession().persist(entity);
    }

    protected void delete(Object entity){
        getSession().delete(entity);
    }

    public void save(T entity) {
        persist(entity);
    }

    public void deleteByObject(T entity) {
        delete(entity);
    }

    public T findById(int id) {
        Criteria criteria = getSession().createCriteria(typeClass);
        criteria.add(Restrictions.eq("id",id));
        return (T) criteria.uniqueResult();
    }
    public List<T> getAll() {
        Query query = getSession().createQuery(new String("FROM " + typeClass.getName()));
        return (List<T>) query.list();
    }
    public void deleteAll(){
        Query query = getSession().createQuery(new String("DELETE FROM " + typeClass.getName()));
        query.executeUpdate();
    }
    public void deleteById(int id) {
        Query query = getSession().createQuery(new String("DELETE FROM " + typeClass.getName() + " WHERE id = :id"));
        query.setInteger("id",id);
        query.executeUpdate();
    }
    public Long countRec(){
        Query query = getSession().createQuery(new String("SELECT COUNT(*) FROM " + typeClass.getName()));
        return (Long)query.uniqueResult();
    }

}
