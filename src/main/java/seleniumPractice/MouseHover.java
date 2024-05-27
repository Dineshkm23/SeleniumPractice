package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

public class MouseHover {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		WebElement desktop = driver.findElement(By.partialLinkText("Desktops"));
		WebElement mac = driver.findElement(By.partialLinkText("Mac"));
		//WebElement mac = driver.findElement(By.xpath("//a[normalize-space()='Show All Desktops']"));
		Actions act = new Actions(driver);
		
		//act.moveToElement(desktop).moveToElement(mac).click().build().perform();
		 act.moveToElement(desktop).perform();
		 Thread.sleep(2000);
		 act.moveToElement(mac).click().build().perform();
		//macMouseHover.perform();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
