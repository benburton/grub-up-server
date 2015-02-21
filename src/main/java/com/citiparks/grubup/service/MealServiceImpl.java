package com.citiparks.grubup.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiparks.grubup.model.Meal;

@Service
public class MealServiceImpl implements MealService{

	@PersistenceContext
	EntityManager entityManager;
	 
	@Override
	public Meal getMeal(Integer mealId){
		return entityManager.find(Meal.class, mealId);
	}
	
	@Override
	public void addMeal(Meal meal){
		entityManager.persist(meal);
	}
	
	@Override
	public boolean deleteMeal(Integer mealId){
		Meal meal = entityManager.find(Meal.class, mealId);
	    if (null != meal) {
	      entityManager.remove(meal);
	      return true;
	    }
	    return false;
	}
	
	@Transactional
	@Override
	public List<Meal> getAllMeals() {
		/*List<Meal> meals = new ArrayList<Meal>();
		Meal m = new Meal();
		m.setMeal("123");
		ArrayList<String> mealItems = new ArrayList<String>();
		mealItems.add("applesauce");
		mealItems.add("bananas");
		m.setMealItems(mealItems);
		m.setMeal("snack");
		meals.add(m);
		
		return meals;*/
		CriteriaQuery<Meal> c = entityManager.getCriteriaBuilder().createQuery(Meal.class);
	    c.from(Meal.class);
	    return entityManager.createQuery(c).getResultList();
	    
	}
	
}
