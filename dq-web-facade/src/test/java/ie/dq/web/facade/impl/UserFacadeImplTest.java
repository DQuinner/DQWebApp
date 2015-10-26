package ie.dq.web.facade.impl;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import ie.dq.config.DaoFacadeConfig;
import ie.dq.web.common.model.UserUI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoFacadeConfig.class, loader = AnnotationConfigContextLoader.class)
@Transactional
@ActiveProfiles("dao")
public class UserFacadeImplTest {
	
	@Autowired
	UserFacadeImpl userFacade;
	
	private UserUI basicUser;
	private UserUI adminUser;
	
	@Before
	public void setupUsers(){
		basicUser = new UserUI();
		basicUser.setEmail("basicfacade@junit.com");
		basicUser.setForename("basic");
		basicUser.setSurname("facade");
		basicUser.setUsername("basic_facade");
		basicUser.setPassword("password");
		
		adminUser = new UserUI();
		adminUser.setEmail("adminfacade@junit.com");
		adminUser.setForename("admin");
		adminUser.setSurname("facade");
		adminUser.setUsername("admin_facade");
		adminUser.setPassword("password");
	}
	
	@Test
	public void testInit(){
		assertNotNull(userFacade);
	}
	
	@Test
	public void testAddUser(){
		assertEquals("USER_ADDED", userFacade.addUser(basicUser));	
	}
	
	@Test
	public void testAddNullUser(){
		assertNull(userFacade.addUser(null));	
	}
	
	@Test
	public void testGetUserDetails(){
		userFacade.addUser(basicUser);
		UserUI testUser = userFacade.getUserDetails(basicUser.getUsername());
		assertEquals(basicUser.getForename(),testUser.getForename());
		assertEquals(basicUser.getSurname(),testUser.getSurname());
		assertEquals(basicUser.getEmail(),testUser.getEmail());
		assertEquals(basicUser.getUsername(),testUser.getUsername());
		assertNull(testUser.getPassword());
	}
	
	@Test
	public void testGetInvalidUserDetails(){
		UserUI testUser = userFacade.getUserDetails("invalid_facade");
		assertNull(testUser.getForename());
		assertNull(testUser.getSurname());
		assertNull(testUser.getEmail());
		assertNull(testUser.getUsername());
		assertNull(testUser.getPassword());
	}
	
	@Test
	public void testGetAllUsers(){
		userFacade.addUser(basicUser);
		userFacade.addUser(adminUser);
		List<UserUI> testUsers = userFacade.getAllUsers();
		assertNotNull(testUsers);
		assertTrue("Test there is at least 2 users", testUsers.size()>=2);
	}

}
