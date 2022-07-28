package org.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.stepDefinitions.Hooks;

public class AccountsPage {
	
	public AccountsPage() {
		PageFactory.initElements(Hooks.driver, this);
	}
	
	@FindBy(name="firstName")
	private WebElement FirstName;
	
	@FindBy(name="lastName")
	private WebElement LasttName;
	
	@FindBy(name="email")
	private WebElement Email;
	
	@FindBy(name="oldPassword")
	private WebElement OldPassword;
	
	@FindBy(name="password")
	private WebElement NewPassword;
	
	@FindBy(name="confirmPassword")
	private WebElement ConfirmPassword;
	
	@FindBy(xpath="//button[.='Update']")
	private WebElement Update;
	
	@FindBy(xpath="//div[text()[normalize-space()='Old password is incorrect.']]")
	private WebElement Error;
	
	@FindBy(xpath="//span[text()='×']")
	private WebElement CloseError;
	
	@FindBy(id="toast-container")
	private WebElement ToastContainer;
	
	

	public WebElement getError() {
		return Error;
	}

	public WebElement getCloseError() {
		return CloseError;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLasttName() {
		return LasttName;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getOldPassword() {
		return OldPassword;
	}

	public WebElement getNewPassword() {
		return NewPassword;
	}

	public WebElement getConfirmPassword() {
		return ConfirmPassword;
	}

	public WebElement getUpdate() {
		return Update;
	}
	
	

}
