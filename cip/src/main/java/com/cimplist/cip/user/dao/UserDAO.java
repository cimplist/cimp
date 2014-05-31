package com.cimplist.cip.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cimplist.cip.framework.CrudDAO;
import com.cimplist.cip.user.domain.User;

@Repository
public class UserDAO extends CrudDAO<User,Long> {

	public List<User> findAll() {
		Query query = sessionFactory.getCurrentSession().getNamedQuery("findAllUsers").setCacheable(true);
		
		List<User> users = query.list();

		return users;
	}
	public User getUserByUserName(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from User a  where a.userName = :userName").setCacheable(true);
		query.setString("userName", userName);
		return (User) query.uniqueResult();
	}
	public List<User> findUsersByManagerName(String mgrUserName,int pageNo, int pageSize) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from User a  where a.manager.userName = :userName").setCacheable(true);
		query.setString("userName", mgrUserName);
		query.setFirstResult((pageNo*pageSize)-pageSize);
		query.setMaxResults(pageSize);
		List<User> users = query.list();
		return users;
	}


}
