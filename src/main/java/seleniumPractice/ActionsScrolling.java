package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsScrolling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions option=new ChromeOptions();
		option.addArguments("incognito");
		option.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.amazon.in");
		
		Actions action= new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).perform();
		//Thread.sleep(3000);
		action.sendKeys(Keys.PAGE_UP).perform();
		//Thread.sleep(3000);
		action.sendKeys(Keys.CONTROL.END).perform();
		
		Thread.sleep(3000);
		action.sendKeys(Keys.CONTROL.HOME).perform();
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.linkText("Conditions of Use & Sale"));
		action.scrollToElement(ele).perform();
		Thread.sleep(3000);
		ele.click();
	}

}
