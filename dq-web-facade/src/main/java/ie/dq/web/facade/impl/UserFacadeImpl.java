package ie.dq.web.facade.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dq.dao.UserDao;
import ie.dq.dao.model.User;
import ie.dq.web.common.model.UserUI;
import ie.dq.web.facade.UserFacade;

@Service
public class UserFacadeImpl implements UserFacade{
	
	@Autowired
	private UserDao userDao;

	public String addUser(UserUI userUI){
		try{
			return userDao.addUser(mapUserUI(userUI));
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	public UserUI getUserDetails(String username){
		
		UserUI userUI = new UserUI();
		User user = userDao.getByUsername(username);
		if(user!=null){
			userUI.setUsername(user.getUsername());
			userUI.setForename(user.getFirstname());
			userUI.setSurname(user.getSurname());
			userUI.setEmail(user.getEmail());
		}
		
		return userUI;
	}
	
	public List<UserUI> getAllUsers(){
		
		return mapUsers(userDao.getAllUsers());
	}
	
	private User mapUserUI(UserUI userUI){
		
		User user = new User();
		user.setUsername(userUI.getUsername());
		user.setPassword(userUI.getPassword());
		user.setFirstname(userUI.getForename());
		user.setSurname(userUI.getSurname());
		user.setEmail(userUI.getEmail());
		
		return user;
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
	
}
