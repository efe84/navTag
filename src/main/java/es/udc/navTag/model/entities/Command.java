package es.udc.navTag.model.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * The Class User.
 */
@Entity
public class Command {

    /** The id. */
	private Long id;

    /** The tag. */
	private Tag tag;

    /** The command type. */
	private String type;

    /** The command state. */
	private String state;

    /** The date and time. */
    private LocalDateTime time;

    /**
	 * Instantiates a new tag.
	 */
	public Command() {
	}

    /**
	 * Instantiates a new tag.
     * @param tag the tag
     * @param type the command type
     * @param state the command state
     * @param time the date and time
	 */
    public Command(Tag tag, String type, String state, LocalDateTime time) {
        this.tag = tag;
        this.type = type;
        this.state = state;
        this.time = time;
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
	 * Gets the tag.
	 *
	 * @return the tag
	 */
    @ManyToOne
    @JoinColumn(name = "tag_id")
    public Tag getTag() {
        return tag;
    }

    /**
	 * Sets the tag.
	 *
	 * @param tag the new tag
	 */
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /**
	 * Gets the command type.
	 *
	 * @return the command type
	 */
    public String getType() {
        return type;
    }

    /**
	 * Sets the command type.
	 *
	 * @param type the new command type
	 */
    public void setType(String type) {
        this.type = type;
    }

    /**
	 * Gets the command state.
	 *
	 * @return the command state
	 */
    public String getState() {
        return state;
    }

    /**
	 * Sets the command state.
	 *
	 * @param state the new command state
	 */
    public void setState(String state) {
        this.state = state;
    }

    /**
	 * Gets the date and time.
	 *
	 * @return the date and time
	 */
    public LocalDateTime getTime() {
        return time;
    }

    /**
	 * Sets the date and time.
	 *
	 * @param time the new date and time
	 */
    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    /**
	 * To string method
	 */
    @Override
    public String toString() {
        return "Command [id=" + id + ", tag=" + tag + ", type=" + type + ", state=" + state + ", time=" + time + "]";
    }
    
}
