package com.citiparks.grubup.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

@Entity
public class Location {

	@Id
	private String shortName;
	private String fullName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private Double latitude;
	private Double longitude;
	private JSONObject jsonObject = new JSONObject();
	
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
	
	public void createJsonObject() throws JSONException
	{
		jsonObject.put("shortName", shortName);
		jsonObject.put("longName", fullName);
		jsonObject.put("latitude", latitude);
		jsonObject.put("longitude", longitude);
		jsonObject.put("address", address);
		jsonObject.put("city", city);
		jsonObject.put("state", state);
		jsonObject.put("zip", zip);
		
	}
	
	public JSONObject getJSONObject()
	{
		return jsonObject;
	}
	
	public String toString()
	{
		return fullName + "\n" + address + "\n" + city + " "
				+ state + " " + zip + "\n";
	}
	
	
}
