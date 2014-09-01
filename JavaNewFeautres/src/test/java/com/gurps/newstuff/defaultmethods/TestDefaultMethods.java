package com.gurps.newstuff.defaultmethods;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestDefaultMethods {

	@Test
	public void test() {
		AeroplaneBluePrint airplane = new JumboJet();
		airplane.takeOff();
		System.out.println("current destination = " + airplane.getCurrentDestination());
	}
}
