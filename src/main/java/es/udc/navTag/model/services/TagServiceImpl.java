package es.udc.navTag.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.navTag.model.common.exceptions.InstanceNotFoundException;
import es.udc.navTag.model.entities.Tag;
import es.udc.navTag.model.entities.TagDao;
import es.udc.navTag.model.entities.User;
import es.udc.navTag.model.entities.UserDao;
import es.udc.navTag.model.services.Exceptions.AlreadyAddedTagException;
import es.udc.navTag.model.services.Exceptions.ExistentTagException;
import es.udc.navTag.model.services.Exceptions.NotOwnerException;

/**
 * The Class UserServiceImpl.
 */
@Service
@Transactional
public class TagServiceImpl implements TagService{

    /** The tag dao. */
    @Autowired
    private TagDao tagDao;

    /** The user dao. */
    @Autowired
    private UserDao userDao;

    /**
	 * Create Tag.
	 *
	 * @param tag the tag
     * @throws ExistentTagException the existent tag exception
	 */
    @Override
    public void createTag(Tag tag) throws ExistentTagException {

        if (tagDao.existsByName(tag.getName())) {
			throw new ExistentTagException();
		}

		tagDao.save(tag);
    }

    /**
	 * Add user to tag.
	 *
	 * @param name the tag name
     * @param username the username
     * @throws AlreadyAddedTagException the already added tag exception
     * @throws InstanceNotFoundException the instance not found exception
	 */
    @Override
    public Tag addUserToTag(String name, String username) throws AlreadyAddedTagException, InstanceNotFoundException {

        if (!tagDao.existsByName(name)) {
			throw new InstanceNotFoundException("project.entities.tag", name);
		}

        Tag foundTag = tagDao.findByName(name).get();
        User foundUser = userDao.findByUsername(username).get();
        foundTag.setUser(foundUser);
        return foundTag;
    }

    /**
	 * Remove tag.
	 *
	 * @param name the tag name
     * @param username the username
     * @throws NotOwnerException the not owner exception
     * @throws InstanceNotFoundException the instance not found exception
	 */
    @Override
    public void removeTag(String name, String username) throws NotOwnerException, InstanceNotFoundException {

        if (!tagDao.existsByName(name)) {
			throw new InstanceNotFoundException("project.entities.tag", name);
		}

        Tag foundTag = tagDao.findByName(name).get();

        if(foundTag.getUser().getUsername() != username){
            throw new NotOwnerException();
        }

        tagDao.delete(foundTag);
    }

    /**
	 * Edit tag.
	 *
	 * @param id the id
	 * @param name the tag name
	 * @param description the tag description
	 * @param username the username
	 * @return the tag
     * @throws NotOwnerException the not owner exception
	 * @throws InstanceNotFoundException the instance not found exception
	 */
    @Override
    public Tag editTag(Long id, String name, String description, String username) throws NotOwnerException, InstanceNotFoundException {

        if (!tagDao.existsById(id)) {
			throw new InstanceNotFoundException("project.entities.tag", name);
		}

        Tag foundTag = tagDao.findById(id).get();

        if(foundTag.getUser().getUsername() != username){
            throw new NotOwnerException();
        }

        foundTag.setName(name);
        foundTag.setDescription(description);
        return foundTag;
    }
    
}
