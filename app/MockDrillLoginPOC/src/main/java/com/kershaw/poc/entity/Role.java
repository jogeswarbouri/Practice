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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "ROLE")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "role_id", nullable = false)
	private long roleid;
	
	@NotEmpty
	@Column(name = "role_name", nullable = false)
	private String roleName;
	
	@ManyToMany
	@JoinTable(name = "user_role",
				joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
				inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "user_id")}) 
	private List<User> users;
	
	@ManyToMany
	@JoinTable(name = "role_permission",
				joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
				inverseJoinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "permission_id")})
	private List<Permission> permissions;

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
