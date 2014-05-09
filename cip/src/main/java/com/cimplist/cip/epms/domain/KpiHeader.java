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
@Table(name="tbKpiHeader")
public class KpiHeader {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="userID")
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="approvedByUserID")
	private User approvedByUser;
	
	private Date kpiSetupDate;
	
	private String status;
	
	@OneToMany(mappedBy="kpiHeader",fetch = FetchType.EAGER)
	List<KpiItem> kpiItems=new LinkedList<>();

	public Long getKey() {
		return key;
	}

	public void setKey(Long key) {
		this.key = key;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getApprovedByUser() {
		return approvedByUser;
	}

	public void setApprovedByUser(User approvedByUser) {
		this.approvedByUser = approvedByUser;
	}

	public Date getKpiSetupDate() {
		return kpiSetupDate;
	}

	public void setKpiSetupDate(Date kpiSetupDate) {
		this.kpiSetupDate = kpiSetupDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<KpiItem> getKpiItems() {
		return kpiItems;
	}

	public void setKpiItems(List<KpiItem> kpiItems) {
		this.kpiItems = kpiItems;
	}
}
