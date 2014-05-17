package com.cimplist.cip.epms.svc;

import java.util.Map;

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
import com.cimplist.cip.user.domain.User;
import com.cimplist.cip.user.svc.UserProfileService;

@Service
public class KpiService {
	private static final Logger logger = LoggerFactory.getLogger(KpiService.class);

	@Inject
	private KpiHeaderDAO kpiHeaderDAO;
	@Inject
	private KpiReviewHeaderDAO kpiReviewHeaderDAO;	
	@Inject
	private KpiReviewItemDAO kpiReviewItemDAO;
	@Inject private UserProfileService userService;
	@Transactional(readOnly=true)
	public KpiHeader getKpi(String userName) {
		return kpiHeaderDAO.findByUserName(userName);
	}
	
	@Transactional
	public KpiReviewHeader createKpiReviewForUser(String userName, String reviewedBy){
		KpiHeader kpiHeader = getKpi(userName);
		KpiReviewHeader review = new KpiReviewHeader();
		review.setKpiHeader(kpiHeader);
		review.setStatus("NEW");
		User reviewer = userService.getUserByUserName(reviewedBy);
		review.setReviewedBy(reviewer);
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
	public KpiReviewHeader findKpiReviewForUserIfExits(String userName, String reviewedBy){
		KpiReviewHeader review = kpiReviewHeaderDAO.findKpiReviewForUserIfExits( userName,  reviewedBy);
		return review;
	}
	@Transactional
	public KpiReviewHeader findOrCreateKpiReviewForUser(String userName, String reviewedBy){
		KpiReviewHeader review = kpiReviewHeaderDAO.findKpiReviewForUserIfExits( userName,  reviewedBy);
		if(review==null){
			review = createKpiReviewForUser( userName,  reviewedBy);
		}
		review.getReviewedBy().getUserName();
		review.getKpiHeader().getUser().getUserName();

		return review;
	}

	@Transactional
	public KpiReviewHeader getKPIReviewHeader(Long key) {
		KpiReviewHeader krh = kpiReviewHeaderDAO.getByKey(key, KpiReviewHeader.class);
		krh.getKpiHeader().getUser().getUserName();
		krh.getReviewedBy().getFname();
		return krh;
	}
	@Transactional
	public void updateReviewComments(Map<Long,String>  comments) {
		for(Long key:comments.keySet()){
			KpiReviewItem review = kpiReviewItemDAO.getByKey(key, KpiReviewItem.class);
			review.setComments(comments.get(key));
			kpiReviewItemDAO.update(review);
		}
	}
}
