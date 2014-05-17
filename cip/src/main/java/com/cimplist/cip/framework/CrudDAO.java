package com.cimplist.cip.framework;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudDAO<T,PK extends Serializable> {
	protected SessionFactory sessionFactory;
	
	public PK create(T object){
		Serializable id = sessionFactory.getCurrentSession().save(object);
		return ((PK)id);
	}
	public void update(T object){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(object);
	}
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void delete(T object) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(object);

	}
	public  T getByKey(PK key,Class<T> clazz){
		return (T) sessionFactory.getCurrentSession().get(clazz, key);
	}
	public  T loadByKey(PK key,Class<T> clazz){
		return (T) sessionFactory.getCurrentSession().load(clazz, key);
	}
}
