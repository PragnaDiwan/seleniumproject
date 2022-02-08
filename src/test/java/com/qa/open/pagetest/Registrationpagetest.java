package com.qa.open.pagetest;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registrationpagetest extends Basetest {

	
	
	@BeforeClass
	public void setupregistration()
	{
		registrationpage=loginpage.getregisterpage();
	}
	
	
	@Test
	
	public void userregistrationtest() throws InterruptedException
	{
		Assert.assertTrue(registrationpage.accountregistration("pragn", "diwan", "pr67@gmail.com", "814114396", "pr@1234","yes"));
		
	}
}
