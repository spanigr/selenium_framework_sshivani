package com.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class AccountsPageTest extends BaseTest{

	@BeforeClass
	public void setup() {
		ap= lp.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void titleTest() {
		String title=ap.getAccPageTitle();
		Assert.assertEquals(title, Constants.ACCOUNTS_PAGE_TITLE);
	}

		
	
}
