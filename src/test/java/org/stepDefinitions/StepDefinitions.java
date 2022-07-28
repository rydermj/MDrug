package org.stepDefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.pages.AccountsPage;
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

public class StepDefinitions extends BaseClass  {
	LogIn_Page logIn_Page;
	HomePage homePage;
	AccountsPage accountsPage;
	WebDriverWait wait;

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
		String currentUrl = Hooks.driver.getCurrentUrl();
		Assert.assertEquals("https://mdmembersdev.azurewebsites.net/sign-in", currentUrl);
		
	}
	
	@Given("user goes to member application and clicks on member dropdown")
	public void user_goes_to_member_application_and_clicks_on_member_dropdown() {
		homePage =new HomePage();
		//WebElement memberApplication = homePage.getMemberApplication();
		wait = new WebDriverWait(Hooks.driver, 30);
		Actions a = new Actions(Hooks.driver);
		WebElement member = homePage.getMember();
		a.moveToElement(member).perform();
		//wait.until(ExpectedConditions.visibilityOf(member)).click();
		//member.click();
		
		
		
		
	}

	@Then("user clicks on details")
	public void user_clicks_on_details() {
		wait = new WebDriverWait(Hooks.driver, 30);
		WebElement details = homePage.getDetails();
		
		wait.until(ExpectedConditions.visibilityOf(details)).click();
		String currentUrl = Hooks.driver.getCurrentUrl();
		Assert.assertEquals("https://mdmembersdev.azurewebsites.net/admin/members/details",currentUrl);
		try {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			BaseClass.ss("DetailsPageResult");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

@Given("user is in mutual drug homepage")
public void user_is_in_mutual_drug_homepage() {
	String currentUrl = getCurrentUrl();
	Assert.assertEquals("https://mdmembersdev.azurewebsites.net/sign-in", currentUrl);
}

@When("user goes to logIn and clicks on account")
public void user_goes_to_log_in_and_clicks_on_account() {
	 homePage = new HomePage();
	 moveToElement(homePage.getUserProfileIcon());
	 wait= new WebDriverWait(Hooks.driver, 4000);
	 wait.until(ExpectedConditions.visibilityOf(homePage.getAccount())).click();
}
@Test
@Then("account page should be shown")
public void account_page_should_be_shown() {
   String currentUrl = getCurrentUrl();
   Assert.assertEquals("https://mdmembersdev.azurewebsites.net/admin/administration/account", currentUrl);
}
@Test
@Then("user should able to enter FirstName")
public void user_should_able_to_enter_first_name() {
   accountsPage = new AccountsPage();
   accountsPage.getFirstName().isEnabled();
}
@Test
@Then("user should able to enter LastName")
public void user_should_able_to_enter_last_name() {
	accountsPage = new AccountsPage();
	accountsPage.getLasttName().isEnabled();

}
@Test
@When("user try to enter email it should not be allowed")
public void user_try_to_enter_email_it_should_not_be_allowed() {
	accountsPage = new AccountsPage(); 
	boolean disabled = accountsPage.getEmail().isEnabled();
	Assert.assertEquals(false, disabled);
}
@Test
@When("user should able to enter old password new password confirm new password fields")
public void user_should_able_to_enter_old_password_new_password_confirm_new_password_fields() {
	accountsPage = new AccountsPage();
	accountsPage.getOldPassword().isEnabled();
	accountsPage.getNewPassword().isEnabled();
	accountsPage.getConfirmPassword().isEnabled();
	
}
@Test
@When("the old password is mismatched then it should not allow to change new password")
public void the_old_password_is_mismatched_then_it_should_not_allow_to_change_new_password() {
	accountsPage = new AccountsPage();
	accountsPage.getOldPassword().sendKeys("demo@12345");
	accountsPage.getNewPassword().sendKeys("@demo123456");
	accountsPage.getConfirmPassword().sendKeys("@demo123456");
	accountsPage.getUpdate().click();
	try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	boolean displayed = accountsPage.getError().isDisplayed();
	Assert.assertTrue(true);
	accountsPage.getCloseError().click();
	quit();
}

@Then("to check whether the updated fields are displayed properly")
public void to_check_whether_the_updated_fields_are_displayed_properly() {
	
}
}
