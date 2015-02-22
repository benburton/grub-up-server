package com.citiparks.grubup.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.citiparks.grubup.serializers.DateSerializer;

/**
 * represents the daily menu (breakfast, lunch, snack) for all locations
 * 
 * @author tonyaedmonds
 *
 */
@Entity
public class DailyMenu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue
	@Id
	private Integer dailyMenuId;

	private Date date;
	private ArrayList<Meal> meals;
	private String hotOrCold;
	
	@JsonSerialize(using=DateSerializer.class)
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
