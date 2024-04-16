package es.udc.navTag.model.entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface UserDao.
 */
public interface UserDao extends JpaRepository<User,Long>{
    
    /**
	 * Exists by user name.
	 *
	 * @param userName the user name
	 * @return true, if successful
	 */
	boolean existsByUsername(String userName);

	/**
	 * Find by user name.
	 *
	 * @param userName the user name
	 * @return the optional
	 */
	Optional<User> findByUsername(String userName);

}
