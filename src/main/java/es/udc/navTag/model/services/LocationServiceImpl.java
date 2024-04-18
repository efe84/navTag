package es.udc.navTag.model.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.udc.navTag.model.entities.Location;
import es.udc.navTag.model.entities.LocationDao;

/**
 * The Class UserServiceImpl.
 */
@Service
@Transactional
public class LocationServiceImpl implements LocationService{

    /** The location dao. */
    @Autowired
    private LocationDao locationDao;

    /**
	 * Record new Location.
	 *
	 * @param location the location
	 */
    @Override
    public void recordNewLocation(Location location) {
        locationDao.save(location);
    }

    /**
	 * Get all locations from a Tag.
	 *
	 * @param id the tag id
	*/
    @Override
    public List<Location> getAllTagLocations(Long id) {
        return locationDao.findAllByTagId(id);
    }

    /**
	 * Get all locations from a Tag between 2 dates.
	 *
	 * @param id the tag id
     * @param initTime the initial time to get locations
     * @param finishTime the last time to get locations
	 */
    @Override
    public List<Location> getAllTagLocations(Long id, LocalDateTime initTime, LocalDateTime finishTime) {
        return locationDao.findAllByTagIdAndTimeBetween(id,initTime,finishTime);
    }
}
