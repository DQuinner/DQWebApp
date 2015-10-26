package ie.dq.web.security;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ie.dq.web.facade.SecurityFacade;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SecurityFacade securityFacade;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		String password = securityFacade.getUserPassword(username);
		
		if(password!=null){
			List<String> authorities = securityFacade.getUserAuthorities(username);
			if(!authorities.isEmpty()){
				return new User(username, password, true, true, true, true, grantRoleAuthorities(authorities));
			}else{
				throw new UsernameNotFoundException(username);
			}
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
