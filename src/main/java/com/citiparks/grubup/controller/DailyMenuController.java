package com.citiparks.grubup.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.citiparks.grubup.model.DailyMenu;
import com.citiparks.grubup.service.DailyMenuService;


@RequestMapping("menu/")
@RestController
public class DailyMenuController {
	
	@Autowired
	private DailyMenuService dailyMenuService;
	
	 @RequestMapping("/")
	  public DailyMenu getDailyMenu(@PathVariable Date date) {
		  return dailyMenuService.getMenu(date);
	  }


}
