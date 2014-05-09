package com.cimplist.cip.epms.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbKpiCategoryWeight")
public class KpiCategoryWeight {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="kpicatID")
	KpiCategory kpiCategory;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kpiHeaderID")
	private KpiHeader kpiHeader;
	
	private BigDecimal weightPercent;
	
	public String toString(){
		return "ID:"+key+",weightPercent="+weightPercent;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	
	public BigDecimal getWeightPercent() {
		return weightPercent;
	}
	public void setWeightPercent(BigDecimal weightPercent) {
		this.weightPercent = weightPercent;
	}
	public KpiCategory getKpiCategory() {
		return kpiCategory;
	}
	public void setKpiCategory(KpiCategory kpiCategory) {
		this.kpiCategory = kpiCategory;
	}
	public KpiHeader getKpiHeader() {
		return kpiHeader;
	}
	public void setKpiHeader(KpiHeader kpiHeader) {
		this.kpiHeader = kpiHeader;
	}
}
