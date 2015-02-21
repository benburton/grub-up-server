package com.citiparks.grubup.twilio;

import com.twilio.sdk.TwilioRestException;

public class TwilioTest {

	public static void main(String args[]) throws TwilioRestException
	{
		TwilioController tc = new TwilioController();
		tc.users.addPhoneNumber("412-877-6838");
		//tc.users.addPhoneNumber("412-508-1140");
		
		for (String number : tc.users.phoneNumbers)
		{
			tc.sendNearestLocations(number, "15222");
		}
	}
}
