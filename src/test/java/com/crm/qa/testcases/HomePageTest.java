package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	LoginPage login;
	HomePage homepage;
	Contacts Contactspage;
	
	public HomePageTest() {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() {
		initialisation();
		login = new LoginPage();
		Contactspage= new Contacts();
		homepage=login.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void VerifyHomePageTitleTest() {
		String HomepageTitle=homepage.VerifyHomePageTitle();
		System.out.println("The HomePageTitle is: " +HomepageTitle);
	}
	@Test(priority =2)
	public void VerifyUserNameDisplayedTest() {
		homepage.VerifyUserName();
		
	}
	@Test(priority = 3)
	public void VerifyContactsLinkTest() {
		Contactspage=homepage.ClickContactsLink();
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
