package TrainingDay1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLoginDemoWebShop {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeTest
	public void beforetest (String browser)
	{
		if(browser.equals("chrome"))
		{
			String driverpath = "C:\\Users\\training_b4c.06.01\\RTest\\chromedriver_win32\\chromedriver.exe";	
			System.setProperty("webdriver.chrome.driver", driverpath);
			WebDriver driver = new ChromeDriver();
		}
		else if (browser.equals("ie"))
		{
			String driverpath = "C:\\Users\\training_b4c.06.01\\RTest\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";	
			System.setProperty("webdriver.ie.driver", driverpath);
			WebDriver driver = new InternetExplorerDriver();
		}
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
	
	
	@Test(dataProvider="dp1")
	public void testDemoWebShopLogin(String username,String password)
	{				
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
	}
	
	@DataProvider(name="dp1")
	public Object[][] getData()
	{
		return TestReadExcel.testreadExcel();
	}
	@AfterTest
	public void afterclass()
	{
		driver.close();
	}

}
