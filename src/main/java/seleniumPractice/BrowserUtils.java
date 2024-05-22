package seleniumPractice;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 */
public class BrowserUtils {

	WebDriver driver;

	/**
	 * Launching browsers
	 * 
	 * @param browserName
	 * @return driver
	 */
	public WebDriver launchBrowser(String browserName) {
		System.out.println("Browser name: " + browserName);
		ChromeOptions options= new ChromeOptions();
		options.addArguments("start-maximized");
		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			System.out.println("Launching chrome browser");
			driver = new ChromeDriver(options);
			System.out.println("Launched chrome browser");
			break;
		case "firefox":
			System.out.println("Launching FireFox browser");
			driver = new FirefoxDriver();
			System.out.println("Launched Firefox browser");
			break;
		case "edge":
			System.out.println("Launching Edge browser");
			driver = new EdgeDriver();
			System.out.println("Launched Edge browser");
			break;
		case "safari":
			System.out.println("Launching Safari browser");
			driver = new SafariDriver();
			System.out.println("Launched safari browser");
			break;
		default:
			System.out.println("Browser name is:" + browserName);
			throw new MyBrowserException("PASS THE RIGHT BROWSER NAME");
		}
		return driver;

	}

	/**
	 * Launch browser url
	 * 
	 * @param url
	 */
	public void launchUrl(String url) {
		if (url == null) {
			throw new MyBrowserException("URL is Null");
		}
		if (url.indexOf("http") == 0) {
			driver.get(url);
		} else {
			throw new MyBrowserException("HTTP is Missing in URL");
		}
	}

	public void launchUrl(URL url) {
		System.out.println("Inside launchUrl URL url overloaded Method...");
		if (url == null) {
			throw new MyBrowserException("URL is Null");
		}
		String appUrl=String.valueOf(url);
		if (appUrl.indexOf("http") == 0) {
			driver.navigate().to(url);
		} else {
			throw new MyBrowserException("HTTP is Missing in URL");
		}
	}
	/**
	 * get Title
	 * 
	 * @return
	 */
	public String getTitle() {
		String title = driver.getTitle();
		return title;

	}

	public String getUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public void closeBrowser() {
		driver.close();
	}

	public void quitBrowser() {
		driver.quit();
	}
}
