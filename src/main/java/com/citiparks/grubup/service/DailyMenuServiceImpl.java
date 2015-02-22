package com.citiparks.grubup.service;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.citiparks.grubup.model.DailyMenu;

@Service
public class DailyMenuServiceImpl implements DailyMenuService {

	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	@Override
	public DailyMenu getMenu(Date date) {
		return entityManager.find(DailyMenu.class, date);	    

	}

}
