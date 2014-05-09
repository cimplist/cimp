package com.cimplist.cip.epms.domain;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cimplist.cip.user.domain.User;

@Entity
@Table(name="tbKpiReviewHeader")
public class KpiReviewHeader {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;
	
	private boolean selfReview;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kpiHeaderID")
	private KpiHeader kpiHeader;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="reviewedByUserID")
	private User reviewedBy;
	
	@OneToMany(mappedBy="kpiReviewHeader",fetch = FetchType.EAGER)
	List<KpiReviewItem> kpiReviewItems=new LinkedList<>();
	
	private Date reviewDate;
	
	
	private Float overallRating;
	
	private String status;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}


	public User getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(User reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public Float getOverallRating() {
		return overallRating;
	}

	public void setOverallRating(Float overallRating) {
		this.overallRating = overallRating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isSelfReview() {
		return selfReview;
	}

	public void setSelfReview(boolean selfReview) {
		this.selfReview = selfReview;
	}

	public KpiHeader getKpiHeader() {
		return kpiHeader;
	}

	public void setKpiHeader(KpiHeader kpiHeader) {
		this.kpiHeader = kpiHeader;
	}

	public List<KpiReviewItem> getKpiReviewItems() {
		return kpiReviewItems;
	}

	public void setKpiReviewItems(List<KpiReviewItem> kpiReviewItems) {
		this.kpiReviewItems = kpiReviewItems;
	}
}
