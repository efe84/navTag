package es.udc.navTag.model.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import es.udc.navTag.model.common.exceptions.DuplicateInstanceException;
import es.udc.navTag.model.common.exceptions.InstanceNotFoundException;
import es.udc.navTag.model.entities.User;
import es.udc.navTag.model.services.Exceptions.DuplicatedPasswordException;
import es.udc.navTag.model.services.Exceptions.IncorrectLoginException;
import es.udc.navTag.model.services.Exceptions.IncorrectPasswordException;

/**
 * The Class UserServiceTest.
 */
 @RunWith(SpringRunner.class)
 @SpringBootTest
 @ActiveProfiles("test")
 @Transactional 
public class UserServiceTest {
    
    // The user service.
	@Autowired
	private UserService userService;


    /**
	 * Creates the user.
	 *
	 * @param userName the user name
	 * @return the user
	 */
	private User createUser(String userName){
		return new User(userName, "David", "d.fernandez4@udc.es", "david2024");
	}

	/**
	 * Test sign up and login from id.
	 *
	 * @throws DuplicateInstanceException the duplicate instance exception
	 * @throws InstanceNotFoundException  the instance not found exception
	 * @throws javax.management.InstanceNotFoundException 
	 */
	@Test
	public void testSignUpAndLoginFromId()
			throws DuplicateInstanceException, InstanceNotFoundException {

		User user = createUser("user");

		userService.signUp(user);

		User loggedInUser = userService.loginFromId(user.getId());

		assertEquals(user, loggedInUser);

	}

	@Test
	public void testSignUpDuplicateInstanceException()
			throws DuplicateInstanceException, InstanceNotFoundException {

		User user = createUser("user");

		userService.signUp(user);

		assertThrows(DuplicateInstanceException.class, () -> userService.signUp(user));

	}

	@Test
	public void testLoginWithIncorrectPassword() throws DuplicateInstanceException, InstanceNotFoundException, IncorrectLoginException {

		User user = createUser("user");

		userService.signUp(user);

		String password = user.getPassword();

		assertThrows(IncorrectLoginException.class, () -> userService.login(user.getUsername(), 'X' + password));

	}

	@Test
	public void testLoginFromWithIncorrectLoginException()
			throws DuplicateInstanceException, InstanceNotFoundException {

		String userName = "Luis";
		String password = "Luis";

		assertThrows(IncorrectLoginException.class, () -> userService.login(userName, password));
	}

	@Test
	public void testChangePassword() throws DuplicateInstanceException, InstanceNotFoundException,
        DuplicatedPasswordException, IncorrectPasswordException, IncorrectLoginException {

		User user = createUser("user");
		String oldPassword = user.getPassword();
		String newPassword = 'X' + oldPassword;

		userService.signUp(user);
		userService.changePassword(user.getId(), oldPassword, newPassword);
		userService.login(user.getUsername(), newPassword);

	}

	@Test
	public void testChangePasswordWithNonExistentId() throws DuplicateInstanceException, InstanceNotFoundException,
			IncorrectPasswordException, IncorrectLoginException, DuplicatedPasswordException {

		Long nonExistentId = (long) 666;

		assertThrows(InstanceNotFoundException.class,
				() -> userService.changePassword(nonExistentId, "user", "password"));
	}

	@Test
	public void testChangePasswordWithIncorrectPassword() throws DuplicateInstanceException, InstanceNotFoundException,
			IncorrectPasswordException, IncorrectLoginException, DuplicatedPasswordException {

		User user = createUser("user");
		String oldPassword = user.getPassword();
		String newPassword = 'X' + oldPassword;

		userService.signUp(user);
		assertThrows(IncorrectPasswordException.class,
				() -> userService.changePassword(user.getId(), 'Y' + oldPassword, newPassword));

	}

	@Test
	public void testChangePasswordWithDuplicatedPassword() throws DuplicateInstanceException,
			InstanceNotFoundException, IncorrectPasswordException, IncorrectLoginException, DuplicatedPasswordException {

		User user = createUser("user");
		String oldPassword = user.getPassword();
		String newPassword = oldPassword;

		userService.signUp(user);
		assertThrows(DuplicatedPasswordException.class,
				() -> userService.changePassword(user.getId(), oldPassword, newPassword));

	}

    @Test
	public void testUpdateUsername() throws DuplicateInstanceException {

		User user = createUser("user");
		userService.signUp(user);

		assertEquals("user", user.getUsername());

		user.setUsername("Nuevo nombre");

		assertEquals("Nuevo nombre", user.getUsername());
	}

}
