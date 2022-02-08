package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.ElementUtil;

public class Searchresultpage {
	
	private WebDriver driver;
	private ElementUtil eleutl;

	public Searchresultpage(WebDriver driver) {
	
		this.driver=driver;
		eleutl=new ElementUtil(driver);
	}

	private By productresult=By.xpath("//div[@class='caption']//a");
	
	public int getproductcountlist()
	{
		int productcount=eleutl.waitForElementsToBeVisible(productresult, 10, 2000).size();
	System.out.println("the resultcount is :"+productcount);
		
		return productcount;
		

	
	}
	
	public Productinfopage selectproduct(String mainproductname)
	{
		System.out.println("mainproductame is :"+mainproductname);
		List<WebElement>searchlist=eleutl.waitForElementsToBeVisible(productresult, 10,2000);
		for(WebElement e:searchlist)
		{
			String text=e.getText();
			System.out.println(text);
			
			if(e.getText().equals("mainproductname"))
			{
				e.click();
				break;
			}
		}
	return new Productinfopage(driver);
	}
}
