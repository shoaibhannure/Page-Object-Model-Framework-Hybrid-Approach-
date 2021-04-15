package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	LandingPage landingPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage= new LandingPage();
		loginPage = landingPage.ClickSignInButton();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}

	@Test(priority = 1)
	public void verifyUserNameTest() {
		homePage.checkUserName();
		Assert.assertTrue(homePage.checkUserName());

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
