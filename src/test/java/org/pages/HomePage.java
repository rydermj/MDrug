package org.pages;

import org.utilities.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-file-text']")
	private WebElement memberApplication;
	
	@FindBy(css="i.fa.fa-user")
	private WebElement member;
	
	@FindBy(xpath="//span[text()='Details']")
	private WebElement details;
	
	@FindBy(xpath="//a[@class='nav-link router-link-active']")
	private WebElement users;
	
	@FindBy(xpath="//a[@routerlink='members/roles']//span[1]")
	private WebElement roles;
	
	@FindBy(xpath="//a[@class='user-profile-icon']")
	private WebElement userProfileIcon;
	
	@FindBy(xpath="//a[.=' Account']")
	private WebElement Account;

	public WebElement getUserProfileIcon() {
		return userProfileIcon;
	}

	public WebElement getAccount() {
		return Account;
	}

	public WebElement getMemberApplication() {
		return memberApplication;
	}

	public WebElement getMember() {
		return member;
	}

	public WebElement getDetails() {
		return details;
	}

	public WebElement getUsers() {
		return users;
	}

	public WebElement getRoles() {
		return roles;
	}
	
	
	

}
