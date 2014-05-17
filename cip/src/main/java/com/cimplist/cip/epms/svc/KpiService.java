package com.cimplist.cip.epms.svc;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cimplist.cip.epms.dao.KpiHeaderDAO;
import com.cimplist.cip.epms.dao.KpiReviewHeaderDAO;
import com.cimplist.cip.epms.dao.KpiReviewItemDAO;
import com.cimplist.cip.epms.domain.KpiHeader;
import com.cimplist.cip.epms.domain.KpiItem;
import com.cimplist.cip.epms.domain.KpiReviewHeader;
import com.cimplist.cip.epms.domain.KpiReviewItem;

@Service
public class KpiService {
	private static final Logger logger = LoggerFactory.getLogger(KpiService.class);

	@Inject
	private KpiHeaderDAO kpiHeaderDAO;
	@Inject
	private KpiReviewHeaderDAO kpiReviewHeaderDAO;	
	@Inject
	private KpiReviewItemDAO kpiReviewItemDAO;
	@Transactional(readOnly=true)
	public KpiHeader getKpi(String userName) {
		return kpiHeaderDAO.findByUserName(userName);
	}
	
	@Transactional
	public KpiReviewHeader createKpiReviewForUser(String userName){
		KpiHeader kpiHeader = getKpi(userName);
		KpiReviewHeader review = new KpiReviewHeader();
		review.setKpiHeader(kpiHeader);
		review.setStatus("NEW");
		Long key = kpiReviewHeaderDAO.create(review);
		review = kpiReviewHeaderDAO.getByKey(key,KpiReviewHeader.class);
		
		for(KpiItem kpiItem:kpiHeader.getKpiItems()){
			KpiReviewItem kri = new KpiReviewItem();
			kri.setKpiItem(kpiItem);
			kri.setKpiReviewHeader(review);
			kri.setStatus("NEW");
			review.getKpiReviewItems().add(kri);
			kpiReviewItemDAO.create(kri);
		}
		review = kpiReviewHeaderDAO.getByKey(key,KpiReviewHeader.class);
		return review;
	}
	@Transactional
	public KpiReviewHeader getKpiReviewForUser(String userName) {
		KpiReviewHeader krh = kpiReviewHeaderDAO.findByUserName(userName);
		krh.getKpiHeader().getUser();
		return krh;
	}
	@Transactional
	public KpiReviewHeader loadKPIReviewHeader(Long key) {
		KpiReviewHeader krh = kpiReviewHeaderDAO.loadByKey(key, KpiReviewHeader.class);
		krh.getKpiHeader().getUser();
		return krh;
	}
}
