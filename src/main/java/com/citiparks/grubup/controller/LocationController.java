package com.citiparks.grubup.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citiparks.grubup.model.Location;
import com.citiparks.grubup.service.LocationService;

@RequestMapping("location/")
@RestController
public class LocationController {

  @Autowired
  private LocationService locationService;

  @RequestMapping("/")
  public List<Location> getAllLocations(Map<String, Object> map) {
	  return locationService.getAllLocations();
  }

  @RequestMapping(value="/", method=RequestMethod.POST, consumes={"application/json"})
  public void addLocation(@RequestBody Location location, BindingResult result) {
	  locationService.addLocation(location);
  }

  @RequestMapping(value="/{locationId}", method=RequestMethod.DELETE)
  public boolean removeLocation(@PathVariable("locationId") Integer locationId) {
	  return locationService.removeLocation(locationId);
  }
  
  @RequestMapping(value="/{locationId}", method=RequestMethod.GET)
  public Location getLocation(@PathVariable("locationId") Integer locationId)
  {
	return locationService.getLocation(locationId);	  
  }
}