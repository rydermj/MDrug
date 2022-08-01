package org.stepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.utilities.BaseClass;

import io.cucumber.java.en.Given;

public class Hooks extends BaseClass  {
	@Before
	@Given("user opens google chrome and enters mutual drug application url")
	public void user_opens_google_chrome_and_enters_mutual_drug_application_url() {
		loadProperties();
		Constants.browser=property.getProperty("browser");
		Constants.url=property.getProperty("url");
		Constants.username=property.getProperty("username");
		Constants.password=property.getProperty("password"); 
		launchBrowser(property.getProperty("browser"));
		launchUrl(Constants.url);
		maxWindow();
		impWait();
				
	}
	
	@After
	public static void tearDown() {
		quit();
	}

}
