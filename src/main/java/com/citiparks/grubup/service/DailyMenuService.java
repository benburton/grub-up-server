package com.citiparks.grubup.service;

import java.util.Date;

import com.citiparks.grubup.model.DailyMenu;
import com.citiparks.grubup.model.Meal;

public interface DailyMenuService {

	public DailyMenu getMenu(Date date);
	public void addDailyMenu(DailyMenu menu);
	public Meal getBreakfast();
	public Meal getLunch();
	public Meal getSnack();
	
}
