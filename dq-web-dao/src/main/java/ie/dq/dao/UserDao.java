package ie.dq.dao;

import java.util.List;

import ie.dq.dao.model.User;

public interface UserDao {
	
	public String addUser(User user);
	
	public String deleteUser(User user);
  
	public User getByUsername(String username);
	
	public int deleteByUsername(String username);
	  
	public List<User> getAllUsers();
	
	public String getUserPassword(String username);
	
}
