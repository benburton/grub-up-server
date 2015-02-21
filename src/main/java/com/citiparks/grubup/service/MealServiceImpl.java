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
	
	@Transactional
	@Override
	public Meal getMeal(Integer mealId){
		return entityManager.find(Meal.class, mealId);
	}
	
	@Transactional
	@Override
	public void addMeal(Meal meal){
		entityManager.persist(meal);
	}
	
	@Transactional
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
		CriteriaQuery<Meal> c = entityManager.getCriteriaBuilder().createQuery(Meal.class);
	    c.from(Meal.class);
	    return entityManager.createQuery(c).getResultList();
	    
	}
	
}
