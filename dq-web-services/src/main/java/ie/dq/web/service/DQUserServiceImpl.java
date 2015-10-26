package ie.dq.web.service;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dq.dao.UserDao;
import ie.dq.dao.model.User;
import ie.dq.web.common.model.UserUI;
import ie.dq.web.service.model.UserAdminRequest;
import ie.dq.web.service.model.UserAdminResponse;
import ie.dq.web.service.model.UserRequest;
import ie.dq.web.service.model.UserDetailsResponse;
import ie.dq.web.service.model.UsersResponse;

@Service
@WebService
public class DQUserServiceImpl implements DQUserService {
	
	@Autowired
	private UserDao userDao;
	
	public UserDetailsResponse getUserDetails(String username){
		
		UserUI userUI = new UserUI();
		UserDetailsResponse response = new UserDetailsResponse();
		
		if(username==null || "".equalsIgnoreCase(username)){
			response.setUserUI(null);
			response.setStatus("ERROR");
			response.setErrorMsg("You must supply a username");
		}else{
			User user = userDao.getByUsername(username);
			if(user!=null){
				userUI.setUsername(user.getUsername());
				userUI.setForename(user.getFirstname());
				userUI.setSurname(user.getSurname());
				userUI.setEmail(user.getEmail());
				response.setUserUI(userUI);
				response.setStatus("SUCCESS");
			}else{
				response.setUserUI(null);
				response.setStatus("ERROR");
				response.setErrorMsg("User not found");
			}
		}
		return response;
	}
	
	public UsersResponse getUsers(UserRequest userRequest){
		
		UsersResponse usersResponse = new UsersResponse();
		List<UserUI> users;
		
		if(userRequest.isAllUsers()){
			users = mapUsers(userDao.getAllUsers());
			usersResponse.setUsers(users);
			usersResponse.setUsersCount(users.size());
			usersResponse.setStatus("SUCCESS");
		}
		return usersResponse;
	}
	
	public UserAdminResponse addUser(UserAdminRequest userAdminRequest){
		
		UserAdminResponse response = new UserAdminResponse();
		
		if(isValidAddUserRequest(userAdminRequest)){	
			if("USER_ADDED".equalsIgnoreCase(userDao.addUser(mapUserUI(userAdminRequest.getUser())))){
				response.setUser(userAdminRequest.getUser());
				response.setStatus("SUCCESS");
				response.setMessage("USER_ADDED");
			}else{
				response.setUser(userAdminRequest.getUser());
				response.setStatus("ERROR");
				response.setMessage("ERROR_ADDING_USER");
			}
		}else{
			response.setUser(userAdminRequest.getUser());
			response.setStatus("VALIDATION_ERROR");
			response.setMessage("Invalid user details");
		}
		return response;
	}
	
	private boolean isValidAddUserRequest(UserAdminRequest userAdminRequest){
		
		boolean nullProperty = false;
		
		if(userAdminRequest.getUser().getUsername()==null || "".equals(userAdminRequest.getUser().getUsername())){
			nullProperty = true;
		}else if(userAdminRequest.getUser().getPassword()==null || "".equals(userAdminRequest.getUser().getPassword())){
			nullProperty = true;
		}else if(userAdminRequest.getUser().getForename()==null || "".equals(userAdminRequest.getUser().getForename())){
			nullProperty = true;
		}else if(userAdminRequest.getUser().getSurname()==null || "".equals(userAdminRequest.getUser().getSurname())){
			nullProperty = true;
		}else if(userAdminRequest.getUser().getEmail()==null || "".equals(userAdminRequest.getUser().getEmail())){
			nullProperty = true;
		}else{
			nullProperty = false;
		}
		
		if(nullProperty){
			return false; //there is a null property
		}else{
			return true; //properties are valid
		}
	}
	
	private boolean isValidUserRequest(UserRequest userRequest){
		
		if(userRequest.getUsername()!=null && !"".equals(userRequest.getUsername())){
			return true;
		}else if(userRequest.getEmail()!=null && !"".equals(userRequest.getEmail())){
			return true;
		}else if(userRequest.getFirstname()!=null && !"".equals(userRequest.getFirstname())){
			return true;
		}else if(userRequest.getLastname()!=null && !"".equals(userRequest.getLastname())){
			return true;
		}else{
			return false;
		}
	}
	
	private List<UserUI> mapUsers(List<User> dbUsers){
		
		List<UserUI> users = new LinkedList<UserUI>();
		
		UserUI userUI; 
		
		for(User dbUser : dbUsers){
			userUI = new UserUI();
			userUI.setUsername(dbUser.getUsername());
			userUI.setForename(dbUser.getFirstname());
			userUI.setSurname(dbUser.getSurname());
			userUI.setEmail(dbUser.getEmail());
			users.add(userUI);
		}
		return users;
	}
	
	private User mapUserUI(UserUI userUI){
		
		User user = new User();
		user.setUsername(userUI.getUsername());
		user.setFirstname(userUI.getForename());
		user.setSurname(userUI.getSurname());
		user.setEmail(userUI.getEmail());
		
		return user;
	}
}
