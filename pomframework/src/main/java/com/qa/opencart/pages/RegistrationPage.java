package com.qa.opencart.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RegistrationPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//private locators
	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input");
	
	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
	private By sucessMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");
	
	private Boolean subscribe = false;
	
	//Public Constructor
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		elementUtil= new ElementUtil(driver);
	}
	
	public boolean doRegistration(String fn, String ln,String mail,String phone,
										String pwrd,String Subs) { 
																				
		elementUtil.doSendKeys(this.firstName, fn);
		elementUtil.doSendKeys(this.lastName, ln);
		elementUtil.doSendKeys(this.email, mail);
		elementUtil.doSendKeys(this.telephone, phone);
		elementUtil.doSendKeys(this.password, pwrd);
		elementUtil.doSendKeys(this.confirmpassword, pwrd);
			if(Subs.equalsIgnoreCase("yes")) {
			elementUtil.doClick(this.subscribeYes);
			}else {
			elementUtil.doClick(this.subscribeNo);
			}			
		elementUtil.doClick(this.agreeCheckBox);
		elementUtil.doClick(this.continueButton);
		
		String successMsg=elementUtil.waitForElementVisible(sucessMessg, 5).getText();
		if(successMsg.contains(Constants.REGISTER_SUCCESS_MESSG)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);
			return true;
		}else {
			return false;
		}
			
	}
	
}
