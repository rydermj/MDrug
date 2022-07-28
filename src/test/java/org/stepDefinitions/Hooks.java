package org.stepDefinitions;

import org.junit.After;
import org.junit.Before;
import org.utilities.BaseClass;

import io.cucumber.java.en.Given;

public class Hooks extends BaseClass {
	@Before
	@Given("user opens google chrome and enters mutual drug application url")
	public void user_opens_google_chrome_and_enters_mutual_drug_application_url() {
		launchBrowser("chrome");
		launchUrl("https://mdmembersdev.azurewebsites.net/sign-in");
		maxWindow();
		impWait();
				
	}
	
	@After
	public static void tearDown() {
		quit();
	}

}
