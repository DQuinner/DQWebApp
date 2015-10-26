package ie.dq.stub.facade.impl;

import ie.dq.web.common.model.UserUI;
import ie.dq.web.facade.UserFacade;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserFacadeStub implements UserFacade {
	
	public String addUser(UserUI userUI){
		
		return "USER_ADDED";
	}
	
	public UserUI getUserDetails(String username){
		
		UserUI userUI = new UserUI();
		
		if("adminstubber".equalsIgnoreCase(username)){
			userUI = getAdminUser();
		}else if("basicstubber".equalsIgnoreCase(username)){
			userUI = getBasicUser();
		}else{
			return userUI;
		}
		return userUI;
	}
	
	public List<UserUI> getAllUsers(){
		
		List<UserUI> userUI = new LinkedList<UserUI>();
		userUI.add(getBasicUser());
		userUI.add(getAdminUser());
		return userUI;
	}
	
	private UserUI getBasicUser(){
		UserUI userUI = new UserUI();
		userUI.setEmail("basic@stub.com");
		userUI.setForename("basic");
		userUI.setSurname("stub");
		userUI.setUsername("basicstubber");
		userUI.setPassword("password");
		return userUI;
	}
	
	private UserUI getAdminUser(){
		UserUI userUI = new UserUI();
		userUI.setEmail("admin@stub.com");
		userUI.setForename("admin");
		userUI.setSurname("stub");
		userUI.setUsername("adminstubber");
		userUI.setPassword("password");
		return userUI;
	}
}