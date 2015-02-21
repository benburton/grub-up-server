package com.citiparks.grubup.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Meal {
	
	@Id
	@GeneratedValue
	private Integer mealId;
	
	private String meal; //breakfast, lunch or snack
	private ArrayList<String> mealItems;
	
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
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
	

}
