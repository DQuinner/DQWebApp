package ie.dq.dao;

import junit.framework.Assert;
import ie.dq.dao.UserDao;
import ie.dq.dao.model.User;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:testDaoApplicationContext.xml")
public class TestUserDao {

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	private User user;
	
	@Before
	public void onSetup(){
		user = new User();
		userDao = new UserDao();
	}
	
	@Test
	public void test() {
		//user.setUserId(1);
		user.setUsername("dquinner");
		user.setEmail("donalq@gmail.com");
		user.setPassword("12345678");
		user.setForename("Donal");
		user.setSurname("Quinn");
		String result = userDao.addUser(user);
		Assert.assertEquals("USER_ADDED", result);
	}

}
