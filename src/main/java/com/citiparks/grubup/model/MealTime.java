package com.citiparks.grubup.model;

import java.util.ArrayList;

/*
 * Represents a meal time (eg. breakfast, lunch, dinner) and thea ctual hours 
 * of the specified meal.
 */
public class MealTime {

	private String description;
	private ArrayList<String> hours;
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<String> getHours() {
		return hours;
	}
	public void setHours(ArrayList<String> hours) {
		this.hours = hours;
	}
	
	
	
	
}
