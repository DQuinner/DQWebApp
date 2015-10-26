package ie.dq.web.facade.stub;

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

import ie.dq.config.StubFacadeConfig;
import ie.dq.stub.facade.impl.UserFacadeStub;
import ie.dq.web.common.model.UserUI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StubFacadeConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("stub")
public class UserFacadeStubTest {

	@Autowired
	private UserFacadeStub userFacade;
	
	private UserUI basicUser;
	private UserUI adminUser;
	
	@Before
	public void setupUsers(){
		basicUser = new UserUI();
		basicUser.setEmail("basic@stub.com");
		basicUser.setForename("basic");
		basicUser.setSurname("stub");
		basicUser.setUsername("basicstubber");
		basicUser.setPassword("password");
		
		adminUser = new UserUI();
		adminUser.setEmail("admin@stub.com");
		adminUser.setForename("admin");
		adminUser.setSurname("stub");
		adminUser.setUsername("adminstubber");
		adminUser.setPassword("password");
	}
	
	@Test 
	public void initTest(){
		
		assertNotNull(userFacade);
		
	}
	
	@Test
	public void testAddUser(){
		assertEquals("USER_ADDED", userFacade.addUser(basicUser));	
	}
	
	@Test
	public void testGetBasicUserDetails(){
		UserUI testUser = userFacade.getUserDetails("basicstubber");	
		assertEquals(basicUser.getForename(),testUser.getForename());
		assertEquals(basicUser.getSurname(),testUser.getSurname());
		assertEquals(basicUser.getEmail(),testUser.getEmail());
		assertEquals(basicUser.getUsername(),testUser.getUsername());
		assertEquals(basicUser.getPassword(),testUser.getPassword());
	}
	
	@Test
	public void testGetAdminUserDetails(){
		UserUI testUser = userFacade.getUserDetails("adminstubber");	
		assertEquals(adminUser.getForename(),testUser.getForename());
		assertEquals(adminUser.getSurname(),testUser.getSurname());
		assertEquals(adminUser.getEmail(),testUser.getEmail());
		assertEquals(adminUser.getUsername(),testUser.getUsername());
		assertEquals(adminUser.getPassword(),testUser.getPassword());
	}
	
	@Test
	public void testGetInvalidUserDetails(){
		UserUI testUser = userFacade.getUserDetails(null);	
		assertNull(testUser.getForename());
		assertNull(testUser.getSurname());
		assertNull(testUser.getEmail());
		assertNull(testUser.getUsername());
		assertNull(testUser.getPassword());
	}

	@Test
	public void testGetAllUsers(){
		List<UserUI> testUsers = userFacade.getAllUsers();	
		assertNotNull(testUsers);
		assertEquals("Test for 2 users in list", 2, testUsers.size());
	}
	
}
