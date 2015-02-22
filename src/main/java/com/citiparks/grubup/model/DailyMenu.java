package com.citiparks.grubup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * represents the daily menu (breakfast, lunch, snack) for all locations
 * 
 * @author tonyaedmonds
 *
 */
public class DailyMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//TODO: get date formatted correctly
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private ArrayList<Meal> meals;
	private String hotOrCold;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ArrayList<Meal> getMeals() {
		return meals;
	}
	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	public String getHotOrCold() {
		return hotOrCold;
	}
	public void setHotOrCold(String hotOrCold) {
		this.hotOrCold = hotOrCold;
	}
	
	

}
