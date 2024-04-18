package es.udc.navTag.model.entities;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface TagDao.
 */
public interface TagDao extends JpaRepository<Tag,Long>{

    /**
	 * Exists by tag name.
	 *
	 * @param name the tag name
	 * @return true, if successful
	 */
    boolean existsByName(String name);

	/**
	 * Find by tag name.
	 *
	 * @param name the tag name
	 * @return the optional tag
	 */
    Optional<Tag> findByName(String name);
    
}
