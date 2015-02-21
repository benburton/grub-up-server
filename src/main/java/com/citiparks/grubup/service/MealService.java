package com.citiparks.grubup.service;

import com.citiparks.grubup.model.Meal;

public interface MealService {
	
	public Meal getMeal(Integer mealId);
	public boolean addMeal(Meal meal);
	public boolean deleteMeal(Meal meal);

}
