package ie.dq.stub.facade.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import ie.dq.web.facade.SecurityFacade;

@Service
public class SecurityFacadeStub implements SecurityFacade {
	
	public String getUserPassword(String username){
		if("adminstubber".equalsIgnoreCase(username) 
				|| "basicstubber".equalsIgnoreCase(username)){
			return "password";
		}else{
			return null;
		}
	
	}
	
	public List<String> getUserAuthorities(String username){
		
		List<String> authorities = new LinkedList<String>();
		
		if("adminstubber".equalsIgnoreCase(username)){
			authorities.add("ROLE_USER");
			authorities.add("ROLE_ADMIN");
		}else if("basicstubber".equalsIgnoreCase(username)){
			authorities.add("ROLE_USER");
		}else{
			return null;
		}
		return authorities;
		
	}
	
}
