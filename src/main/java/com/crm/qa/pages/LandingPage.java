package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase {

	//PageFactory: OR (Object Repository)
	@FindBy(xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	
	WebElement landingLoginButton;

	@FindBy(css="//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
	WebElement signupbutton;
	
	@FindBy(xpath="//a[@title='free crm home']//span[contains(text(),'free')]")
	WebElement FreeCrmLogo;
	
	public LandingPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean verifyCrmLogo(){
		return FreeCrmLogo.isDisplayed();
		}
	
	public LoginPage ClickSignInButton(){
		landingLoginButton.click();
		return new LoginPage();
	}
	
	public LoginPage signInbuttonClick(){
		landingLoginButton.click();
		return new LoginPage();
	}
	
	public String validateLandingPageTitle(){
		return driver.getTitle();
	}
	
	
}

