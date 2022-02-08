package com.qa.open.pagetest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.constants.Constants;

public class Loginpagetest extends Basetest {
	
	
	@Test(priority=1)
	public void loginpageTitleTest()
	{
		String acttitle= loginpage.getloginpagetitle();
		System.out.println(acttitle);
		Assert.assertEquals(acttitle,Constants.LOGIN_PAGE_TITLE);
	}

	@Test(priority=2)
	public void loginpageurlTest()
	{
		
		Assert.assertTrue(loginpage.getLoginpageurl());
		
	}
	
	@Test(priority=3)
	public void forgotpwdlinktest()
	{
		Assert.assertTrue(loginpage.forgotpwdlinkexist());
	}
	
	@Test(priority=4)
	public void registerlinktest()
	{
		Assert.assertTrue(loginpage.registerlinkexist());
	}
	
	@Test(priority=5)
	public void Logintest()
	{
		accountpage=loginpage.dologin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		
		Assert.assertEquals(accountpage.getaccountapagettile(), Constants.ACCOUNT_PAGE_TITLE);
	}
}
