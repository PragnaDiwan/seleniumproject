package com.qa.open.pagetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.Loginpage;
import com.qa.opencart.pages.Productinfopage;
import com.qa.opencart.pages.Registrationpage;
import com.qa.opencart.pages.Searchresultpage;

public class Basetest {

	Loginpage loginpage;
	Properties prop;
	DriverFactory df;
	WebDriver driver;
	AccountPage accountpage;
	Searchresultpage searchresultpage;
	Productinfopage productinfopage;
	Registrationpage registrationpage;
	
	@BeforeTest
	public void setup()
	{
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginpage=new Loginpage(driver);
	}
	
	
	
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	
	
}
