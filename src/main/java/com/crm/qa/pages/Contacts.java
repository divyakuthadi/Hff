package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.Base.TestBase;

public class Contacts extends TestBase {
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement ContactsLabel ;
	
	@FindBy(xpath="//button[contains(text(),'Show Filters')]")
	WebElement ShowFilterButton ;
	
	@FindBy(xpath="//i[@class='edit icon']")
	WebElement createnewcontbutton ;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement FirstName ;
	
	@FindBy(name="last_name")
	WebElement LastName ;
	
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement ContactsSaveButton;
	

	
public Contacts() {
	PageFactory.initElements(driver,  this);
}
public boolean ContactsLabel() {
	return ContactsLabel.isDisplayed();
}

public boolean VerifyshowFilterButton() {
	return ShowFilterButton.isEnabled();
	
}

public void newcontactbutton() {
	createnewcontbutton.click();
	
}

public void CreateNewContact( String fname, String lname) {
	FirstName.sendKeys(fname);
	LastName.sendKeys(lname);
	
	//Select select = new Select(driver.findElement(By.name("Category")));
	//select.selectByValue(options);
}
	public void SaveButton() {
	ContactsSaveButton.click();
	
	
	
	
	
}
}
