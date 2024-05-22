package seleniumPractice;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LaunchFireFox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RemoteWebDriver driver= new FirefoxDriver();	
		driver.get("https://www.google.com");
		String title=driver.getTitle();
		System.out.println(title);
		
		driver.quit();
	}

}
