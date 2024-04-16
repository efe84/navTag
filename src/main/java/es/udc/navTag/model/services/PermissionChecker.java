package es.udc.navTag.model.services;

import es.udc.navTag.model.common.exceptions.InstanceNotFoundException;
import es.udc.navTag.model.entities.User;

/**
 * The Interface PermissionChecker.
 */
public interface PermissionChecker {

    /**
	 * Check user exists.
	 *
	 * @param userId the user id
	 * @throws InstanceNotFoundException the instance not found exception
	 */
	public void checkUserExists(Long userId) throws InstanceNotFoundException;

	/**
	 * Check user.
	 *
	 * @param userId the user id
	 * @return the user
	 * @throws InstanceNotFoundException the instance not found exception
	 */
	public User checkUser(Long userId) throws InstanceNotFoundException;
    
}
