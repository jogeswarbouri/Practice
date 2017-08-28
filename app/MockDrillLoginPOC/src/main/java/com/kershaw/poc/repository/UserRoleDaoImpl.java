package com.kershaw.poc.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository("userRoleDao")
public class UserRoleDaoImpl implements UserRoleDao {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public long validateUserRole(String userName, long roleID) {
		String sql = "select ur.role_id from logindb.user_detail u,logindb.user_role ur where u.user_id= ur.user_id"
				+ " and u.user_name=?" + " and ur.role_id = ?";
		Query query = manager.createNativeQuery(sql);
		query.setParameter(1, userName);
		query.setParameter(2, roleID);
		//System.out.println(query.getResultList().get(0));
		
		if(query.getResultList()!= null && !query.getResultList().isEmpty()){
			return  (Integer) query.getResultList().get(0);
		}else{
			return 0L;
		}
		
		
	}

}
