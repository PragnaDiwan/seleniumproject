import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class child  {
	
	
	private WebDriver driver;
	
	
	public child(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	private By search=By.id("twotabsearchtextbox");
	private By suggestion=By.xpath("//div[@class='s-suggestion-container']/div[@class='s-suggestion']");
	private By chocolatetype=By.xpath("//ul[@class='a-unordered-list a-nostyle a-vertical a-spacing-medium']/li[@id='p_n_feature_two_browse-bin/7494060011']");

	
	public void searchbutton()
	{
		driver.findElement(search).sendKeys("chocklate");
	}
	
	public void getsuggetion()
	
	
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		List<WebElement>suggetlist=wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(suggestion));
		
		for(WebElement e:suggetlist)
		{
			String text=e.getAttribute("aria-label");
			System.out.println(text);
		if(text.contains("bag"))
		{	
			e.click();
		break;
		}}
		
	}
	
	public void scrolltopageheight()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 300)");
	}
	
	public void scrollintoview()
	{
		WebElement chocotype=driver.findElement(chocolatetype);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", chocotype);
		
		driver.findElement(By.xpath("//li[@id='p_n_feature_two_browse-bin/7494060011']//a")).click();
		
	}
	public void fullpagescroll()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
}
