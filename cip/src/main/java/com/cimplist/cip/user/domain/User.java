package com.cimplist.cip.user.domain;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="tbUser")
@JsonIgnoreProperties({"manager","subordinates"})
public class User {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private Long key;
	private String userName;
	private String password;
	@Transient
	private String passwordConfirm;
	private String email;
	private String fname;
	private String lname;
	private String mname;
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;


	
	@OneToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinTable(name="tbUserAuthorityJT", joinColumns={@JoinColumn(name="userID")}, 
    	inverseJoinColumns={@JoinColumn(name="roleID")})
	private List<Role> roles=new LinkedList<Role>();
	
	
	@ManyToOne( fetch = FetchType.LAZY,cascade={CascadeType.ALL})
    @JoinColumn(name="managerID")
    private User manager;
 
	
    @OneToMany(mappedBy="manager")
    private Set<User> subordinates = new HashSet<User>();
	
	public String toString(){
		return "ID:"+key+",UserName="+userName+",enabled="+enabled;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isAccountNonExpired() {
		return accountNonExpired;
	}
	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}
	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}
	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}
	public boolean isCredentialsNonExpired() {
		return credentialsNonExpired;
	}
	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(Long key) {
		this.key = key;
	}
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public User getManager() {
		return manager;
	}
	public void setManager(User manager) {
		this.manager = manager;
	}
	public Set<User> getSubordinates() {
		return subordinates;
	}
	public void setSubordinates(Set<User> subordinates) {
		this.subordinates = subordinates;
	}
}
