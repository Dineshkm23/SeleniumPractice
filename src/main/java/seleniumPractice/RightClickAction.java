package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement button=driver.findElement(By.cssSelector(".context-menu-one.btn-neutral"));
		
		Actions action= new Actions(driver);
		
		
		action.contextClick(button).build().perform();
		driver.findElement(By.cssSelector("ul.context-menu-list li.context-menu-icon-edit")).click();
		Thread.sleep(3000);
		String AlertText=driver.switchTo().alert().getText();
		System.out.println("Alert text is:"+AlertText);
		driver.switchTo().alert().accept();
	
		driver.quit();
	}

}
