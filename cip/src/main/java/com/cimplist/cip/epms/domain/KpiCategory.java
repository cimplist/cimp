package com.cimplist.cip.epms.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tbKpiCategory")
public class KpiCategory {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;
	private String catDesc;
	
	private BigDecimal weightPercentBase;
	
	public String toString(){
		return "ID:"+key+",catDesc="+catDesc;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public String getCatDesc() {
		return catDesc;
	}
	public void setCatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	public BigDecimal getWeightPercentBase() {
		return weightPercentBase;
	}
	public void setWeightPercentBase(BigDecimal weightPercentBase) {
		this.weightPercentBase = weightPercentBase;
	}
}
