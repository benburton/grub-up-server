package com.citiparks.grubup.twilio;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.citiparks.grubup.controller.MealController;
import com.citiparks.grubup.model.Location;
import com.citiparks.grubup.model.Meal;
import com.citiparks.grubup.service.LocationServiceImpl;

public class TwilioController {
	
	// Find your Account Sid and Token at twilio.com/user/account
	public static final String ACCOUNT_SID = "something";
	public static final String AUTH_TOKEN = "something";
	TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
	
	public UserDAO users = new UserDAO();//this should be private, but I'm
	//doing this for testing
	private LocationServiceImpl locService = new LocationServiceImpl();
	
	public void routeRequest(HttpServletRequest request) throws TwilioRestException
	{
		String phoneNumber = request.getParameter("From");
		String body = request.getParameter("Body");
		
		if (body == "menu")
		{
			sendMenu(phoneNumber);
		}
		else //we'll do sendAddress later
		{
			sendNearestLocations(phoneNumber, body);
		}
	}
	
	public void sendNearestLocations(String phoneNumber, String zipcode) throws TwilioRestException
	{
		if (users.hasPhoneNumber(phoneNumber))
		{	
			String zip = "^\\d{5}";
			if (zipcode == null || zipcode.matches(zip))
			{
				//do stuff to get the zipcode based on the current geolocation
			}
			
			String locationList = locService.getLocationsByZipcodeAsString(zipcode).toString();
			sendMessage(phoneNumber, locationList);
		}
	}
	
	public void sendLocationAddress(String phoneNumber, String shortName) throws TwilioRestException
	{
		if (users.hasPhoneNumber(phoneNumber))
		{
			String address = locService.getLocationAddress(shortName);			
			sendMessage(phoneNumber, address);
		}
	}
	
	public void sendMenu(String phoneNumber) throws TwilioRestException
	{
		if (users.hasPhoneNumber(phoneNumber))
		{
			MealController mCtrl = new MealController();
			List<Meal> mealList = mCtrl.getAllMeals();
			String message = "";
			for (int i = 0; i < mealList.size(); i++)
			{
				Meal m =  mealList.get(i);
				for (String s : m.getMealItems())
				{
					message += s + "\n";
				}
				message += "\n";
			}
			
			sendMessage(phoneNumber, message);
		}
	}
	
	public void sendMessage(String phoneNumber, String body) throws TwilioRestException
	{
		List<NameValuePair> params = new ArrayList<NameValuePair>(); 
		 params.add(new BasicNameValuePair("To", phoneNumber)); 
		 params.add(new BasicNameValuePair("From", "+14124447511")); 
		 params.add(new BasicNameValuePair("Body", body));   
	 
		 MessageFactory messageFactory = client.getAccount().getMessageFactory(); 
		 Message message = messageFactory.create(params); 
		 System.out.println(message.getSid()); 
	}
	
	
	
}
