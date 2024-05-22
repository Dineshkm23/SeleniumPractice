package testngsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class priorityConcepts {
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		driver= new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test(invocationCount = 10, priority=-1)
	public void TC101_getTitle() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test
	public void TC102_getCurrentUrl() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("google"));
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
