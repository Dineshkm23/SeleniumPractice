package seleniumPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtils1 {

	WebDriver driver;

	public WebDriver launchBrowser(String browserName) {
		System.out.println("Browser name is :" + browserName);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			System.out.println("Launching chrome browser...");
			driver = new ChromeDriver();
			System.out.println("Chrome browser launched..");
			break;
		case "firefox":
			System.out.println("Launching firefox browser...");
			driver = new FirefoxDriver();
			System.out.println("Firefox borwser launched...");
			break;

		case "edge":
			System.out.println("Launching Edge browser.....");
			driver = new EdgeDriver();
			System.out.println("Launched edge browser..");
			break;

		default:
			throw new MyBrowserException("Browser name is invalid");

		}
		return driver;
	}

	public void launchUrl(String url) {
		if (url == null) {
			throw new MyBrowserException("URL is NULL");
		} 
		else if (url.indexOf("http") == 0) {
			 driver.navigate().to(url);
			//driver.navigate().to(new URL(url));
			//driver.get(url);
		} 
		else {
			throw new MyBrowserException("HTTP is missing");
		}

	}

	public String getTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void closeBrowser() {
		driver.close();

	}
	
	public void doBackword()
	{
		driver.navigate().back();
	}
	public void doForward()
	{
		driver.navigate().forward();
	}
}
