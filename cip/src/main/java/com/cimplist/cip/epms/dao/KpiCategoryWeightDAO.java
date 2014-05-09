package com.cimplist.cip.epms.dao;

import org.springframework.stereotype.Repository;

import com.cimplist.cip.epms.domain.KpiCategoryWeight;
import com.cimplist.cip.framework.CrudDAO;

@Repository
public class KpiCategoryWeightDAO  extends CrudDAO<KpiCategoryWeight,Long>  {

	@Override
	public KpiCategoryWeight findByKey(Long key) {
		return (KpiCategoryWeight) sessionFactory.getCurrentSession().get(KpiCategoryWeight.class, key);
	}

}
