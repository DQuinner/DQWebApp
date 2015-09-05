package ie.dq.web.controller;

import java.util.List;

import ie.dq.web.common.model.UserUI;
import ie.dq.web.facade.UserFacade;

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
public class UserAdminController {
	
	@Autowired
	private UserFacade userFacade;
	
	@RequestMapping(value = "/user-admin/all", method = RequestMethod.GET)
	public @ResponseBody List<UserUI> getAllUsers(ModelMap model){
		
		return userFacade.getAllUsers();
		
	}
	
	@RequestMapping(value = "/user-admin**", method = RequestMethod.GET)
	public ModelAndView userAdmin() {
		ModelAndView modelAndView = new ModelAndView("user-admin");
		return modelAndView;
	}
	
	/**
	 * Provide the details of a user with the given username in JSON.
	 */
	@RequestMapping(value = "/user-admin/{username}", method = RequestMethod.GET)
	public @ResponseBody UserUI userDetails(@PathVariable("username") String username) {
		return userFacade.getUserDetails(username);
	}
	
	@RequestMapping(value = "user-admin/new", method = RequestMethod.POST)
	public @ResponseBody UserUI addUser(@RequestBody UserUI userUI){
		
		if("USER_ADDED".equalsIgnoreCase(userFacade.addUser(userUI))){
			return userUI;
		}else{
			return new UserUI();
		}
	
	}
	
}
