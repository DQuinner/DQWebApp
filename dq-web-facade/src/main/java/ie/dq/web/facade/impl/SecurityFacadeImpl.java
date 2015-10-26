package ie.dq.web.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.dq.dao.UserDao;
import ie.dq.dao.UserRoleDao;
import ie.dq.web.facade.SecurityFacade;

@Service
public class SecurityFacadeImpl implements SecurityFacade{
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserRoleDao userRoleDao;

	public String getUserPassword(String username){
		return userDao.getUserPassword(username);
	}
	
	public List<String> getUserAuthorities(String username){
		
		return userRoleDao.getUserAuthorities(username);
		
	}
	
}
