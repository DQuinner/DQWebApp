package ie.dq.web.facade;

import java.util.List;

public interface SecurityFacade {

	public String getUserPassword(String username);
	
	public List<String> getUserAuthorities(String username);
		
}
