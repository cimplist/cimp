package com.cimplist.cip.epms.dao;

import org.springframework.stereotype.Repository;

import com.cimplist.cip.epms.domain.KpiCategory;
import com.cimplist.cip.framework.CrudDAO;

@Repository
public class KpiCategoryDAO extends CrudDAO<KpiCategory,Long> {

	@Override
	public KpiCategory findByKey(Long key) {
		return (KpiCategory) sessionFactory.getCurrentSession().get(KpiCategory.class, key);
	}

}
