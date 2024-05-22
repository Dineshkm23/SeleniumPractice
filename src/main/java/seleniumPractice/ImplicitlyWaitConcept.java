package seleniumPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ImplicitlyWaitConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.get("https://uae.voxcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(4000);
//		driver.findElement(By.id("search-input")).click();
//		driver.findElement(By.id("search-input")).sendKeys("kannada");
		//Implicitly wait is global wait and it will apply for the webElement.(FE and FE's)
		WebElement ele=driver.findElement(By.xpath("//a[text()='WAYS TO WATCH ']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("MOONLIGHT")).click();
		
	}

}
