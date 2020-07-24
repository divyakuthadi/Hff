package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	
	
	public LoginPageTest() {
		super();
	}
	@BeforeMethod
	public void SetUp() {
		initialisation();
	    login = new LoginPage();
	    
		}
	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		String Title=login.ValidatePageTitile();
		log.info("verified login pagetitile");
	}
	@Test(priority =2)
	public void LoginTest() {
		homepage=login.Login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
	

}
