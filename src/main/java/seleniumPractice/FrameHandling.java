package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions option= new ChromeOptions();
		option.addArguments("start-maximized");
		
		WebDriver driver= new ChromeDriver(option);
		
		
		driver.get("https://classic.freecrm.com/");
		
		driver.findElement(By.name("username"	)).sendKeys("apiautomation");
		driver.findElement(By.name("password")).sendKeys("Selenium@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		Thread.sleep(4000);
		
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.linkText("CONTACTS")).click();
		Thread.sleep(4000);
		
		WebElement company=driver.findElement(By.xpath("//a[text()='David Rodriguez']/parent::td/following-sibling::td/a[@context='company']"));
		String text = company.getText();
		
		System.out.println("Comany name:"+text);
		
		company.click();
		
	}

}
