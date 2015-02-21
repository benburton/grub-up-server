package com.citiparks.grubup.service;

import java.util.List;

import com.citiparks.grubup.model.Location;

public interface LocationService {

	public void addLocation(Location location);
	public boolean removeLocation(Integer locationId );
	public List<Location> getAllLocations();
	public Location getLocation(Integer locationId);
	public List<Location> getNearestLocations(String zipcode);
}
