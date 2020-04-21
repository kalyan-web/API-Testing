package com.cucumber;
import org.apache.commons.configuration.ConfigurationException;

import utilities.RestAssuredExtension;
import cucumber.api.java.Before;


public class Initialization {
	@Before
	public void TestSetup() throws ConfigurationException{
		try {
			RestAssuredExtension restAssuredExtension = new RestAssuredExtension();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

}
