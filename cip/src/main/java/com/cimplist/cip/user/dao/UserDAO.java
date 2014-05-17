package com.cimplist.cip.user.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cimplist.cip.framework.CrudDAO;
import com.cimplist.cip.user.domain.User;

@Repository
public class UserDAO extends CrudDAO<User,Long> {

	public List<User> findAll() {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from User a");
		List<User> brands = query.list();

		return brands;
	}
	public User getUserByUserName(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from User a  where a.userName = :userName");
		query.setString("userName", userName);
		return (User) query.uniqueResult();
	}



}
