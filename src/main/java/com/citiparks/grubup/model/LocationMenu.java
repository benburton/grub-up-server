package com.citiparks.grubup.model;

import java.util.Date;
import java.util.List;

public class LocationMenu {
	
	private Location location; // should this be a String representing the shortName for querying?
	private List<Meal> meals; //all meals for the day
	private Date date;
	

	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<Meal> getMeals() {
		return meals;
	}
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
