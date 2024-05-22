package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsClickSendKeys {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions option=new ChromeOptions();
		option.addArguments("incognito");
		option.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		By email= By.id("input-email");
		By password=By.id("input-password");
		By loginBtn=By.xpath("//input[@type='submit']");
		
		Actions act= new Actions(driver);
		act.sendKeys(driver.findElement(email),"dineshj@gmail").perform();
		act.sendKeys(driver.findElement(password),"diiiii").perform();
		
		act.sendKeys(driver.findElement(loginBtn)).click().perform();
		driver.navigate().refresh();
		act.click(driver.findElement(loginBtn)).perform();
		
	}

}
