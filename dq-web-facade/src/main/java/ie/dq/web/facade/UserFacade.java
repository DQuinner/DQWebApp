package ie.dq.web.facade;

import ie.dq.web.common.model.UserUI;
import ie.dq.web.service.DQUserService;
import ie.dq.web.service.model.UserAdminRequest;
import ie.dq.web.service.model.UserAdminResponse;
import ie.dq.web.service.model.UserDetailsResponse;
import ie.dq.web.service.model.UserRequest;
import ie.dq.web.service.model.UsersResponse;

import java.util.List;

public class UserFacade {
	
	private DQUserService userService;
	
	public void setUserService(DQUserService userService) {
		this.userService = userService;
	}

	public String addUser(UserUI userUI){
		
		UserAdminRequest userAdminRequest = new UserAdminRequest();
		userAdminRequest.setUser(userUI);
		UserAdminResponse response = userService.addUser(userAdminRequest);
		return response.getMessage();
	}
	
	public UserUI getUserDetails(String username){
		
		UserDetailsResponse response = userService.getUserDetails(username);
		return response.getUserUI();
	}
	
	public List<UserUI> getAllUsers(){
		
		UserRequest userRequest = new UserRequest();
		userRequest.setAllUsers(true);
		UsersResponse response = userService.getUsers(userRequest);
		return response.getUsers();
	}
}