package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsTabSequence {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions option=new ChromeOptions();
		option.addArguments("incognito");
		option.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement search= driver.findElement(By.name("firstname"));
		
		Actions action= new Actions(driver);
		
		action.sendKeys(search,"dinesh").sendKeys(Keys.TAB,"Kumar").pause(2000)
			.sendKeys(Keys.TAB,"M").pause(2000)
				.sendKeys(Keys.TAB,"Maha").pause(2000)
					.sendKeys(Keys.TAB,"Vimalakshi").build().perform();
	}

}
