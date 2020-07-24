package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//span[contains(text(),'divya kuthadi')]")
	WebElement NameTitle;
	
	@FindBy(xpath="//*[@id=\"main-nav\"]/a[3]/span")
	WebElement ContactsLink;

	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement TaskLink;
	
	@FindBy(partialLinkText="/contacts/new")
	WebElement NewContcatbutton;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		
	}
	public boolean VerifyUserName() {
		return NameTitle.isDisplayed();
		
	}
	
	public String VerifyHomePageTitle() {
		return driver.getTitle();
	}
		
	public Contacts ClickContactsLink() {
		ContactsLink.click();
		return new Contacts();
	}
		
	
	public Deals ClickDealsPage() {
		DealsLink.click();
		return new Deals();
	}
	
	
	public Tasks ClickTaskLink() {
		TaskLink.click();
		return new Tasks();
	}
	
	public void NewContactsLinkButton() {
		NewContcatbutton.click();	
	}
}

