package com.citiparks.grubup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Represents a meal
 * 
 * @author tonyaedmonds
 *
 */
@Entity
public class Meal {
	
	@Id
	@GeneratedValue
	private Integer mealId;
	
	private ArrayList<String> mealItems;
	private String meal;
	
	public Integer getMealId() {
		return mealId;
	}
	public void setMealId(Integer mealId) {
		this.mealId = mealId;
	}
	
	@ElementCollection
	public List<String> getMealItems() {
		return mealItems;
	}
	public void setMealItems(ArrayList<String> mealItems) {
		this.mealItems = mealItems;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	
}
