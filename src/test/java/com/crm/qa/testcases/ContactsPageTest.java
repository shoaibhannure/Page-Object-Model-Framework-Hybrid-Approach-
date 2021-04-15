package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase {
	LandingPage landingPage;
	HomePage homePage;
	ContactsPage contactsPage;
	LoginPage loginPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		contactsPage= new ContactsPage();
		loginPage = landingPage.ClickSignInButton();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void contactLinkTest(){
		contactsPage=homePage.clickOnContacts();
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
