package org.pages;

import org.utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn_Page extends org.utilities.BaseClass {
	

	public LogIn_Page() {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "username")
	private WebElement userName;

	public WebElement getUserName() {
		return userName;
	}

	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(xpath="//a[.='Sign Up']")
	private WebElement Clk_SignUp;

	public WebElement getPassword() {
		return password;
	}
	@FindBy(tagName = "button")
	private WebElement logInBtn;

	public WebElement getLogInBtn() {
		return logInBtn;
	}
	public WebElement getClk_SignUp() {
		return Clk_SignUp;
	}
	

}
