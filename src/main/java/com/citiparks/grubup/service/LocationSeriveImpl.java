package com.citiparks.grubup.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiparks.grubup.model.Location;

@Service
public class LocationSeriveImpl implements LocationService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addLocation(Location location) {
		entityManager.persist(location);
		
	}

	@Transactional
	public boolean removeLocation(String shortName) {
	    Location location = entityManager.find(Location.class, shortName);
	    if (null != location) {
	      entityManager.remove(location);
	      return true;
	    }
	    else return false;
	}

	@Transactional
	public List<Location> getAllLocations() {
	    CriteriaQuery<Location> c = entityManager.getCriteriaBuilder().createQuery(Location.class);
	    c.from(Location.class);
	    return entityManager.createQuery(c).getResultList();
	}

	@Transactional
	public Location getLocation(String shortName) {
		return entityManager.find(Location.class, shortName);	    
	}

	@Transactional
	public List<Location> getNearestLocations(String zipcode) {
		//CriteriaQuery<Location> c = entityManager.getCriteriaBuilder().createQuery(Location.class);
	    //todo:  actually do a query and return that
		Location someLocation = new Location();
		someLocation.setAddress("123 Fake St");
		someLocation.setCity("Pittsburgh");
		someLocation.setState("PA");
		someLocation.setFullName("Oiishi Bento");
		someLocation.setLatitude(-40.0);
		someLocation.setLongitude(-80.0);
		someLocation.setShortName("Oiishi");
		someLocation.setZip("15213");
		
		Location someLocation2 = new Location();
		someLocation2.setAddress("999 Fifth Ave");
		someLocation2.setCity("Pittsburgh");
		someLocation2.setState("PA");
		someLocation2.setFullName("Mama Rose");
		someLocation2.setLatitude(-40.0);
		someLocation2.setLongitude(-80.0);
		someLocation2.setShortName("Mama");
		someLocation2.setZip("15222");
		
		List<Location> l = new ArrayList();
		l.add(someLocation);
		l.add(someLocation2);
		
		return l;
	    //return entityManager.createQuery(c).getResultList();

	}
	
	public String getNearestLocationsAsString(String zipcode)
	{
		List<Location> theList = getNearestLocations(zipcode);
		
		String s = "";
		for (int i = 0; i < theList.size(); i++)
		{
			if (i > 0) s += "\n";
			s += theList.get(i).toString();
		}
		
		return s;
	}

	
}
