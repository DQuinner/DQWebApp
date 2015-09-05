package ie.dq.web.controller;

import java.util.LinkedList;
import java.util.List;

import ie.dq.web.common.model.UserUI;
import ie.dq.web.exception.UserFormException;
import ie.dq.web.facade.UserFacade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("loggedOnUser") //only stays in session until conversation ends!
public class LoginController {
	
	@Autowired
	private UserFacade userFacade;
	
	private UserUI loggedOnUser;
	
	/** 
	 * Passed a blank User object in the ModelAndView object with name "command" 
	 * because the spring framework expects an object with name "command" if you 
	 * are using <form:form> tags in your JSP file. 
	 * When login() method is called it returns login.jsp view.
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		
		return new ModelAndView("login", "command", new UserUI());
	}
	
	@RequestMapping(value = "/signIn", method = RequestMethod.GET)
	public ModelAndView signIn(Authentication authentication) {
			
		User user = (User) authentication.getPrincipal();
				
		if(user.getUsername()!=null){
			loggedOnUser = userFacade.getUserDetails(user.getUsername());
		}
		
		if(loggedOnUser!=null){
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("loggedOnUser", loggedOnUser);
			modelAndView.setViewName("home");
			return modelAndView;
		}else{
			List<String> inputErrors = new LinkedList<String>();
			inputErrors.add("Could not find user details for "+user.getUsername());
			throw new UserFormException(inputErrors);
		}
	}
}
