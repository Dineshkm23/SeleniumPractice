package seleniumPractice;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserWindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options= new ChromeOptions();
		options.addArguments("start-maximized");
		
		WebDriver driver= new ChromeDriver(options);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[contains(@href,'twitter')]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		Iterator<String> it=windowHandles.iterator();
		
		it.next();
		
	}

}
