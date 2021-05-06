package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath = "//input[@placeholder='E-mail address']")
	WebElement username;

	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement password;

	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement loginPageButton;

	@FindBy(xpath = "//a[normalize-space()='Forgot your password?']")
	WebElement forgotyourpasswordbutton;

	@FindBy(xpath = "//a[normalize-space()='Sign Up']")
	WebElement signupbutton;

	@FindBy(xpath = "//*[name()='path' and contains(@class,'foreground')]")
	WebElement subscribeToNotificationLogo;

	// Create a Method, initialize all the object repository
	// initialize Elements with the help of Page Factory
	// Create Constructor of the Class

	// Initializing the Page Objects
	public LoginPage() {
		PageFactory.initElements(driver, this); // driver is coming from
												// testBase class
		// this means current class object
		// PageFactory.initElements(driver, LoginPage.class);
	}

	// Actions
	public String validateLoginPageTitle() {
		return driver.getTitle(); // Method should return title of the page
	}

	public boolean subscribeToNotificationImage() {
		return subscribeToNotificationLogo.isDisplayed();

	}
	
	public HomePage login(String un, String pwd) {
		username.clear();
		username.sendKeys(un);

		password.clear();
		password.sendKeys(pwd);
		loginPageButton.click();
		return new HomePage();
	}
	
}
