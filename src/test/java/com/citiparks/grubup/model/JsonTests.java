package com.citiparks.grubup.model;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;

public class JsonTests {
	Meal m1, m2, m3;
	ArrayList<String> mon_thurs;
	ArrayList<Meal> meals;
	
	@Before
	public void init(){
		m1 = new Meal();
		ArrayList<String> mealItems = new ArrayList<String>();
		mealItems.add("applesauce");
		mealItems.add("bananas");
		m1.setMeal("snack");
		m1.setMealItems(mealItems);
		
		m2 = new Meal();
		mealItems = new ArrayList<String>();
		mealItems.add("turkey sandwich");
		mealItems.add("chips");
		m2.setMeal("lunch");
		m2.setMealItems(mealItems);
		
		m3 = new Meal();
		mealItems = new ArrayList<String>();
		mealItems.add("oatmeal");
		mealItems.add("orange juice");
		m3.setMeal("breakfast");
		m3.setMealItems(mealItems);
		
		ArrayList<String> mon_thurs = new ArrayList<String>();
		mon_thurs.add("Monday");
		mon_thurs.add("Tuesday");
		mon_thurs.add("Wednesday");
		mon_thurs.add("Thursday");
	
		meals = new ArrayList<Meal>();
		meals.add(m1);
		meals.add(m2);
		meals.add(m3);
	
	}
	@Test
	public void dailyMenuJSON(){
		DailyMenu dailyMenu = new DailyMenu();
		dailyMenu.setDate(new Date());
		dailyMenu.setHotOrCold("cold");
		dailyMenu.setMeals(meals);
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(dailyMenu));
	}
	@Test
	public void mealsJSON(){
		
		
		Gson gson = new Gson();
		System.out.println(gson.toJson(m1));
		System.out.println(gson.toJson(m2));
		System.out.println(gson.toJson(m3));
		
	}
	
	@Test
	public void locationJSON(){
		Location loc = new Location();
		loc.setAddress("100 Frankston Avenue");
		loc.setCity("Pittsburgh");
		loc.setFullName("Homewood YMCA");
		loc.setLatitude(34.032923);
		loc.setLongitude(89.323243);
		loc.setShortName("HOMEWOODY");
		loc.setState("PA");
		loc.setZip("15213");
		loc.setDays(mon_thurs);
		
		ArrayList<MealTime> mealTimes = new ArrayList<MealTime>();
		MealTime bk = new MealTime();
		bk.setDescription("Breakfast");
		
		ArrayList<String> hours = new ArrayList<String>();
		hours.add("8:30 am");
		hours.add("10:30 am");
		
		bk.setHours(hours);
		mealTimes.add(bk);
		
		MealTime lunch = new MealTime();
		lunch.setDescription("Lunch");
		
		hours = new ArrayList<String>();
		hours.add("11:30 am");
		hours.add("1:30 pm");
		
		lunch.setHours(hours);
		mealTimes.add(lunch);
		
		MealTime snack = new MealTime();
		snack.setDescription("Snack");
		
		hours = new ArrayList<String>();
		hours.add("3:30 pm");
		hours.add("5:00 pm");
		
		snack.setHours(hours);
		mealTimes.add(snack);
		
		loc.setMealTimes(mealTimes);
		loc.setDays(mon_thurs);

		Gson gson = new Gson();
		System.out.println(gson.toJson(loc));
	}

}
