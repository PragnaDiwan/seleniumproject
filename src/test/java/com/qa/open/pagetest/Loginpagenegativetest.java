package com.qa.open.pagetest;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constants.Constants;

public class Loginpagenegativetest extends Basetest {
	
	
	@DataProvider
	public Object[][] loginwrongtestdata()
	{
		return new Object [][] {
			{"test@gmail.com","test123"},
			{"test@gmail.com","test1234"},
			{"",""}
			
			
	};
	}
	
	
	
	@Test(dataProvider="loginwrongtestdata")
	
	public void loginegativetest(String username,String password)
	{
		Assert.assertFalse(loginpage.loginwithneg(username, password));
	}

}
