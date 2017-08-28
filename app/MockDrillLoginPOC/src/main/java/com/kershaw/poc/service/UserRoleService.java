package com.kershaw.poc.service;

import com.kershaw.poc.entity.Role;

public interface UserRoleService {

	public long validateUserRole(String userName, long roleID);
	
	public Role findByRoleName(String roleName);
}
