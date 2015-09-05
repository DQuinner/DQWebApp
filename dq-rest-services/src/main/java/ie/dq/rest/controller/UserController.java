package ie.dq.rest.controller;

import java.util.LinkedList;
import java.util.List;

import ie.dq.dao.UserDao;
import ie.dq.dao.model.User;
import ie.dq.web.common.model.UserUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/angularjs-demo", method = RequestMethod.GET)
	public ModelAndView angularDemoPage(ModelMap model) {
		
		return new ModelAndView("AngularDemoPage");
		
	}
	
	@RequestMapping(value = "users/all", method = RequestMethod.GET)
	public @ResponseBody List<UserUI> getAllUsers(ModelMap model){
		
		return mapUsers(userDao.getUsers());
		
	}
	
	@RequestMapping(value = "users/{username}", method = RequestMethod.GET)
	public @ResponseBody UserUI getUserDetails(@PathVariable("username") String username){
		
		User user = userDao.getByUsername(username);
			
		UserUI userUI = new UserUI();
		
		if(user!=null){
			
			userUI.setUsername(user.getUsername());
			userUI.setForename(user.getForename());
			userUI.setSurname(user.getSurname());
			userUI.setEmail(user.getEmail());
			userUI.setPassword(user.getPassword());
			
		}
		
		return userUI;
	}
	
	@RequestMapping(value = "users/new", method = RequestMethod.POST)
	public @ResponseBody UserUI addUser(@RequestBody UserUI userUI){
		
		if("USER_ADDED".equalsIgnoreCase(userDao.addUser(mapUser(userUI)))){
			return userUI;
		}else{
			return new UserUI();
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
	
	private User mapUser(UserUI userUI){
		
		User user = new User(); 
		user.setEmail(userUI.getEmail());
		user.setForename(userUI.getForename());
		user.setPassword(userUI.getPassword());
		user.setSurname(userUI.getSurname());
		user.setUsername(userUI.getUsername());
		return user;
	}

}
