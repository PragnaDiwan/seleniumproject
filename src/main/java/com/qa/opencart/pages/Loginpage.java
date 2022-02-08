package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.constants.ElementUtil;


public class Loginpage {
	
	
	private WebDriver driver;
	private ElementUtil eleutl;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		eleutl=new ElementUtil(driver);
	}
	

	
	
	
	private By emaild=By.id("input-email");
	private By password=By.id("input-password");
	private By loginbtn=By.xpath("//input[@value='Login']");
	private By registerlink=By.linkText("Register");
	private By forgotpasswordlink=By.linkText("Forgotten Password");
	private By errormessage=By.xpath("//div[@class='alert alert-danger alert-dismissible']");
	private By Register=By.linkText("Register");
	
	public String getloginpagetitle()
	{
		return eleutl.doGetTitle(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}
		
	public boolean getLoginpageurl()
	{
		return eleutl.waitForURLToContain(Constants.LOGIN_PAGE_URL_FRACTION,Constants.DEFAULT_TIMEOUT);
	}
	
	public boolean forgotpwdlinkexist()
	{
		return eleutl.doIsDisplayed(forgotpasswordlink);
	}
	public boolean registerlinkexist()
	{
		return eleutl.doIsDisplayed(registerlink);
	}
	
	public AccountPage dologin(String uname,String pwd)
	{
		System.out.println("login with "+uname + pwd);
		eleutl.doSendKeys(emaild, uname);
		eleutl.doSendKeys(password, pwd);
		eleutl.doClick(loginbtn);
	    return new AccountPage(driver);
	
	}
	
	public boolean loginwithneg(String uname,String pwd)
	{
		System.out.println("login with wrong credential "+uname + pwd);
		eleutl.doSendKeys(emaild, uname);
		eleutl.doSendKeys(password, pwd);
		eleutl.doClick(loginbtn);
		
		String errormessag=eleutl.doGetText(errormessage);
		System.out.println(errormessag);
		if(errormessag.contains("No match for E-Mail Address and/or Password."))
		{
			System.out.println("login is not suceessfull");
			return false;
		}
		return true;
	}
	
	public Registrationpage getregisterpage()
	{
		eleutl.doClick(Register);
		
		return new Registrationpage(driver);
	}
}
