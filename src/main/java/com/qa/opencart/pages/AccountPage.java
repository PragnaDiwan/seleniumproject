package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.Constants;
import com.qa.opencart.constants.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleutl;
	
	private By header=By.xpath("//a[text()='Your Store']");
	private By accountsections=By.xpath("//div[@id='content']/h2");
	private By searchfield=By.name("search");
	private By searchbutton=By.xpath("//button[@class='btn btn-default btn-lg']");
	private By logoutlink=By.linkText("Logout");
	
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		eleutl=new ElementUtil(driver);
	}
	
	
	public String getaccountapagettile()
	{
		return eleutl.doGetTitle(Constants.ACCOUNT_PAGE_TITLE, Constants.DEFAULT_TIMEOUT);
	}
	public String getaccountspageheader()
	{
		return eleutl.doGetText(header);
	}
	
	public boolean logoutlinkexistornot()
	{
		return eleutl.doIsDisplayed(logoutlink);
	}
	public void logout()
	{
		if(logoutlinkexistornot())
		{
			eleutl.doClick(logoutlink);
		}
	}
	
	public List<String> getaccountsectionlist()
	{
		List<WebElement>accseclist=eleutl.waitForElementsToBeVisible(accountsections, 10);
		List<String>accsecvallist=new ArrayList<String>();
		for(WebElement e:accseclist)
		{
			String text=e.getText();
			System.out.println(text);
			accsecvallist.add(text);
			
		}
		return accsecvallist;
	}
	
	public boolean searchfieldexist()
	{
		return eleutl.doIsDisplayed(searchfield);
	}
	
	public Searchresultpage dosearch(String productname)
	{
		System.out.println("productname is "+productname);
		eleutl.doSendKeys(searchfield, productname);
		eleutl.doClick(searchbutton);
		
		return new Searchresultpage(driver);
	}
	
	
}
