package com.kershaw.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kershaw.poc.entity.Role;
import com.kershaw.poc.repository.RoleRepository;
import com.kershaw.poc.repository.UserRoleDao;

@Service
public class UserRoleServiceImpl implements UserRoleService{

	@Autowired
	UserRoleDao userRoleDao;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public long validateUserRole(String userName, long roleID) {
		
		return userRoleDao.validateUserRole(userName, roleID);
	}
	
	
	@Override
	public Role findByRoleName(String roleName){
		
		return roleRepository.findByRoleName(roleName);
		
	}
	
	
	

	
}
