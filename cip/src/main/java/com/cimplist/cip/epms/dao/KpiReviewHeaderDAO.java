package com.cimplist.cip.epms.dao;

import org.springframework.stereotype.Repository;

import com.cimplist.cip.epms.domain.KpiReviewHeader;
import com.cimplist.cip.framework.CrudDAO;

@Repository
public class KpiReviewHeaderDAO extends CrudDAO<KpiReviewHeader,Long> {

	@Override
	public KpiReviewHeader findByKey(Long key) {
		return (KpiReviewHeader) sessionFactory.getCurrentSession().get(KpiReviewHeader.class, key);
	}

}
