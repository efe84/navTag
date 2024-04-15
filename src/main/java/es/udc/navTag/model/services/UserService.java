package es.udc.navTag.model.services;

import es.udc.navTag.model.entities.User;

/**
 * The Interface UserService.
 */
public interface UserService {

    /**
	 * Sign up.
	 *
	 * @param user the user
	 */
	void signUp(User user);

	/**
	 * Login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the user
	 */
	User login(String userName, String password);

	/**
	 * Login from id.
	 *
	 * @param id the id
	 * @return the user
	 */
	User loginFromId(Long id);

	/**
	 * Update profile.
	 *
	 * @param id the id
	 * @param name the name
	 * @param email the email
	 * @return the user
	 */
	User updateProfile(Long id, String name, String email);

	/**
	 * Change password.
	 *
	 * @param id the id
	 * @param oldPassword the old password
	 * @param newPassword the new password
	 */
	void changePassword(Long id, String oldPassword, String newPassword);
    
}
