package com.citiparks.grubup.service;

import java.util.Date;

import com.citiparks.grubup.model.DailyMenu;

public interface DailyMenuService {

	public DailyMenu getMenu(Date date);
	
}
