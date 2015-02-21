package com.citiparks.grubup.service;

import java.util.List;

import com.citiparks.grubup.model.Meal;

public interface MealService {
	
	public Meal getMeal(Integer mealId);
	public void addMeal(Meal meal);
	public boolean deleteMeal(Integer mealId);
	public List<Meal> getAllMeals();

}
