package com.kershaw.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kershaw.poc.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	@Query("select c from Role c where c.roleName = :roleName")
	public Role findByRoleName(@Param("roleName") String roleName);


}
