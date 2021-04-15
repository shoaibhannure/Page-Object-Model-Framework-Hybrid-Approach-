package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[text()='Shoaib Hannure']")
	WebElement userNameLabel;

	@FindBy(xpath="//a[@href='/contacts']")
	WebElement clickContactLink;
	
	@FindBy(xpath="//a[@href='/calendar']")
	WebElement clickCalendarLink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions;
	public ContactsPage clickOnContacts(){
		clickContactLink.click();
		return new ContactsPage();
		
	}
	
	public boolean checkUserName(){
		return userNameLabel.isDisplayed();
	}
	
	
	
	
}
