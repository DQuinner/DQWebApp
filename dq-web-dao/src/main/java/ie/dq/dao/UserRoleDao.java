package ie.dq.dao;

import java.util.List;

import ie.dq.dao.model.UserRole;

public interface UserRoleDao {
	
	public void addUserRole(UserRole userRole);
	
	public List<String> getUserAuthorities(String username);

}
