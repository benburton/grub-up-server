package com.citiparks.grubup.model;

import java.util.ArrayList;

import org.junit.Test;

import com.google.gson.Gson;

public class MealTest {
	
	@Test
	public void getJSON(){
		Meal m = new Meal();
		m.setMeal("123");
		ArrayList<String> mealItems = new ArrayList<String>();
		mealItems.add("applesauce");
		mealItems.add("bananas");
		m.setMealItems(mealItems);
		m.setMeal("snack");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(m));
		
	}

}
