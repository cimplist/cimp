package com.cimplist.cip.epms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbKpiReviewItem")
public class KpiReviewItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kpiReviewHeaderID")
	private KpiReviewHeader kpiReviewHeader;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kpiItemID")
	private KpiItem kpiItem;
	
	private String comments;
	private Float rating;
	
	private String status;

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public KpiItem getKpiItem() {
		return kpiItem;
	}

	public void setKpiItem(KpiItem kpiItem) {
		this.kpiItem = kpiItem;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public KpiReviewHeader getKpiReviewHeader() {
		return kpiReviewHeader;
	}

	public void setKpiReviewHeader(KpiReviewHeader kpiReviewHeader) {
		this.kpiReviewHeader = kpiReviewHeader;
	}

}
