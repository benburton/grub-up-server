package com.citiparks.grubup.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * Represents a meal time (eg. breakfast, lunch, dinner) and the actual hours 
 * of the specified meal.
 */
//@Entity
public class MealTime implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@JsonIgnore
	//@Id
	//@GeneratedValue
	private Integer mealTimeId;
	
	private String description; //breakfast, lunch or dinner 
	private ArrayList<String> hours;
	
	private Location location;
	
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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	
	
	
	
}
