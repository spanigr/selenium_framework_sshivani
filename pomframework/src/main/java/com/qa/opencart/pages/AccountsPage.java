package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//1.Private By Locators
	
	private By accSections = By.cssSelector("div#content h2");
	private By header = By.cssSelector("div#logo a");
	private By logoutLink = By.linkText("Logout");
	private By searchField = By.name("search");
	private By searchButton = By.cssSelector("div#search button");
	
	
	//2.public Constructor
	 public AccountsPage(WebDriver driver){
		 this.driver=driver;
		 elementUtil= new ElementUtil(driver);
	 }
	
	//3.public methods
	 public String getAccPageTitle() {
			return elementUtil.waitForTitle(5, Constants.ACCOUNTS_PAGE_TITLE);
		}

	public String getAccPageUrl() {
			return elementUtil.getPageUrl();
		}

	public String getAccPageHeader() {
			return elementUtil.doGetText(header);
		}
	
	public SearchResultPage doSearch(String productName) {
		elementUtil.doSendKeys(searchField, productName);
		elementUtil.doClick(searchButton);
		return new SearchResultPage(driver);
	}
	
	
	
}
