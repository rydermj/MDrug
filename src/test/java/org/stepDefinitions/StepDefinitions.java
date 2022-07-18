package org.stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.pages.HomePage;
import org.pages.LogIn_Page;
import org.utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseClass {
	LogIn_Page logIn_Page;
	HomePage homePage;
	WebDriverWait wait;
	
	@Given("user opens google chrome and enters mutual drug application url")
	public void user_opens_google_chrome_and_enters_mutual_drug_application_url() {
		launchBrowser("firefox");
		launchUrl("https://mdmembersdev.azurewebsites.net/sign-in");
		maxWindow();
		impWait();
				
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
		 logIn_Page = new LogIn_Page();
		logIn_Page.getUserName().sendKeys("bramamurthy@mutualdrug.com");
		logIn_Page.getPassword().sendKeys("Demo@1234");
		logIn_Page.getLogInBtn().click();
	}
	@Test
	@Then("user should be navigated to apllication homepage")
	public void user_should_be_navigated_to_apllication_homepage() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals("https://mdmembersdev.azurewebsites.net/sign-in", currentUrl);
		
	}
	
	@Given("user goes to member application and clicks on member dropdown")
	public void user_goes_to_member_application_and_clicks_on_member_dropdown() {
		homePage =new HomePage();
		//WebElement memberApplication = homePage.getMemberApplication();
		wait = new WebDriverWait(driver, 30);
		Actions a = new Actions(driver);
		WebElement member = homePage.getMember();
		a.moveToElement(member).perform();
		//wait.until(ExpectedConditions.visibilityOf(member)).click();
		//member.click();
		
		
		
		
	}

	@Then("user clicks on details")
	public void user_clicks_on_details() {
		wait = new WebDriverWait(driver, 30);
		WebElement details = homePage.getDetails();
		
		wait.until(ExpectedConditions.visibilityOf(details)).click();
		String currentUrl = getCurrentUrl();
		Assert.assertEquals("https://mdmembersdev.azurewebsites.net/admin/members/details",currentUrl);
		try {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ss("DetilsPageResult");
		} catch (IOException e) {
			e.printStackTrace();
		}
		quit();
	}
}
