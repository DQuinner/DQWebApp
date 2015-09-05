package ie.dq.web.service;

import java.util.LinkedList;
import java.util.List;

import javax.jws.WebService;

import ie.dq.dao.UserDao;
import ie.dq.dao.model.User;
import ie.dq.web.common.model.UserUI;
import ie.dq.web.service.model.UserAdminRequest;
import ie.dq.web.service.model.UserAdminResponse;
import ie.dq.web.service.model.UserRequest;
import ie.dq.web.service.model.UserDetailsResponse;
import ie.dq.web.service.model.UsersResponse;

@WebService
public class DQUserServiceImpl implements DQUserService {
	
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

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
				userUI.setForename(user.getForename());
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
			users = mapUsers(userDao.getUsers());
			usersResponse.setUsers(users);
			usersResponse.setUsersCount(users.size());
			usersResponse.setStatus("SUCCESS");
		}else{
			if(isValidUserRequest(userRequest)){
				users = getMockedUsers();
				usersResponse.setUsers(users);
				usersResponse.setUsersCount(users.size());
				usersResponse.setStatus("SUCCESS");
			}else{
				usersResponse.setStatus("ERROR");
				usersResponse.setErrorMsg("You must supply a username,email,firstname or lastname");
			}
		}
		
		return usersResponse;
	}
	
	public UserAdminResponse addUser(UserAdminRequest userAdminRequest){
		
		UserAdminResponse response = new UserAdminResponse();
		
		if(isValidAddUserRequest(userAdminRequest)){
			
			//ADD USER HERE
			response.setUser(userAdminRequest.getUser());
			response.setStatus("SUCCESS");
			response.setMessage("USER_ADDED");
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
			userUI.setForename(dbUser.getForename());
			userUI.setSurname(dbUser.getSurname());
			userUI.setEmail(dbUser.getEmail());
			users.add(userUI);
		}
		return users;
	}
	
	private List<UserUI> getMockedUsers(){
		List<UserUI> users = new LinkedList<UserUI>();
		UserUI userUI = new UserUI();
		
		userUI.setUsername("mocker1");
		userUI.setForename("Mocky");
		userUI.setSurname("Mocked");
		userUI.setEmail("mockuser1@mocked.com");
		users.add(userUI);

		userUI.setUsername("mocker2");
		userUI.setForename("Mocky2");
		userUI.setSurname("Mocked2");
		userUI.setEmail("mockuser2@mocked.com");
		users.add(userUI);

		userUI.setUsername("mocker3");
		userUI.setForename("Mocky3");
		userUI.setSurname("Mocked3");
		userUI.setEmail("mockuser3@mocked.com");
		users.add(userUI);
		
		return users;
	}
}
