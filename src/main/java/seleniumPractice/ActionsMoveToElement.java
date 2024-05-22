package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsMoveToElement {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://www.noon.com/uae-en/");
		
		
		
		//WebElement ele=driver.findElement(By.xpath("//span[text()='Electronics']"));
		
		By parentEle= By.xpath("//span[text()='Electronics']");
		By subMenuEle= By.xpath("//a[text()='Laptops & Computers']");
		
		
		//handleMenuSubMenuLevel2(parentEle, subMenuEle);
		
		Thread.sleep(4000);
		By womenParent= By.xpath("//div[@class='swiper-wrapper']//div/li/a[contains(@href,'fashion-women/')]");
		By womenSubMenu= By.xpath("//a[text()='Spring/Summer']");
		
		//handleMenuSubMenuLevel2(womenParent, womenSubMenu);
		
		
		driver.get("https://www.noon.com/uae-en/");
		By level1= By.linkText("ALL CATEGORIES");
		By level2= By.linkText("Beauty & Fragrances");
		By level3 = By.linkText("Styling & Grooming");
		Thread.sleep(4000);
		handleMenuSubMenuLevel4(level1, level2, level3);
	}
	
	
	public static void handleMenuSubMenuLevel2(By parentMenu, By subMenu) throws InterruptedException
	{
		WebElement parentEle=driver.findElement(parentMenu);
		Actions act= new Actions(driver);
		act.moveToElement(parentEle).perform();
		
		Thread.sleep(3000);
		
		driver.findElement(subMenu).click();
		
		
	}
	
	public static void handleMenuSubMenuLevel4(By level1Menu, By Level2Menu, By level3Menu) throws InterruptedException {
		
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(level1Menu)).perform();
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(Level2Menu)).perform();
		Thread.sleep(3000);
		act.moveToElement(driver.findElement(level3Menu)).click().build().perform();
		
	}

}
