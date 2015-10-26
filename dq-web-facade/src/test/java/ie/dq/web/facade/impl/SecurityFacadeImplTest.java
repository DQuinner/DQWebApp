package ie.dq.web.facade.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import ie.dq.config.DaoFacadeConfig;
import ie.dq.dao.UserDao;
import ie.dq.dao.UserRoleDao;
import ie.dq.dao.model.User;
import ie.dq.dao.model.UserRole;
import ie.dq.web.common.model.UserUI;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoFacadeConfig.class, loader = AnnotationConfigContextLoader.class)
@Transactional
@ActiveProfiles("dao")
public class SecurityFacadeImplTest {
	
	private final static String ADMIN_USER = "admin_facade";
	private final static String INVALID_USER = "invalid_facade";

	@Autowired
	SecurityFacadeImpl securityFacade;
	
	@Autowired
	UserFacadeImpl userFacade;
	
	@Autowired
	UserRoleDao userRoleDao;
	
	@Autowired
	UserDao userDao;
	
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
		assertNotNull(securityFacade);
		assertNotNull(userRoleDao);
		assertNotNull(userDao);
	}
	
	@Test
	public void testGetUserPassword(){
		userFacade.addUser(adminUser);
		assertEquals("password", securityFacade.getUserPassword(ADMIN_USER));
	}
	
	public void testGetInvalidUserPassword(){
		assertNull(securityFacade.getUserPassword(INVALID_USER));
	}
	
	@Test
	public void testGetAdminUserAuthorities(){
		//setup user roles
		userFacade.addUser(adminUser);
		User dbUser = userDao.getByUsername(adminUser.getUsername());
		UserRole role = new UserRole();
		role.setUserId(dbUser.getId());
		role.setUsername(adminUser.getUsername());
		role.setRole("ROLE_USER");
		userRoleDao.addUserRole(role);
		role = new UserRole();
		role.setUserId(dbUser.getId());
		role.setUsername(adminUser.getUsername());
		role.setRole("ROLE_ADMIN");
		userRoleDao.addUserRole(role);
		//test
		List<String> adminRoles = securityFacade.getUserAuthorities(ADMIN_USER);
		assertNotNull(adminRoles);
		assertTrue(adminRoles.size()==2);
		assertTrue(adminRoles.contains("ROLE_USER"));
		assertTrue(adminRoles.contains("ROLE_ADMIN"));
	}
	
	@Test
	public void testGetInvalidUserAuthorities(){
		List<String> adminRoles = securityFacade.getUserAuthorities(INVALID_USER);
		assertTrue(adminRoles.isEmpty());
	}
}
