package com.citiparks.grubup.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiparks.grubup.model.DailyMenu;
import com.citiparks.grubup.model.Meal;

@Service
public class DailyMenuServiceImpl implements DailyMenuService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public DailyMenu getMenu(Date date) {
		return entityManager.find(DailyMenu.class, date);	    

	}

	@Override
	public Meal getBreakfast() {
		/*return entityManager.createQuery(
					"SELECT * FROM DailyMenu WHERE DailyMenu.meal :mealName")
					.setParameter("mealName", "breakfast")
					.getResultList().get(0);*/
		return null;
	}

	@Override
	public Meal getLunch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Meal getSnack() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
