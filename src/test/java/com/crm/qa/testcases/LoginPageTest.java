package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {

	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod()
	public void setUp() throws InterruptedException {
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.ClickSignInButton();
		
	}

	@Test(priority = 1)
	public void loginButtonClick() {
	
		String loginPageTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginPageTitle, "Cogmento CRM", "Login Page Title Verified Successfully");
	}

	@Test(priority = 2)
	public void subscribeToImageNotificationTest() {
		boolean flag = loginPage.subscribeToNotificationImage();
		Assert.assertTrue(flag);
	}

	@Test(priority = 3)
	public void loginTest() {
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		

	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
