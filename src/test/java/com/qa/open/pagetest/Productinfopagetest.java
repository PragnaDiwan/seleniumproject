package com.qa.open.pagetest;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Productinfopagetest extends Basetest{
	
	@BeforeClass
	public void producinfosetup()
	{
		accountpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	
	@Test
	
	public void productheadertest()
	{
		searchresultpage=accountpage.dosearch("macbook");
		productinfopage=searchresultpage.selectproduct("MacBook Air");
		
			}
	
	@Test
	
	public void productimagecountlist()
	{
		searchresultpage=accountpage.dosearch("imac");
		productinfopage=searchresultpage.selectproduct("iMac");
		
	productinfopage.getimagecount();
		
	
		//Assert.assertEquals(productinfopage.getimagecount(), 3);
		
	}
	
	@Test
	
	public void producinfotest()
	{
		searchresultpage=accountpage.dosearch("imac");
		productinfopage=searchresultpage.selectproduct("iMac");
		
		Map<String,String>actualproductinfomap=productinfopage.getproductinfo();
		actualproductinfomap.forEach((k,v) -> System.out.println(k + ":" +v));
		
		
		
		
		
		
	}
	@Test
	public void producinfopricetest()
	{
		searchresultpage=accountpage.dosearch("macbook");
		productinfopage=searchresultpage.selectproduct("MacBook Pro");
		
		productinfopage.productpricedata();
		
		
		
	}
}
