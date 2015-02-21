package com.citiparks.grubup.twilio;

import java.util.ArrayList;

public final class UserDAO {

	//this will eventually be a page on the database
	ArrayList<String> phoneNumbers = new ArrayList();
	
	public void addPhoneNumber(String p)
	{
		phoneNumbers.add(p);
	}
	
	public void removePhoneNumber(String p)
	{
		phoneNumbers.remove(p);
	}
	
	public boolean hasPhoneNumber(String p)
	{
		return phoneNumbers.contains(p);
	}
	
	public ArrayList<String> getAllNumbers()
	{
		return phoneNumbers;
	}
}
