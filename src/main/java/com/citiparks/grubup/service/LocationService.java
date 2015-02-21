package com.citiparks.grubup.service;

import java.util.List;

import com.citiparks.grubup.model.Location;

public interface LocationService {

	public void addLocation(Location location);
	public boolean removeLocation(Location location );
	public List<Location> getAllLocations();
	public Location getLocation(String shortName);
}
