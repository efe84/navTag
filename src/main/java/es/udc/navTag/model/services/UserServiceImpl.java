package es.udc.navTag.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.navTag.model.common.exceptions.DuplicateInstanceException;
import es.udc.navTag.model.common.exceptions.InstanceNotFoundException;
import es.udc.navTag.model.entities.User;
import es.udc.navTag.model.entities.UserDao;
import es.udc.navTag.model.services.Exceptions.DuplicatedPasswordException;
import es.udc.navTag.model.services.Exceptions.IncorrectLoginException;
import es.udc.navTag.model.services.Exceptions.IncorrectPasswordException;


/**
 * The Class UserServiceImpl.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    /** The permission checker. */
    @Autowired
	private PermissionChecker permissionChecker;

    /** The password encoder. */
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

    /** The user dao. */
    @Autowired
	private UserDao userDao;

    /**
	 * Sign up.
	 *
	 * @param user the user
     * @throws DuplicateInstanceException the duplicate instance exception
	 */
    @Override
    public void signUp(User user) throws DuplicateInstanceException{
        
        if (userDao.existsByUserName(user.getUserName())) {
			throw new DuplicateInstanceException("project.entities.user", user.getUserName());
		}

		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userDao.save(user);
    }

    /**
	 * Login.
	 *
	 * @param userName the user name
	 * @param password the password
	 * @return the user
     * @throws IncorrectLoginException the incorrect login exception
	 */
    @Override
    @Transactional(readOnly = true)
    public User login(String userName, String password) throws IncorrectLoginException{
        Optional<User> user = userDao.findByUserName(userName);

		if (!user.isPresent()) {
			throw new IncorrectLoginException(userName, password);
		}

		if (!passwordEncoder.matches(password, user.get().getPassword())) {
			throw new IncorrectLoginException(userName, password);
		}

		return user.get();

    }

    /**
	 * Login from id.
	 *
	 * @param id the id
	 * @return the user
	 * @throws InstanceNotFoundException the instance not found exception
	 */
    @Override
    @Transactional(readOnly = true)
    public User loginFromId(Long id) throws InstanceNotFoundException{
        return permissionChecker.checkUser(id);
    }

    /**
	 * Update profile.
	 *
	 * @param id        the id
	 * @param firstName the first name
	 * @param lastName  the last name
	 * @param email     the email
	 * @return the user
     * @throws es.udc.navTag.model.common.exceptions.InstanceNotFoundException 
	 * @throws InstanceNotFoundException the instance not found exception
	 */
    @Override
    public User updateProfile(Long id, String name, String email) throws InstanceNotFoundException{

        User user = permissionChecker.checkUser(id);

		user.setName(name);
		user.setEmail(email);

		return user;

    }

    /**
	 * Change password.
	 *
	 * @param id          the id
	 * @param oldPassword the old password
	 * @param newPassword the new password
	 * @throws InstanceNotFoundException  the instance not found exception
	 * @throws DuplicatedPasswordException the incorrect password exception
	 */
    @Override
    public void changePassword(Long id, String oldPassword, String newPassword) throws InstanceNotFoundException, DuplicatedPasswordException, IncorrectPasswordException{
        User user = permissionChecker.checkUser(id);

		if (oldPassword.equals(newPassword))
			throw new DuplicatedPasswordException();

		if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
			throw new IncorrectPasswordException();
		} else {
			user.setPassword(passwordEncoder.encode(newPassword));
		}

    }
    
}
