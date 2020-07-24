package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.Base.TestBase;

public class LoginPage extends TestBase{
@FindBy(xpath="//input[@name='email']")
WebElement username;

@FindBy(xpath="//input[@name='password']")
WebElement password;

@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
WebElement loginbutton;

public LoginPage() {
	PageFactory.initElements(driver, this);
	
}
public String ValidatePageTitile() {
	return driver.getTitle();
}

public HomePage Login(String uname,String pwd) {
	username.sendKeys(uname);
	password.sendKeys(pwd);
	loginbutton.click();
	return new HomePage();
	
}


		
	}


