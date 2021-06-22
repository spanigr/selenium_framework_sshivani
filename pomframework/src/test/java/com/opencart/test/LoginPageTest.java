package com.opencart.test;

import com.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

	@Test
	public void titileTest() {
		String title=lp.getLoginPageTitle();
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}

}
