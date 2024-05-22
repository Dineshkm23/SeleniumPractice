package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcepts {

	static WebDriver driver=null;
	public static void main(String[] args) {

		 driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		
		// Create webelement + perform action on it (click , send keys, gettext, isDisplayed)
		
		//1
//		driver.findElement(By.id("input-email")).sendKeys("testemail@gima");
//		driver.findElement(By.id("input-password")).sendKeys("passwor");
//		
		//2
		
//		WebElement userName=driver.findElement(By.id("input-email"));
//		userName.sendKeys("test@gmail.com");
//		WebElement pwd=driver.findElement(By.id("input-password"));
//		pwd.sendKeys("pwsss");
		
		//3
		
//		By userName=By.id("input-email");
//		By pwd=By.id("input-password");
//		
//		driver.findElement(userName).sendKeys("emailid");
//		driver.findElement(pwd).sendKeys("pass");
		
		//4
//		
//		By userName=By.id("input-email");
//		By psw=By.id("input-password");
//		getElement(userName).sendKeys("email");
//		getElement(psw).sendKeys("passwrod");
		
		//5		
//		By userName=By.id("input-email");
//		By psw=By.id("input-password");
//
//		ElementUtil eleUtil= new ElementUtil(driver);
//	    eleUtil.doSendKeys(userName,"testemailUtil");
//		eleUtil.doSendKeys(psw, "pwasss");
//		
		
		
		//8
		String userName="input-email";
		String psw="input-password";
		ElementUtil eleUtil= new ElementUtil(driver);
		
		eleUtil.doSendKeys("id", userName, "dinesh@gmail");
		eleUtil.doSendKeys("id", psw, "12344");
		
		
	}
//	
//	public static WebElement getElement(By locator)
//	{
//		return driver.findElement(locator);
//	}
	
//	public static void doSendKeys(By locator, String value)
//	{
//		getElement(locator).sendKeys(value);
//	}

}
