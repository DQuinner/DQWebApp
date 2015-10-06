package ie.dq.web.facade.stub;

import java.util.LinkedList;
import java.util.List;

import ie.dq.web.facade.SecurityFacade;

public class SecurityFacadeStub implements SecurityFacade {
	
	public String getUserPassword(String username){
		return "password";
	}
	
	public List<String> getUserAuthorities(String username){
		
		List<String> authorities = new LinkedList<String>();
		
		if("adminstubber".equalsIgnoreCase(username)){
			authorities.add("ROLE_USER");
			authorities.add("ROLE_ADMIN");
		}else{
			authorities.add("ROLE_USER");
		}
		return authorities;
		
	}
	
}
