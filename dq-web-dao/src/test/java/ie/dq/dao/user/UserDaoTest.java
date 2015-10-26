package ie.dq.dao.user;

import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.PropertyValueException;
import org.hibernate.exception.ConstraintViolationException;

import ie.dq.dao.UserDao;
import ie.dq.dao.config.DaoConfig;
import ie.dq.dao.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DaoConfig.class, loader = AnnotationConfigContextLoader.class)
@Transactional
public class UserDaoTest {

	private static String GET_USERNAME = "junit_get";
	private static String DUPLICATE_USERNAME = "junit_duplicate";
	private static String DELETE_USERNAME = "junit_delete";
	private static String INVALID_USERNAME = "junit_invalid";

	@Autowired
	private UserDao userDao;

	private User testUser;
	private User duplicateUser;

	@Before
	public void resetTestUsers() {
		testUser = new User();
		testUser.setId(0);
		testUser.setUsername("junit_tester");
		testUser.setFirstname("junit");
		testUser.setSurname("test");
		testUser.setPassword("password");
		testUser.setEmail("junit@test.com");

		duplicateUser = new User();
		duplicateUser.setUsername(DUPLICATE_USERNAME);
		duplicateUser.setFirstname("junit");
		duplicateUser.setSurname("test");
		duplicateUser.setPassword("password");
		duplicateUser.setEmail("junit@test.com");
	}

	@Test
	public void testInit() {
		assertNotNull(userDao);
	}

	@Test
	public void testAddUser() {
		userDao.addUser(testUser);
	}

	@Test(expected = ConstraintViolationException.class)
	public void testAddDuplicateUser() {
		testUser.setUsername(DUPLICATE_USERNAME);
		userDao.addUser(testUser);
		userDao.addUser(duplicateUser);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testAddNullUser() {
		userDao.addUser(null);
	}

	@Test(expected = PropertyValueException.class)
	public void testAddNoUsernameUser() {
		testUser.setUsername(null);
		userDao.addUser(testUser);
	}

	@Test
	public void testGetUserByUsername() {
		testUser.setUsername(GET_USERNAME);
		userDao.addUser(testUser);
		User dbUser = userDao.getByUsername(GET_USERNAME);
		assertNotNull(dbUser);
		assertNotNull(dbUser.getId());
		assertNotNull(dbUser.getEmail());
		assertNotNull(dbUser.getPassword());
		assertNotNull(dbUser.getFirstname());
		assertNotNull(dbUser.getSurname());
		assertEquals("Test the correct user was returned", GET_USERNAME, dbUser.getUsername());
	}

	@Test
	public void testGetUserByInvalidUsername() {
		User dbUser = userDao.getByUsername(null);
		assertNull(dbUser);
	}

	@Test
	public void testDeleteUserByUsername() {
		testUser.setUsername(DELETE_USERNAME);
		userDao.addUser(testUser);
		int numDeleted = userDao.deleteByUsername(DELETE_USERNAME);
		assertEquals("Check one user was deleted", 1, numDeleted);
	}

	@Test
	public void testDeleteUserByInvalidUsername() {
		int numDeleted = userDao.deleteByUsername(null);
		assertEquals("Check no user was deleted", 0, numDeleted);
	}

	@Test
	public void testDelete() {
		testUser.setUsername(DELETE_USERNAME);
		userDao.addUser(testUser);
		userDao.deleteUser(testUser);
	}

	@Test
	public void testGetAllUsers() {

		userDao.addUser(testUser);
		userDao.addUser(duplicateUser);

		List<User> allUsers = userDao.getAllUsers();

		assertNotNull(allUsers);
		assertTrue("Test for 2 or more users", allUsers.size() > 2);
	}
	
	@Test
	public void testGetUserPassword() {

		userDao.addUser(testUser);

		String password = userDao.getUserPassword(testUser.getUsername());

		assertNotNull(password);
		assertEquals(testUser.getPassword(), password);
	}
	
	@Test
	public void testGetInvalidUserPassword() {

		assertNull(userDao.getUserPassword(INVALID_USERNAME));

	}

}
