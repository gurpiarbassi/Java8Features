package com.gurps.newstuff.defaultmethods;

public interface AeroplaneBluePrint {

	void takeOff();
	
	void land();
	
	default String getCurrentDestination(){
		return "unknown";
	}
}
