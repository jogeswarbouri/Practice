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
@Table(name = "permissions")
public class Permission {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "permission_id", nullable = false)
	private long permissionId;
	
	@NotEmpty
	@Column(name = "permission_name", nullable = false)
	private String permissionName;
	
	@ManyToMany
	@JoinTable(name = "role_permission",
				joinColumns = {@JoinColumn(name = "permission_id", referencedColumnName = "permission_id")},
				inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")})
	private List<Role> roles;

	public long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(long permissionId) {
		this.permissionId = permissionId;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
