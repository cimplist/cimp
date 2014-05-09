package com.cimplist.cip.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbRole")
public class Role {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;
	private String name;
	private String description;
	public String toString(){
		return "ID:"+key+",roleName="+name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
}
