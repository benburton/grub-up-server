package com.citiparks.grubup.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(value="/", method=RequestMethod.GET, produces={"application/xml"})
	public String sendTwilioResponse(@RequestBody String messageReceived,  BindingResult result){
	 	TwiMLResponse twiml = new TwiMLResponse();
	 	Message twlMessage;
		
	 	if(messageReceived.equalsIgnoreCase("abc")){
			twlMessage = new Message("received ABC");
			try {
				twiml.append(twlMessage);
			} catch (TwiMLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return twiml.toXML();
		}
	 	return "Command not found.";
		
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
