package es.udc.navTag.model.entities;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface LocationDao.
 */
public interface LocationDao extends JpaRepository<Location,Long>{

    /**
     * 
     * @param id the tag id
     * @return a list of locations from that tag
     */
    List<Location> findAllByTagId(Long id);

    /**
     * 
     * @param id the tag id
     * @param initTime the initial time to get locations
     * @param finishTime the final time to get locations
     * @return a list of locations from that tag between 2 dates
     */
    List<Location> findAllByTagIdAndTimeBetween(Long id, LocalDateTime initTime, LocalDateTime finishTime);
    
}
