package com.cimplist.cip.epms.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cimplist.cip.epms.domain.KpiHeader;
import com.cimplist.cip.framework.CrudDAO;

@Repository
public class KpiHeaderDAO  extends CrudDAO<KpiHeader,Long> {

	
	public KpiHeader findByUserName(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from KpiHeader a, User b  where a.user.key = b.key and b.userName = :userName");
		query.setString("userName", userName);
		return (KpiHeader) query.uniqueResult();
	}
}
