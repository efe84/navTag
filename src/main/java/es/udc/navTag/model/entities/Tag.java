package es.udc.navTag.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * The Class Tag.
 */
@Entity
public class Tag {

    /** The id. */
	private Long id;

    /** The user that owns the Tag. */
	private User user;

    /** The tag name. */
	private String name;

    /** The tag description. */
	private String description;

    /**
	 * Instantiates a new tag.
	 */
	public Tag() {
	}

    /**
	 * Instantiates a new tag.
     * @param user the user that owns the tag
     * @param name the tag name
     * @param description the tag description
	 */
    public Tag(User user, String name, String description) {
        this.user = user;
        this.name = name;
        this.description = description;
    }

    /**
	 * Gets the id.
	 *
	 * @return the id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    /**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
    public void setId(Long id) {
        this.id = id;
    }

    /**
	 * Gets the user.
	 *
	 * @return the user
	 */
    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    /**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
    public void setUser(User user) {
        this.user = user;
    }

    /**
	 * Gets the tag name.
	 *
	 * @return the tag name
	 */
    public String getName() {
        return name;
    }

    /**
	 * Sets the tag name.
	 *
	 * @param name the new tag name
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Gets the tag description.
	 *
	 * @return the tag description
	 */
    public String getDescription() {
        return description;
    }

    /**
	 * Sets the tag description.
	 *
	 * @param description the new tag description
	 */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
	 * To string method
	 */
    @Override
    public String toString() {
        return "Tag [id=" + id + ", user=" + user + ", name=" + name + ", description=" + description + "]";
    }
    
}
