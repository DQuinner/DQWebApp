/**
 * 
 */
package ie.dq.dao;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import ie.dq.dao.model.User;
import ie.dq.dao.model.UserRole;

import org.springframework.orm.hibernate3.HibernateTemplate;
/**
 * @author Donal
 *
 */
public class UserDao {
	
	private static final String USER_ADDED = "USER_ADDED";
	private static final String USER_DELETED = "USER_DELETED";
	private static final String USER_ROLE_ADDED = "USER_ROLE_ADDED"; 
	
	HibernateTemplate template;  
	
	public void setTemplate(HibernateTemplate template) {  
	    this.template = template;  
	}  
	
	public String addUser(User user){
		template.save(user);
		return USER_ADDED;
	}
	
	public String deleteUser(User user){
		template.delete(user);
		return USER_DELETED;
	}
	
	//method to return one user of given id  
	public User getById(int user_id){  
		User user =(User)template.get(User.class,user_id);  
	    return user;  
	}
	
	public User getByUsername(String username){  
		
		//User user =(User)template.get(User.class,username);
		//TODO implement HQL query?
		List<User> allUsers = getUsers();
		for(User user : allUsers){
			if(username.equalsIgnoreCase(user.getUsername())){
				return user;
			}
		}
		return null;
	}
	
	//method to return all users  
	public List<User> getUsers(){  
	    List<User> list=new ArrayList<User>();  
	    list=template.loadAll(User.class); 
	    return list;  
	}
	
	public String addUserRole(UserRole userRole){
		template.save(userRole);
		return USER_ROLE_ADDED;
	}
	
	public List<UserRole> getUserRoles(){  
	    List<UserRole> list=new ArrayList<UserRole>();  
	    list=template.loadAll(UserRole.class);  
	    return list;  
	}
	
	//TODO implement HQL query?
	public List<String> getUserAuthorities(String username){
		
		List<UserRole> userRoles = template.loadAll(UserRole.class);
	    List<String> authorities = new LinkedList<String>();
	    
		for(UserRole role : userRoles){
			if(username.equalsIgnoreCase(role.getUsername())){
				authorities.add(role.getRole());
			}
	    }
		return authorities;
	}
}
