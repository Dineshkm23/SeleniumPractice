package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MoveToElementConcepts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions option= new ChromeOptions();
		option.addArguments("incognito");
		WebDriver driver=new ChromeDriver(option);
		
		driver.manage().window().maximize();
//		Thread.sleep(2000);
//		driver.manage().window().minimize();
//		Thread.sleep(2000);
//		driver.manage().window().maximize();
//		Thread.sleep(2000);
		driver.get("https://www.hongkiat.com/blog/websites-creative-mouse-over-effects/");
		WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'All')]"));
		Actions act= new Actions(driver);
		act.moveToElement(ele).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'About Us')]")).click();
		Thread.sleep(2000);
		act.contextClick(driver.findElement(By.linkText("Submit news, tips or stories")));
		
	}

}
