package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.constants.ElementUtil;

public class Registrationpage {
	
	private WebDriver driver;
	private ElementUtil eleutl;

	public Registrationpage(WebDriver driver) {
	
		this.driver=driver;
		eleutl=new ElementUtil(driver);
	}

	
	private By firstname=By.name("firstname");
	private By lastname=By.name("lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.name("password");
	private By confirmpwd=By.id("input-confirm");
	private By selectno=By.xpath("(//input[@type=\"radio\" and @value=\"1\"])[2]");
	private By selectyes=By.xpath("//label[@class='radio-inline' ]/input[@type='radio' and @name='newsletter' and @value='1']");
	private By agree=By.xpath("//input[@type=\"checkbox\" and @name=\"agree\"]");
	private By continuedo=By.xpath("//input[@type=\"submit\" and @value=\"Continue\"]");
	private By sucessmsg=By.xpath("//div[@id='content']/h1");
	
	private By linklogout=By.linkText("Logout");
	private By registerlink=By.linkText("Register");
	
	
	public boolean accountregistration(String fname,String lname,String emai,String tele,String pass,String Subscribe) 
	{
		eleutl.doSendKeys(firstname, fname);
		eleutl.doSendKeys(lastname, lname);
		eleutl.doSendKeys(email, emai);
		eleutl.doSendKeys(telephone, tele);
		eleutl.doSendKeys(password, pass);		
		eleutl.doSendKeys(confirmpwd, pass);
		
		if(Subscribe.equals("yes"))
		{
			eleutl.doClick(selectyes);
		}
		else
		{
			eleutl.doClick(selectno);
		}
	
		eleutl.doClick(agree);
		eleutl.doClick(continuedo);
		String mesg=eleutl.waitForElementToBeVisible(sucessmsg, 5, 1000).getText();
		if(mesg.contains(Constants.REGISTER))
		{
			eleutl.doClick(linklogout);
			eleutl.doClick(registerlink);
			return true;
		}
		return false;
	}
}
