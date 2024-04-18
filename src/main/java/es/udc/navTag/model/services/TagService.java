package es.udc.navTag.model.services;

import es.udc.navTag.model.common.exceptions.InstanceNotFoundException;
import es.udc.navTag.model.entities.Tag;
import es.udc.navTag.model.services.Exceptions.AlreadyAddedTagException;
import es.udc.navTag.model.services.Exceptions.ExistentTagException;
import es.udc.navTag.model.services.Exceptions.NotOwnerException;

/**
 * The Interface TagService.
 */
public interface TagService {

    /**
	 * Create Tag.
	 *
     * @param tag the tag
     * @throws ExistentTagException the existent tag exception
	 */
	void createTag(Tag tag) throws ExistentTagException;

    /**
	 * Add User to Tag.
	 *
     * @param name the tag name
	 * @param username the username
     * @throws AlreadyAddedTagException the already tag added exception
     * @throws InstanceNotFoundException the instance not found exception
	 */
	Tag addUserToTag(String name, String username) throws AlreadyAddedTagException, InstanceNotFoundException;

    /**
	 * Remove Tag.
	 *
     * @param name the tag name
     * @param username the username
     * @throws NotOwnerException the not owner exception
     * @throws InstanceNotFoundException the instance not found exception
	 */
	void removeTag(String name, String username) throws NotOwnerException, InstanceNotFoundException;

    /**
	 * Edit Tag.
	 *
     * @param tag the tag edited
     * @throws NotOwnerException the not owner exception
     * @throws InstanceNotFoundException the instance not found exception
	 */
	Tag editTag(Long id, String name, String description, String username) throws NotOwnerException, InstanceNotFoundException;
    
}
