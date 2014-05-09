package com.cimplist.cip.epms.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="tbKpiItem")
public class KpiItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;
	private String kpiItemDesc;
	private String kpiParameterDesc;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="kpicatWeightID")
	private KpiCategoryWeight kpiCatWeight;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="kpiHeaderID")
	private KpiHeader kpiHeader;
	
	private String status;
	
	public String toString(){
		return "ID:"+key+",kpiItemDesc="+kpiItemDesc;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public String getKpiItemDesc() {
		return kpiItemDesc;
	}
	public void setKpiItemDesc(String kpiDesc) {
		this.kpiItemDesc = kpiDesc;
	}
	public String getKpiParameterDesc() {
		return kpiParameterDesc;
	}
	public void setKpiParameterDesc(String kpiParameter) {
		this.kpiParameterDesc = kpiParameter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public KpiCategoryWeight getKpiCatWeight() {
		return kpiCatWeight;
	}
	public void setKpiCatWeight(KpiCategoryWeight kpiCatWeight) {
		this.kpiCatWeight = kpiCatWeight;
	}
	public KpiHeader getKpiHeader() {
		return kpiHeader;
	}
	public void setKpiHeader(KpiHeader kpiHeader) {
		this.kpiHeader = kpiHeader;
	}
}
