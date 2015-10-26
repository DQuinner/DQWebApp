package ie.dq.web.facade.stub;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import ie.dq.config.StubFacadeConfig;
import ie.dq.stub.facade.impl.SecurityFacadeStub;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StubFacadeConfig.class, loader = AnnotationConfigContextLoader.class)
@ActiveProfiles("stub")
public class SecurityFacadeStubTest {
	
	private final static String BASIC_USER = "basicstubber";
	private final static String ADMIN_USER = "adminstubber";
	private final static String INVALID_USER = "invalidstubber";

	@Autowired
	SecurityFacadeStub securityFacade;
	
	@Test
	public void testInit(){
		assertNotNull(securityFacade);
	}
	
	@Test
	public void testGetBasicUserPassword(){
		assertEquals("password", securityFacade.getUserPassword(BASIC_USER));
	}
	
	@Test
	public void testGetAdminUserPassword(){
		assertEquals("password", securityFacade.getUserPassword(ADMIN_USER));
	}
	
	@Test
	public void testGetInvalidUserPassword(){
		assertNull(securityFacade.getUserPassword(INVALID_USER));
	}
	
	@Test
	public void testGetBasicUserAuthorities(){
		List<String> basicRoles = securityFacade.getUserAuthorities(BASIC_USER);
		assertNotNull(basicRoles);
		assertTrue(basicRoles.size()==1);
		assertTrue(basicRoles.contains("ROLE_USER"));
	}
	
	@Test
	public void testGetAdminUserAuthorities(){
		List<String> adminRoles = securityFacade.getUserAuthorities(ADMIN_USER);
		assertNotNull(adminRoles);
		assertTrue(adminRoles.size()==2);
		assertTrue(adminRoles.contains("ROLE_USER"));
		assertTrue(adminRoles.contains("ROLE_ADMIN"));
	}
	
	@Test
	public void testGetInvalidUserAuthorities(){
		List<String> adminRoles = securityFacade.getUserAuthorities(INVALID_USER);
		assertNull(adminRoles);
	}
}
