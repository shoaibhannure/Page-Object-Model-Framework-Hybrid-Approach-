package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class CreateNewContactPage extends TestBase{
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']"+
	"/form[@class='ui form segment custom-form-container']/div[10]/div[2]/div[1]/div[1]")
	WebElement source;
	
	@FindBy(xpath="//button[normalize-space()='Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//body/div[@id='ui']/div[@class='ui fluid container']/div[@class='ui fluid container']/div[@id='main-content']/div[contains(@class,'ui fluid container')]/div[@class='ui fluid container main-content']/form[@class='ui"+
	" form segment custom-form-container']/div[5]/div[1]/div[1]/div[1]")
	WebElement status;
	
	public CreateNewContactPage(){
		PageFactory.initElements(driver, this);
	}

	//Actions
	public void createNewContact(String ftName, String ltName, String status, String src){
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		
		
		Select selectstatus = new Select(driver.findElement(By.name("status")));
		selectstatus.selectByVisibleText(status);
		
		Select selectSource = new Select(source);
		selectSource.selectByVisibleText(src);
		
		saveButton.click();
	}
}
