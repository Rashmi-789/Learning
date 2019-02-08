package TrainingDay1;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



@Test
public class citytest {
	public void Abc() throws InterruptedException
	{
	String driverpath = "C:\\Users\\training_b4c.06.01\\RTest\\chromedriver_win32\\chromedriver.exe";	
	System.setProperty("webdriver.chrome.driver", driverpath);
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.cleartrip.com/");
	
	WebElement from = driver.findElement(By.id("FromTag"));
	Actions act3 = new Actions(driver);
	Thread.sleep(5000);						//to handle pop-up 
	act3.sendKeys(from, "hyd").perform();
	Thread.sleep(5000);  					//to load the options from server
	act3.sendKeys(Keys.ENTER).perform();
	
	String city =driver.findElement(By.id("From")).getAttribute("value");
	Assert.assertEquals(city, "HYD");
	
	WebElement to = driver.findElement(By.id("ToTag"));
	to.sendKeys("ban");
	Thread.sleep(5000);					//static wait
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("ui-id-2")));
	WebElement ul = driver.findElement(By.id("ui-id-2"));
	List<WebElement> list = ul.findElements(By.tagName("li"));
	Assert.assertEquals(10, list.size());
	for (WebElement li:list)
	{
		if(li.getText().contains("BKK"))
		{
			li.click();
			break;
		}
	}	
	}

}
