package ie.dq.web.controller;

import ie.dq.web.common.model.UserUI;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MediaController {
	
	@RequestMapping(value = "/media", method = RequestMethod.GET)
	public ModelAndView media(@ModelAttribute("SpringWeb")UserUI user, ModelMap model) {
		
		return new ModelAndView("media", "command", user);
	}

}
