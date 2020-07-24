package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.Base.TestBase;
import com.crm.qa.pages.Contacts;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage login;
	HomePage homepage;
	Contacts Contactspage;
	String SheetName="Contacts";
	
	public ContactsPageTest() {
		super();
		
		
	}
	
	@BeforeMethod
	public void SetUp() {
		initialisation();
		login = new LoginPage();
		Contactspage= new Contacts();
		homepage=login.Login(prop.getProperty("username"), prop.getProperty("password"));
		Contactspage=homepage.ClickContactsLink();
		
	}
	@Test(priority=1)
	public void VerifyContcatsLabelTest() {
		Contactspage.ContactsLabel();
		
	}
	@Test(priority=2)
	public void VerifyShowFilterButton() {
	Assert.assertTrue(Contactspage.VerifyshowFilterButton(),"ShowFilterButton is enbled");
	}
	
	@Test(priority=3)
	public void VerifyContactcreatebutton() {
		Contactspage.newcontactbutton();
		System.out.println("clicked on createcontact button");
	}
	
	@Test(priority=5)
	public void VerifyContactsSaveButtonTest() {
		Contactspage.SaveButton();
		System.out.println("clicked on save button");
	}
	@DataProvider
	public Object[][] getcrmTestData() {
		Object data[][]=TestUtil.getTestData(SheetName);
		return data;
		
	}
	
	@Test(priority=4, dataProvider="getcrmTestData")
	public void VerifyCreateNewContactTest(String FirstName, String LastName) {
		//homepage.ClickContactsLink();
		Contactspage.CreateNewContact(FirstName,LastName);
		System.out.println("entered contact details");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
