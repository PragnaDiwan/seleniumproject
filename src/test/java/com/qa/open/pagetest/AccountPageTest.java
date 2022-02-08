package com.qa.open.pagetest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constants.Constants;

public class AccountPageTest extends Basetest {
	
	@BeforeClass
	public void accountpagesetup()
	{
		accountpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void accountpagettiletest()
	{
		String acttitle=accountpage.getaccountapagettile();
		System.out.println(acttitle);
		Assert.assertEquals(acttitle, Constants.ACCOUNT_PAGE_TITLE);
	}

	
	@Test
	
	public void accountpageheadertest()
	
	{
		String header=accountpage.getaccountspageheader();
		System.out.println("account page header is"+header);
		Assert.assertEquals(header,Constants.ACCOUNT_PAGE_HEADER);
	}
	
	@Test
	public void islogoutexistornot()
	{
		Assert.assertTrue(accountpage.logoutlinkexistornot());
	}
	
	@Test
	public void accpagesectiontest()
	{
		List<String>actacctsclist=accountpage.getaccountsectionlist();
		Assert.assertEquals(actacctsclist, Constants.getexpectedaccseclist());
	}
	
	@DataProvider
	public Object[][] productdata()
	{
		return new Object[][]
				{
			{"macbook"},
			{"apple"},
			{"samsung"}
			
				};
	}
	
	@Test(dataProvider="productdata")
	public void searchproducttest(String productname)
	{
		searchresultpage=accountpage.dosearch(productname);
		
		Assert.assertTrue(searchresultpage.getproductcountlist()>0);
		
			
		
	}
	
	@Test
	public void selectproducttest()
	{
		searchresultpage=accountpage.dosearch("macbook");
		productinfopage=searchresultpage.selectproduct("MacBook Air");
		productinfopage.header();
		
		Assert.assertEquals(productinfopage.header(),"MacBook Air");
		
	}
	
	@Test
	public void getproductcountlist()
	{
		searchresultpage=accountpage.dosearch("macbook");
		productinfopage=searchresultpage.selectproduct("MacBook Air");
		searchresultpage.getproductcountlist();
	}
	
	@Test
	public void getimagecountlisttest()
	{
		searchresultpage=accountpage.dosearch("macbook");
		productinfopage=searchresultpage.selectproduct("MacBook Air");
		productinfopage.getimagecount();
	
	}
	
	
	
	
	
}
