package com.crm.qa.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.CreateNewContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class CreateNewContactPageTest extends TestBase {
	LandingPage landingPage;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	CreateNewContactPage createNewContactPage;
	String sheetName= "Contacts";

	public CreateNewContactPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		landingPage = new LandingPage();
		loginPage = new LoginPage();
		createNewContactPage= new CreateNewContactPage();
		loginPage = landingPage.ClickSignInButton();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContacts();

	}
	
	@DataProvider
	public Object[][] getCRMTestData (){
		Object data[][]=TestUtil.getTestData(sheetName);
		//All rows wil be stored in data[][]
		return data;
	}
	
	@Test(priority=1)
	public void validateCreateNewContact() {
		contactsPage.clickCreateContactButton();
		createNewContactPage.createNewContact("Shoaib", "Hannure", "On Hold", "Facebook");
	}
	
	@Test(priority=2, dataProvider="getCRMTestData" )
	public void validateCreateNewContactbyDataProvider(String ftName, String ltName, String status, String src) {
		contactsPage.clickCreateContactButton();
		//createNewContactPage.createNewContact("Shoaib", "Hannure", "On Hold", "Facebook");
		createNewContactPage.createNewContact(ftName, ltName, status, src);
	}
}
