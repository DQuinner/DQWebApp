package ie.dq.dao.user;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import ie.dq.dao.UserDao;
import ie.dq.dao.UserRoleDao;
import ie.dq.dao.config.DaoConfig;
import ie.dq.dao.model.User;
import ie.dq.dao.model.UserRole;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class, loader = AnnotationConfigContextLoader.class)
@Transactional
public class UserRoleDaoTest {
	
	private final static String USER = "ROLE_USER";
	private final static String ADMIN = "ROLE_ADMIN";
	private final static String INVALID = "ROLE_INVALID";
			
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private UserDao userDao;
	
	private User testUser;
	private UserRole userRole;
	private UserRole adminRole;
	
	@Before
	public void reset(){
		userRole = new UserRole();
		userRole.setUsername("junit_role_tester");
		userRole.setRole(USER);
		
		adminRole = new UserRole();
		adminRole.setUsername("junit_role_tester");
		adminRole.setRole(ADMIN);
		
		testUser = new User();
		testUser.setUsername("junit_role_tester");
		testUser.setFirstname("junit");
		testUser.setSurname("test");
		testUser.setPassword("password");
		testUser.setEmail("junit@test.com");
	}
	
	@Test
	public void testInit() {
		assertNotNull(userRoleDao);
	}
	
	@Test
	public void testAddUserRole(){
		userDao.addUser(testUser);
		userRole.setUserId(userDao.getByUsername(testUser.getUsername()).getId());
		userRoleDao.addUserRole(userRole);
	}
	
	@Test
	public void testAddAdminRole(){
		userDao.addUser(testUser);
		adminRole.setUserId(userDao.getByUsername(testUser.getUsername()).getId());
		userRoleDao.addUserRole(adminRole);
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testAddInvalidRole(){
		userDao.addUser(testUser);
		userRole.setUserId(userDao.getByUsername(testUser.getUsername()).getId());
		userRole.setId(0);
		userRole.setRole(INVALID);
		userRoleDao.addUserRole(userRole);
	}
	
	@Test(expected=ConstraintViolationException.class)
	public void testAddUserRoleInvalidUser(){
		userRole.setUsername("junit_invalid_user");
		userRoleDao.addUserRole(userRole);
	}
	
	@Test
	public void testGetUserAuthorities(){
		userDao.addUser(testUser);
		
		userRole.setUserId(userDao.getByUsername(testUser.getUsername()).getId());
		userRoleDao.addUserRole(userRole);
		adminRole.setUserId(userDao.getByUsername(testUser.getUsername()).getId());
		userRoleDao.addUserRole(adminRole);
		
		List<String> userRoles = userRoleDao.getUserAuthorities(testUser.getUsername());
		assertNotNull(userRoles);
		assertFalse(userRoles.isEmpty());
		assertTrue("Test user has role user", userRoles.contains(USER));
		assertTrue("Test user has role admin", userRoles.contains(ADMIN));
	}
	
	@Test
	public void testGetUserAuthoritiesInvalidUser(){
		List<String> userRoles = userRoleDao.getUserAuthorities(null);
		assertTrue(userRoles.isEmpty());
	}

}
