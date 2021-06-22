package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	
	private ElementUtil elementUtil;
	private WebDriver driver;

	// 1. private By locators:
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.xpath("//input[@type='submit']");
	private By forgotPwdLink = By.xpath("//div[@class='form-group']//a[text()='Forgotten Password']");
	private By registerLink = By.linkText("Register");
	private By loginErrorMessg = By.cssSelector("div.alert.alert-danger.alert-dismissible");
	
	// 2. public constructors
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Public methods
	public String getLoginPageTitle() {
		return elementUtil.waitForTitle(5, Constants.LOGIN_PAGE_TITLE);
	}
	
	public AccountsPage doLogin(String un, String pwd ) {
		elementUtil.doSendKeys(username,un);
		elementUtil.doSendKeys(password,pwd);
		elementUtil.doClick(loginButton);		
		return new AccountsPage(driver);
	}
	
	public RegistrationPage doClickOnRegLink() {
		elementUtil.doClick(this.registerLink);
		return new RegistrationPage(driver);
	}
	
}
