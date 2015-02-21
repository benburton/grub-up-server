package com.citiparks.grubup.service;

import java.util.List;

import com.citiparks.grubup.model.Location;
import com.citiparks.grubup.model.Person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Service
public class LocationSeriveImpl implements LocationService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public void addLocation(Location location) {
		entityManager.persist(location);
		
	}

	@Transactional
	public boolean removeLocation(Integer id) {
	    Location location = entityManager.find(Location.class, id);
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
		return  entityManager.find(Location.class, shortName);	    
	}

	
}
