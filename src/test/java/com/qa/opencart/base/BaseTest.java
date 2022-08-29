package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.undostres.factory.DriverFactory;
import com.qa.undostres.pages.LoginPage;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	
	public DriverFactory df;
	
	public LoginPage loginPage;
	
	
	public SoftAssert softAssert;
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
