package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickAction {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("file:///C:/Users/Administrator/Desktop/doubleclick.html");
		driver.get("file:///C:/Users/Administrator/eclipse-workspace/doubleclick.html");
		
		WebElement button=driver.findElement(By.xpath("//p[contains(text(),'double-clicked')]/preceding-sibling::button"));
		
		Actions action= new Actions(driver);
		
		action.doubleClick(button).build().perform();
//		action.contextClick(button).build().perform();
//		driver.findElement(By.cssSelector("ul.context-menu-list li.context-menu-icon-edit")).click();
//		Thread.sleep(3000);
//		String AlertText=driver.switchTo().alert().getText();
		//System.out.println("Alert text is:"+AlertText);
		Thread.sleep(3000);
		String text=driver.findElement(By.id("demo")).getText();
		if(text.contains("Hello World")) {
			System.out.println("Text is present");
		}
		//driver.switchTo().alert().accept();
	
		//driver.quit();
	}

}
