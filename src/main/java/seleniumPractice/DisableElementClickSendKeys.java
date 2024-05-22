package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisableElementClickSendKeys {

	static boolean flag;
	static boolean checkBoxENabled;
	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://seleniumpractise.blogspot.com/2016/09");
		 flag=driver.findElement(By.id("pass")).isEnabled();
		System.out.println(flag);
	
		
		driver.findElement(By.name("first_name")).sendKeys(null);// Expection  java.lang.IllegalArgumentException
		
		driver.findElement(By.id("pass")).click();  // No Exception
		
		System.out.println("Click");
		driver.findElement(By.id("pass")).sendKeys("Dinesh");  //org.openqa.selenium.ElementNotInteractableException
	}

}
