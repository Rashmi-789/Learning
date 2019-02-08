package TrainingDay1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Seltest1 {

	@Test
	public void Abc()
	{
	String driverpath = "C:\\Users\\training_b4c.06.01\\RTest\\chromedriver_win32\\chromedriver.exe";	
	System.setProperty("webdriver.chrome.driver", driverpath);
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://hdfcbank.com"); 
	
	
	//driver.findElement(By.xpath("//*[@id='div-close']")).click();
	
	Actions act1 = new Actions(driver);
	act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products\']")));
	act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
	act1.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
	act1.click(driver.findElement(By.xpath("//a[@href='/personal/products/cards/credit_cards']")));
	act1.perform();
	
	String Curl= driver.getCurrentUrl();
	Assert.assertTrue(Curl.contains("credit_cards"));
	}
}
