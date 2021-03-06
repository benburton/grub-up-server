package com.citiparks.grubup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 * Represents a food location
 * @author tonyaedmonds
 *
 */
@Entity
public class Location {

	@Id
	@GeneratedValue
	private Integer locationId;

	private String shortName;
	private String fullName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private Double latitude;
	private Double longitude;
	
	private ArrayList<MealTime> mealTimes;
	private ArrayList<String> days;

	
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column
	@ElementCollection(targetClass=MealTime.class)
	public List<MealTime> getMealTimes() {
		return mealTimes;
	}
	public void setMealTimes(ArrayList<MealTime> mealTimes) {
		this.mealTimes = mealTimes;
	}
	
	
	public ArrayList<String> getDays() {
		return days;
	}
	public void setDays(ArrayList<String> days) {
		this.days = days;
	}
	public String toString()
	{
		return fullName + "\n" + address + "\n" + city + " "
				+ state + " " + zip + "\n";
	}
	
	
}
