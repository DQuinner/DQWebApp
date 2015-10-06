package ie.dq.web.facade;

import java.util.List;

import ie.dq.web.common.model.UserUI;

public interface UserFacade {
	
	public String addUser(UserUI userUI);
		
	public UserUI getUserDetails(String username);
	
	public List<UserUI> getAllUsers();

}
