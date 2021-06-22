package com.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest {
	DriverFactory df;
	public WebDriver driver;
	public Properties prop;
	public LoginPage lp;
	public AccountsPage ap;
	public RegistrationPage regp;
	
	@BeforeTest
	public void setUp() {
		
		df = new DriverFactory();
		System.out.println("In before setup df:-" +df);
		prop = df.init_prop();
		System.out.println("In before setup prop:-" +prop);
		//prop.setProperty("browser", "chrome");
		driver = df.init_driver(prop);
		System.out.println("In before setup driver:-" +driver);
		lp = new LoginPage(driver);
		System.out.println("In before setup lp:-" +lp);
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
		
}
