package com.citiparks.grubup.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
  public String getAllLocations(Map<String, Object> map) {
    map.put("location", new Location());
    map.put("locationList", locationService.getAllLocations());
    return "locations";
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  public String addLocation(@ModelAttribute("location") Location location, BindingResult result) {
	  locationService.addLocation(location);
    return "redirect:/locations/";
  }

  @RequestMapping("/delete/{shortName}")
  public String removeLocation(@PathVariable("shortName") String shortName) {
	  locationService.removeLocation(shortName);
    return "redirect:/locations/";
  }
  
  @RequestMapping("/{shortName}")
  public void getLocation(@PathVariable("shortName") String shortName)
  {
	locationService.getLocation(shortName);	  
  }
}