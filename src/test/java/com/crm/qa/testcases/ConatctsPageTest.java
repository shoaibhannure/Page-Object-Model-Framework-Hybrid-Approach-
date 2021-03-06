package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ConatctsPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	CreateNewContactPage createNewContactPage;

	public ConatctsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		loginPage = landingPage.ClickSignInButton();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContacts();

	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is missing");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		contactsPage.selectContactByName();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
