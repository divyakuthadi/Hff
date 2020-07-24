package com.crm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

 public static WebDriver driver;
 public static Properties prop;
// public static WebEventListener eventlistener;
 //public static EventFiringWebDriver e_driver;
 public static Logger log;
	
	public TestBase()  {
		 prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") +"/src/main/java/com/crm/qa/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		
	}
	
	public static void initialisation() {
		String Browser=prop.getProperty("Browser");
		if(Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\My\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
		}
			else{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\My\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
				driver= new ChromeDriver();
				log= Logger.getLogger(TestBase.class);
				
			}
	//	e_driver= new EventFiringWebDriver(driver);
		//eventlistener= new WebEventListener();
		//e_driver.register(eventlistener);
		//driver=e_driver;
		
		driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
			
			
		}
	}

