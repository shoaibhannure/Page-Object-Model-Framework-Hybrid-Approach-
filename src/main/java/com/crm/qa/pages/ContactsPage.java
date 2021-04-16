package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement ConatctsLogo;

	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public boolean verifyContactsLabel() {
		return ConatctsLogo.isDisplayed();
	}

	public void selectContactByName() {

		WebElement clickCheckbox = driver.findElement(
				By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[2]/div/table/tbody/tr[3]/td[1]/div/label"));
		clickCheckbox.click();

	}

}
