package com.cimplist.cip.epms.dao;

import org.springframework.stereotype.Repository;

import com.cimplist.cip.epms.domain.KpiItem;
import com.cimplist.cip.framework.CrudDAO;

@Repository
public class KpiItemDAO  extends CrudDAO<KpiItem,Long> {

	@Override
	public KpiItem findByKey(Long key) {
		return (KpiItem) sessionFactory.getCurrentSession().get(KpiItem.class, key);
	}


}
