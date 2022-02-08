import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test {

WebDriver driver;

@Test

public void setup() throws InterruptedException

{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	
   driver.get("https://www.amazon.com/");
   driver.manage().window().maximize();

   child c1=new child(driver);
   c1.searchbutton();
   Thread.sleep(2000);
   //c1.getsuggetion();
   //c1.scrolltopageheight();
// c1.scrollintoview();
 c1.fullpagescroll();

}

	
}
