package com.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ExcelUtil;

public class RegistrationPageTest extends BaseTest {
	private boolean flag;
	
	@BeforeClass
	public void setUpreg() {
		regp= lp.doClickOnRegLink();
	}
	
	@DataProvider
	public Object[][] getRegData() {
		Object[][] regdata=ExcelUtil.getData(Constants.SheetName);
		return regdata;
	}
	
	@Test(dataProvider="getRegData")
	public void doRegistrationTest(String fn, String ln,String mail,String phone,String pwrd,String Subs) {
		System.out.println("fn val:-" +fn);
		flag=regp.doRegistration(fn,ln,mail, phone, pwrd, Subs);
		Assert.assertFalse(flag);
	}

}
