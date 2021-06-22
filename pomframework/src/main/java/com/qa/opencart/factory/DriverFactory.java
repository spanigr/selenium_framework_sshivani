package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory  {

	 WebDriver driver;
	 Properties prop;	
//	 ThreadLocal<WebDriver> tldriver= new ThreadLocal<>(); 
	/**
	 * 
	 * @param prop
	 * @return webDriver driver
	 * initialize browser
	 * 
	 * 
	 */
	public  WebDriver init_driver(Properties prop){
			String browser= prop.getProperty("browser");
	
			switch(browser) {		
		case "chrome":{
			WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		//tldriver.set(new ChromeDriver());
			break;
		}case "firefox":{
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		//	tldriver.set(new FirefoxDriver());  
			break;
		}default:
			System.out.println("invalid browser Name!!");
			break;
		}
		
//		getDriver().manage().window().maximize();
//		getDriver().manage().deleteAllCookies();
//		getDriver().get(prop.getProperty("url"));
//	
//	return getDriver();
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
	
//	public  synchronized WebDriver getDriver() {
//		return tldriver.get();
//	}

	/**
	 * 	
	 * @return properties object
	 * 
	 * sets config.properties file as per env level into 'ip'
	 * loads 'ip' to''prop' 
	 */
	public  Properties init_prop() {
		Properties prop = new Properties();
		FileInputStream ip = null;
		
		String env = prop.getProperty("env");		
		
		if (env == null) {
		try {ip = new FileInputStream("./src/test/resources/config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			} else { System.out.println("Config properties is set only for chrome");	}
		
		try {prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return prop;
	}	
	
	public  String getScreenshot() {
		
		File src=((TakesScreenshot) driver).getScreenshotAs((OutputType.FILE));
		String path=System.getProperty("user.dir")+"/Screenshots/"+System.currentTimeMillis()+".png";
		File dest = new File(path);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}

}

