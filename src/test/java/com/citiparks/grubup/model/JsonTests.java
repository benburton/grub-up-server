package com.citiparks.grubup.model;

import java.util.ArrayList;

import org.junit.Test;

import com.google.gson.Gson;

public class JsonTests {
	
	@Test
	public void mealsJSON(){
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
	
	@Test
	public void locationJSON(){
		Location l = new Location();
		l.setAddress("100 Hyman Place");
		l.setCity("Pittsburgh");
		l.setFullName("Oak Hill Community Center");
		l.setLatitude(34.032923);
		l.setLongitude(89.323243);
		l.setShortName("OAKHILL");
		l.setState("PA");
		l.setZip("15213");
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(l));
	}

}
