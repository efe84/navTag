package es.udc.navTag.model.services;

import java.time.LocalDateTime;
import java.util.List;

import es.udc.navTag.model.entities.Location;

/**
 * The Interface LocationService.
 */
public interface LocationService {

    /**
	 * Create Location.
	 *
     * @param location the new location
	 */
	void recordNewLocation(Location location);

    /**
	 * Get all Tag Locations.
	 *
     * @param id the tag id
	 */
	List<Location> getAllTagLocations(Long id);

    /**
	 * Get Tag Locations between 2 dates.
	 *
     * @param id the tag id
     * @param initTime the initial time to get location
     * @param finishTime the last time to get location
	 */
	List<Location> getAllTagLocations(Long id, LocalDateTime initTime, LocalDateTime finishTime);
    
}
