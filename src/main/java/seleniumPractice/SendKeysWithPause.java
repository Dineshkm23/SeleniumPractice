package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SendKeysWithPause {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions option=new ChromeOptions();
		option.addArguments("incognito");
		option.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement search= driver.findElement(By.name("search"));
		
		Actions action= new Actions(driver);
		
		String value= "Dinesh";
		char val[]=value.toCharArray();
		
		for(int i=0; i<val.length;i++) {
			System.out.println(val[i]);
			//action.sendKeys(search, String.valueOf(val[i])).perform();
			action.sendKeys(search, String.valueOf(val[i])).pause(1000).perform();
		}
		
	}

}
