package com.citiparks.grubup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.citiparks.grubup.model.Location;
import com.citiparks.grubup.service.LocationService;
import com.twilio.sdk.verbs.Message;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

/**
 * Controller that responds to incoming SMS messages
 * 
 * @author tonyaedmonds
 *
 */
@RestController
@RequestMapping("/twilio")
public class TwilioController {

	@Autowired
	LocationService locationService;
	
	@RequestMapping(value="/", method=RequestMethod.POST, produces={"application/xml"})
	public String sendTwilioResponse(@RequestBody String messageReceived,  BindingResult result){
	 	TwiMLResponse twiml = new TwiMLResponse();
	 	Message twlMessage = null;
	 	String zip = "\\d{5}";
	 	
	 	//route expected commands
	 	if(messageReceived.equalsIgnoreCase("lunch")){
			twlMessage = new Message("received lunch");
	 	}else if(messageReceived.equalsIgnoreCase("breakfast")){
	 		twlMessage = new Message("received breakfast");
	 	}else if(messageReceived.equalsIgnoreCase("snack")){
	 		twlMessage = new Message("received snack");
	 	}else if(messageReceived.matches(zip)){
	 		List<Location> locations = locationService.getNearestLocations(messageReceived);
	 		StringBuilder str = new StringBuilder();
	 		
	 		for(Location loc: locations){
	 			str.append(loc.toString());
	 		}
	 		twlMessage = new Message(str.toString());
	 		
	 	}else{
	 		twlMessage = new Message("Command not found");
	 	}
	 	//TODO: it is only returning ONE location!!! FIX ME
		try {
			twiml.append(twlMessage);
		} catch (TwiMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return twiml.toXML();
		
	}
	@RequestMapping(value="/location", method=RequestMethod.GET, produces={"application/xml"})
	public String getLocation(){
		 	TwiMLResponse twiml = new TwiMLResponse();
	        Message message = new Message("Carnegie Library Oakland");
	        try {
	            twiml.append(message);
	        } catch (TwiMLException e) {
	            e.printStackTrace();
	        }
	 
	        return twiml.toXML();
	}
	
}
