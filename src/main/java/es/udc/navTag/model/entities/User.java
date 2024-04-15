package es.udc.navTag.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The Class User.
 */
@Entity
public class User {

    /** The id. */
	private Long id;

    /** The user name. */
	private String userName;

    /** The name. */
	private String name;

    /** The email. */
	private String email;

    /** The password. */
	private String password;

    /**OptimisticLocking*/
	private int version;

    /**
	 * Instantiates a new user.
	 */
	public User() {
	}

    /**
	 * Instantiates a new user.
     * @param userName the user name
     * @param name the name
     * @param email the email
     * @param password the password
     * @param version the optimistic locking version
	 */
    public User(String userName, String name, String email, String password, int version) {
        this.userName = userName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.version = 0;
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
	 * Gets the userName.
	 *
	 * @return the userName
	 */
    public String getUserName() {
        return userName;
    }

    /**
	 * Sets the userName.
	 *
	 * @param username the new username
	 */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
	 * Gets the name.
	 *
	 * @return the name
	 */
    public String getName() {
        return name;
    }

    /**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * Gets the email.
	 *
	 * @return the email
	 */
    public String getEmail() {
        return email;
    }

    /**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
	 * Gets the password.
	 *
	 * @return the password
	 */
    public String getPassword() {
        return password;
    }

    /**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
	 * Gets the version.
	 *
	 * @return the version
	 */
    public int getVersion() {
        return version;
    }

    /**
	 * Sets the version.
	 *
	 * @param version the new version
	 */
    public void setVersion(int version) {
        this.version = version;
    }

    /**
	 * To string method
	 */
    @Override
    public String toString() {
        return "User [id=" + id + ", userName=" + userName + ", name=" + name + ", email=" + email + ", password="
                + password + ", version=" + version + "]";
    }
    
}
