package ie.dq.web.service;

import java.util.List;

import ie.dq.dao.UserDao;
import ie.dq.dao.UserRoleDao;
import ie.dq.dao.model.User;
import ie.dq.web.service.model.RolesResponse;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@WebService
public class DQSecurityServiceImpl implements DQSecurityService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;
	
	public String getUserPassword(String username){
		
		User user = userDao.getByUsername(username);
		
		if(user!=null){
			return user.getPassword();
		}else{
			return "USER_NOT_FOUND";
		}
	}
	
	public RolesResponse getUserAuthorities(String username){
		
		RolesResponse response = new RolesResponse();
		
		List<String> authorities = userRoleDao.getUserAuthorities(username);
		response.setUserRoles(authorities);
		response.setNumRoles(authorities.size());
		return response;
	}
}
