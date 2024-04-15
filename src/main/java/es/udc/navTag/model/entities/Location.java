package es.udc.navTag.model.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * The Class Location.
 */
@Entity
public class Location {
    
    /** The id. */
	private Long id;

    /** The tag asociated. */
	private Tag tag;

    /** The latitude. */
	private BigDecimal latitude;

    /** The longitude. */
	private String longitude;

    /** The date and time. */
    private LocalDateTime time;

    /**
	 * Instantiates a new location.
	 */
	public Location() {
	}

    /**
	 * Instantiates a new location.
     * @param tag the tag asociated
     * @param latitude the latitude
     * @param longitude the longitude
     * @param time the date and time
	 */
    public Location(Tag tag, BigDecimal latitude, String longitude, LocalDateTime time) {
        this.tag = tag;
        this.latitude = latitude;
        this.longitude = longitude;
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
	 * Gets the tag asociated.
	 *
	 * @return the tag asociated
	 */
    @ManyToOne
    @JoinColumn(name = "tag_id", updatable = false)
    public Tag getTag() {
        return tag;
    }

    /**
	 * Sets the tag asociated.
	 *
	 * @param tag the new tag asociated
	 */
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    /**
	 * Gets the latitude.
	 *
	 * @return the latitude
	 */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
	 * Sets the latitude.
	 *
	 * @param latitude the new latitude
	 */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
	 * Gets the longitude.
	 *
	 * @return the longitude
	 */
    public String getLongitude() {
        return longitude;
    }

    /**
	 * Sets the longitude.
	 *
	 * @param longitude the new longitude
	 */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
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
        return "Location [id=" + id + ", tag=" + tag + ", latitude=" + latitude + ", longitude=" + longitude + ", time="
                + time + "]";
    }
    
}
