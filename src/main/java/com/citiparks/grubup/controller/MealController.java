package com.citiparks.grubup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citiparks.grubup.model.Meal;
import com.citiparks.grubup.service.MealService;

@RestController
@RequestMapping("/meals")
public class MealController {

	@Autowired
	MealService mealService;
	
	//@ResponseBody
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<Meal> getAllMeals(){
		return mealService.getAllMeals();
	}
	
	//@ResponseBody
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes={"application/json"})
	public void addMeal(@RequestBody Meal meal, BindingResult result){
		mealService.addMeal(meal);
	}
}