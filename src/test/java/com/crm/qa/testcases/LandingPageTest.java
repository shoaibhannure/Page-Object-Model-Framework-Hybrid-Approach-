package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;

public class LandingPageTest extends TestBase {

	LandingPage landingPage; /*
								 * Define landingPage variable at Class Level.
								 * So that we can use it entirely
								 */

	public LandingPageTest() {
		super(); // It will call super class Constructor
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		// Create Object of Landing Page Class
		landingPage = new LandingPage();

	}

	@Test
	public void landingPageTitleTest() throws InterruptedException {
		String title = landingPage.validateLandingPageTitle();
		Assert.assertEquals(title, "#1 Free CRM customer relationship management software cloud");
	}

	@Test
	public void CRMlogoTest() {
		boolean flag = landingPage.verifyCrmLogo();
		Assert.assertTrue(flag); // If flag is true Test Case Pass else Fail
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}
}
