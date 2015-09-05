package ie.dq.web.facade;

import ie.dq.web.service.DQSecurityService;
import ie.dq.web.service.model.RolesResponse;

import java.util.LinkedList;
import java.util.List;

public class SecurityFacade {
	
	private DQSecurityService securityService;
	
	public void setSecurityService(DQSecurityService securityService) {
		this.securityService = securityService;
	}

	public String getUserPassword(String username){
		String password = securityService.getUserPassword(username) ; //userDao.getByUsername(username);
		if("USER_NOT_FOUND".equalsIgnoreCase(password)){
			return null;
		}else{
			return password;
		}
	}
	
	public List<String> getUserAuthorities(String username){
		
		List<String> authorities = new LinkedList<String>();
		
		RolesResponse response = securityService.getUserAuthorities(username);
		
		if(response.getNumRoles()>0){
			return response.getUserRoles();
		}else{
			return authorities;
		}
	}
}
