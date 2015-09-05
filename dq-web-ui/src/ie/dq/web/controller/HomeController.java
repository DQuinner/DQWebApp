package ie.dq.web.controller;

import ie.dq.web.common.model.UserUI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("loggedOnUser")
public class HomeController {
	
	@RequestMapping(value = "/home**", method = RequestMethod.GET)
	public ModelAndView home(@ModelAttribute("SpringWeb")UserUI user, ModelMap model) {
		
		return new ModelAndView("home", "command", user);
		
	}
}