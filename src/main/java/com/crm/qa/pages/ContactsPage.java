package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	
	@FindBy(xpath="//div[text()='Contacts']")
    WebElement ConatctsLogo;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean verifyContactsLabel(){
		return ConatctsLogo.isDisplayed();
	}
	
}
