package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.ElementUtil;

public class Productinfopage {

	
	private WebDriver driver;
	private ElementUtil eleutl;
	public Productinfopage(WebDriver driver) {
		this.driver=driver;
		eleutl=new ElementUtil(driver) ;
	}

	
	private By productheadername=By.xpath("//div[@id='content']//h1");
	private By metadata=By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[1]/li");
	private By imagecount=By.xpath("//div[@id='content']//ul[@class='thumbnails']/li");
	private By metapricedata=By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[2]/li");
	private Map<String,String>productinfomap;
	
	public String header()
	{
		WebElement headerr=eleutl.waitForElementToBeVisibleWithWebElement(productheadername, 10, 2000);
		
		String header=headerr.getText();
		System.out.println("header is :"+header);
		return header;
	}
	
	public int getimagecount()
	
	{
		return eleutl.getElementsCount(imagecount);
	}
	
	public Map<String, String> getproductinfo()
	{
		productinfomap=new HashMap<String,String>();
		
		productinfomap.put("header", header());
	getproductmetadata();
	//productpricedata();
		return productinfomap;
	}
	
	public Map<String, String> getproductmetadata()
	
	{
		List<WebElement>metadatalist=eleutl.getElements(metadata);
		for(WebElement e:metadatalist)
		{
			String text=e.getText();
			String meta[]= text.split(":");
			 String key= meta[0].trim();
			 String value=meta[1].trim();
			 productinfomap.put(key, value);
		
		}
		return productinfomap;
	}
	
	
	
	public void productpricedata()
	{
		List<WebElement>metadatapricelist=eleutl.getElements(metapricedata);
		
		for(WebElement e:metadatapricelist)
		{
			String text=e.getText();
			System.out.println(text);
			
		}
		

	}
	
}
