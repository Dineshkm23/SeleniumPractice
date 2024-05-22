package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PsuedoElementConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//Thread.sleep(4000);
		
		driver.findElement(By.xpath("//div[@id='search-input']/input")).sendKeys("Dinesh");
//		driver.findElement(By.id("search-icon-legacy")).click();
//		String script="document.querySelector(\"div[id='search-input'] > input\")";
//		
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript(script);
	//	WebElement ele=driver.findElement(By.cssSelector("div[id='search-input'] > input"));
	//	ele.sendKeys("rakibhai");
		
//		ele.sendKeys(Keys.TAB);
//		Thread.sleep(2000);
//		ele.sendKeys(Keys.ENTER);
		
		
		Actions action= new Actions(driver);
		
		action.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
		
	}

}
