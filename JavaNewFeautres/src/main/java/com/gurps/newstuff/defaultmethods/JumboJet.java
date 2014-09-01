package com.gurps.newstuff.defaultmethods;

public class JumboJet implements AeroplaneBluePrint{

	
	public void takeOff() {
		System.out.println("Taking off....");
		
	}
	
	public void land() {
		System.out.println("Landing....");		
	}	
	
	public String getCurrentDestination(){
		return "the moon";
	}
}
