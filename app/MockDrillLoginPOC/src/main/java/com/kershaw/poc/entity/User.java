package com.kershaw.poc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "user_detail")
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "user_id", nullable = false)
	private long userid;
	
	@NotEmpty
	@Column(name = "user_name", nullable = false)
	private String userName;
	
	@ManyToMany
	@JoinTable(name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")} )
	private List<Role> roles;
	
	@Transient
	private String password;

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Role> getRole() {
		return roles;
	}

	public void setRole(List<Role> role) {
		this.roles = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
