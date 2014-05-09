package com.cimplist.cip.epms.dao;

import org.springframework.stereotype.Repository;

import com.cimplist.cip.epms.domain.KpiReviewItem;
import com.cimplist.cip.framework.CrudDAO;

@Repository
public class KpiReviewItemDAO  extends CrudDAO<KpiReviewItem,Long>{

	@Override
	public KpiReviewItem findByKey(Long key) {
		return (KpiReviewItem) sessionFactory.getCurrentSession().get(KpiReviewItem.class, key);
	}

}
