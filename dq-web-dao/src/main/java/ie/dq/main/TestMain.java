package ie.dq.main;

import java.util.List;

import ie.dq.dao.UserDao;
import ie.dq.dao.model.User;
import ie.dq.dao.model.UserRole;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestMain {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Resource r=new ClassPathResource("daoApplicationContext.xml");  
	    BeanFactory factory=new XmlBeanFactory(r);
	      
	    UserDao userDao=(UserDao)factory.getBean("userDao");  
	    
	    User user = null;
		//user.setUsername("dquinner");
		//user.setEmail("donalq@gmail.com");
		//user.setPassword("12345678");
		//user.setForename("Donal");
		//user.setSurname("Quinn");

	    /*UserRole userRole = new UserRole();
	    userRole.setUser_id(42);
	    userRole.setUsername("dquinner");
	    userRole.setRole("ROLE_USER");
		String result = userDao.addUserRole(userRole);
		System.out.println(result + " dquinner "+"ROLE_USER");
		
	    userRole.setUser_id(43);
	    userRole.setUsername("dquinner2");
	    userRole.setRole("ROLE_USER");
	    String result = userDao.addUserRole(userRole);
		System.out.println(result + " dquinner "+"ROLE_USER");
		
		userRole.setUser_id(43);
	    userRole.setUsername("dquinner2");
	    userRole.setRole("ROLE_ADMIN");
		result = userDao.addUserRole(userRole);
		System.out.println(result + " dquinner "+"ROLE_ADMIN");*/

	    /*List<UserRole> roles = userDao.getUserRoles();
	    for(UserRole role : roles){
	    	System.out.println("Role id "+role.getUser_role_id());
	    	System.out.println("username "+role.getUsername());
	    	System.out.println("Role "+role.getRole());
	    }*/
	    
	    for(String authority_role : userDao.getUserAuthorities("dquinner2")){
	    	System.out.println(authority_role);
	    }
	    
		/*for(int i=0; i<=5; i++){
			result = userDao.addUser(user);  
			System.out.println("Result = "+result);
		}*/
		  
		/*List<User> users = userDao.getUsers();
	
		for(User retrievedUser : users){
			
			System.out.println("Retrieved Username = "+retrievedUser.getUsername());
			System.out.println("Password = "+retrievedUser.getPassword());
			System.out.println("Retrieved Id = "+retrievedUser.getUser_id());
			
			//result = userDao.deleteUser(retrievedUser);  
			//System.out.println("Result = "+result);
		}
		
		//user = userDao.getByUsername("dquinner");
		//System.out.println("Retrieved Username = "+user.getUsername());
		//System.out.println("Retrieved Id = "+user.getUser_id());
		//System.out.println("Retrieved Email = "+user.getEmail());
		//System.out.println("Retrieved Name = "+user.getForename()+" "+user.getSurname()); */
		
	}
}
