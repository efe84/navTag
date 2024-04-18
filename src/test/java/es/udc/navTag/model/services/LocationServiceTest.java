package es.udc.navTag.model.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import es.udc.navTag.model.entities.Location;
import es.udc.navTag.model.entities.Tag;
import es.udc.navTag.model.entities.TagDao;
import es.udc.navTag.model.entities.User;
import es.udc.navTag.model.entities.UserDao;

/**
 * The Class UserServiceTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Transactional 
public class LocationServiceTest {

    // The location service.
	@Autowired
	private LocationService locationService;

    // The tag service.
	@Autowired
	private TagDao tagDao;

    // The tag service.
	@Autowired
	private UserDao userDao;

    /**
	 * Creates the location.
	 *
	 * @param location the location
	 * @return the location
	 */
	private Location createLocation(Tag tag, BigDecimal latitude, BigDecimal longitude){
		return new Location(tag, latitude, longitude, LocalDateTime.now());
	}

    private User createUser(String userName){
		return new User(userName, "David", "d.fernandez4@udc.es", "david2024");
	}

    /**
	 * Test register location and find it.
	 *
	 */
	@Test
	public void testRegisterAndFindLocation() {

        User user = createUser("user");
        userDao.save(user);

        Tag tag = new Tag(user,"tag","description");
        tagDao.save(tag);

		Tag tag2 = new Tag(user,"tag2","description2");
        tagDao.save(tag2);

		Location location1 = createLocation(tag, BigDecimal.valueOf(43.34991148069057), BigDecimal.valueOf(-8.405264726085989));
        Location location2 = createLocation(tag, BigDecimal.valueOf(43.34860857583153), BigDecimal.valueOf(-8.40574752385741));
        locationService.recordNewLocation(location1);
        locationService.recordNewLocation(location2);

		Location location3 = createLocation(tag2, BigDecimal.valueOf(43.5), BigDecimal.valueOf(-8.4));
        locationService.recordNewLocation(location3);

        List<Location> foundLocations = locationService.getAllTagLocations(tag.getId());

        List<Location> locationsList = new ArrayList<>();
        locationsList.add(location1);
        locationsList.add(location2);

		assertEquals(foundLocations.size(), locationsList.size());
		assertEquals(foundLocations.get(0).getLatitude(), location1.getLatitude());
		assertEquals(foundLocations.get(0).getLongitude(), location1.getLongitude());
		assertEquals(foundLocations.get(1).getLatitude(), location2.getLatitude());
		assertEquals(foundLocations.get(1).getLongitude(), location2.getLongitude());
		assertEquals(foundLocations.get(0).getTag().getName(), location1.getTag().getName());
		assertEquals(foundLocations.get(1).getTag().getName(), location2.getTag().getName());
	}

	/**
	 * Test find locations between 2 dates.
	 *
	 */
	@Test
	public void testFindLocationsBetween2Dates() {

        User user = createUser("user");
        userDao.save(user);

        Tag tag = new Tag(user,"tag","description");
        tagDao.save(tag);

		Tag tag2 = new Tag(user,"tag2","description2");
        tagDao.save(tag2);

		Location location1 = createLocation(tag, BigDecimal.valueOf(43.34991148069057), BigDecimal.valueOf(-8.405264726085989));
        Location location2 = createLocation(tag, BigDecimal.valueOf(43.34860857583153), BigDecimal.valueOf(-8.40574752385741));
		Location location3 = new Location(tag, BigDecimal.valueOf(43.34760857583153), BigDecimal.valueOf(-8.40634752385741), LocalDateTime.now().plusHours(2));
        locationService.recordNewLocation(location1);
        locationService.recordNewLocation(location2);
		locationService.recordNewLocation(location3);

		Location location4 = createLocation(tag2, BigDecimal.valueOf(43.5), BigDecimal.valueOf(-8.4));
        locationService.recordNewLocation(location4);

        List<Location> foundLocations = locationService.getAllTagLocations(tag.getId(),LocalDateTime.now().minusMinutes(5),LocalDateTime.now().plusMinutes(30));

        List<Location> locationsList = new ArrayList<>();
        locationsList.add(location1);
        locationsList.add(location2);

		assertEquals(foundLocations.size(), locationsList.size());
		assertEquals(foundLocations.get(0).getLatitude(), location1.getLatitude());
		assertEquals(foundLocations.get(0).getLongitude(), location1.getLongitude());
		assertEquals(foundLocations.get(1).getLatitude(), location2.getLatitude());
		assertEquals(foundLocations.get(1).getLongitude(), location2.getLongitude());
		assertEquals(foundLocations.get(0).getTag().getName(), location1.getTag().getName());
		assertEquals(foundLocations.get(1).getTag().getName(), location2.getTag().getName());
	}
    
}
