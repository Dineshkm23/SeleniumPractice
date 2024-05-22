package seleniumPractice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDeiverConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RemoteWebDriver driver = new ChromeDriver();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		String title=driver.getTitle();
		System.out.println(title);
		
		if (title.contains("Google")) {
			System.out.println("PASSED");
			
		} else {
			System.out.println("failed");
		}
	
		driver.quit();
		
		driver.getTitle();
	}

}
