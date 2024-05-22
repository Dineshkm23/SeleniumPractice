package testngsessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseTest {
WebDriver driver;
	

	@Parameters({"url","browserName","headless"})
	@BeforeTest
	public void launchBrowser(String url, String browserName, String headless) {
		
		
		switch(browserName.toLowerCase().trim())
		{
		case "chrome":
			ChromeOptions cOption= new ChromeOptions();
			
			if(Boolean.parseBoolean(headless)) {
				cOption.addArguments("--headless");
			}
			
			driver= new ChromeDriver(cOption);
			break;
		
		case "firefox":
			
			FirefoxOptions fOption= new FirefoxOptions();
			if(Boolean.parseBoolean(headless)) {
				fOption.addArguments("--headless");
			}
			driver= new FirefoxDriver(fOption);
			break;
			
		case "edge":
			
			EdgeOptions eOption= new EdgeOptions();
			
			if(Boolean.parseBoolean(headless)) {
				eOption.addArguments("--headless");
			}
			driver= new EdgeDriver(eOption);
			break;
			
		default:
			System.out.println("please pass the right browser...."+browserName);
		
		}
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
