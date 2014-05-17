package com.cimplist.cip.epms.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.cimplist.cip.epms.domain.KpiReviewHeader;
import com.cimplist.cip.framework.CrudDAO;

@Repository
public class KpiReviewHeaderDAO extends CrudDAO<KpiReviewHeader,Long> {

	public KpiReviewHeader findByUserName(String userName) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from KpiReviewHeader a, User b  where a.reviewedBy.key = b.key and b.userName = :userName");
		query.setString("userName", userName);
		return (KpiReviewHeader) query.uniqueResult();
	}

	public KpiReviewHeader findKpiReviewForUserIfExits(String userName,
			String reviewedBy) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select a from KpiReviewHeader a, User reviewer, KpiHeader c, User me "
				+ "where a.reviewedBy.key = reviewer.key  and a.kpiHeader.key = c.key and c.user.key=me.key and me.userName=:userName and reviewer.userName = :reviewedBy");
		query.setString("userName", userName);
		query.setString("reviewedBy", reviewedBy);
		return (KpiReviewHeader) query.uniqueResult();
	}
}
