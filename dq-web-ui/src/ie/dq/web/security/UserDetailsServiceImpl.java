package ie.dq.web.security;

import java.util.LinkedList;
import java.util.List;

import ie.dq.web.facade.SecurityFacade;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

	private SecurityFacade securityFacade;
	
	public void setSecurityFacade(SecurityFacade securityFacade) {
		this.securityFacade = securityFacade;
	}

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		String password = securityFacade.getUserPassword(username);
		
		if(password!=null){
			return new User(username, password, true, true, true, true, 
					grantRoleAuthorities(securityFacade.getUserAuthorities(username)));
		}else{
			throw new UsernameNotFoundException(username);
		}
	}
	
	private List<UserRole> grantRoleAuthorities(List<String> authorities){
		
		List<UserRole> userRoles = new LinkedList<UserRole>();
		
		for(String authority : authorities){
			userRoles.add(new UserRole(authority));
		}
		
		return userRoles;
	}
}
