package com.kershaw.poc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kershaw.poc.entity.Role;
import com.kershaw.poc.service.UserRoleService;
import com.kershaw.poc.websecurity.WebSecurityConfig;

@RestController
public class UserController {

	@Autowired
	UserRoleService userRoleService;

	//@RequestMapping(value = "/role", method = RequestMethod.GET)	
	private boolean validateUserRole(String userName ,long roleId) {
		System.out.println("------>valid"+userName);
		//System.out.println(Long.parseLong(roleId));
		
		long id = userRoleService.validateUserRole(userName,roleId );
		System.out.println("checkkkkkkk999999999999" +id);
		boolean flag = false;
		if (id == roleId)
			flag = true;

		return flag;

	}
	
	@RequestMapping(value="/authenticate" , method=RequestMethod.POST)
	public String index(@RequestParam String roleName) {
		
		Role role = userRoleService.findByRoleName(roleName);
		Authentication auth = WebSecurityConfig.getAuthentication();
		
		System.out.println("autheticated user or not--->"+auth.isAuthenticated()+ 
				"Name---> "+auth.getName()+" Principal-->"+auth.getPrincipal());
		
		boolean flag = validateUserRole(auth.getName(), role.getRoleid());
		auth.setAuthenticated(false);
		
		if (flag){
			
			return "success";
		}
		
	    return "invalid";
	}
	
//	@PostMapping("/login")
//	public ResponseEntity login() {
//		System.out.println("abc");
//	    return new ResponseEntity<>(HttpStatus.OK);
//	} 
	
	/*@RequestMapping("/authenticate")
	public String index(@RequestParam String user, @RequestParam String password) {
		System.out.println(user);
		WebSecurityConfig.getAuthentication();
	    return "Welcome to the home page!";
	}*/
}
