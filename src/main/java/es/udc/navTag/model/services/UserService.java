package es.udc.navTag.model.services;

import es.udc.navTag.model.common.exceptions.DuplicateInstanceException;
import es.udc.navTag.model.common.exceptions.InstanceNotFoundException;
import es.udc.navTag.model.entities.User;
import es.udc.navTag.model.services.Exceptions.DuplicatedPasswordException;
import es.udc.navTag.model.services.Exceptions.IncorrectLoginException;
import es.udc.navTag.model.services.Exceptions.IncorrectPasswordException;

/**
 * The Interface UserService.
 */
public interface UserService {

    /**
	 * Sign up.
	 *
	 * @param user the user
     * @throws DuplicateInstanceException the duplicate instance exception
	 */
	void signUp(User user) throws DuplicateInstanceException;

	/**
	 * Login.
	 *
	 * @param username the user name
	 * @param password the password
	 * @return the user
     * @throws IncorrectLoginException the incorrect login exception
	 */
	User login(String username, String password) throws IncorrectLoginException;

	/**
	 * Login from id.
	 *
	 * @param id the id
	 * @return the user
     * @throws InstanceNotFoundException the instance not found exception
	 */
	User loginFromId(Long id) throws InstanceNotFoundException;

	/**
	 * Update profile.
	 *
	 * @param id the id
	 * @param name the name
	 * @param email the email
	 * @return the user
     * @throws InstanceNotFoundException the instance not found exception
	 */
	User updateProfile(Long id, String name, String email) throws InstanceNotFoundException;

	/**
	 * Change password.
	 *
	 * @param id the id
	 * @param oldPassword the old password
	 * @param newPassword the new password
     * @throws InstanceNotFoundException  the instance not found exception
     * @throws IncorrectPasswordException the duplicated password exception
     * @throws IncorrectPasswordException the incorrect password exception
	 */
	void changePassword(Long id, String oldPassword, String newPassword) throws InstanceNotFoundException, DuplicatedPasswordException, IncorrectPasswordException;
    
}
