package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ElementDisplayed {
static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions option= new ChromeOptions();
		option.addArguments("--headless");
		 driver=new ChromeDriver(option);
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
//		boolean flag=driver.findElement(By.id("input-firstname")).isDisplayed();
//		System.out.println(flag);
//		
//		if(flag) {
//			System.out.println("Element is present");
//		}else {
//			System.out.println("Not present");
//		}
		
//		By firstName= By.id("input-firstname");
//		
//		ElementUtil eleUtil= new ElementUtil(driver);
//		boolean flag1=eleUtil.isElementDisplayed(firstName);
//		System.out.println(flag1);
//		
//		
//			List<WebElement> logo=driver.findElements(By.id("inpu0t-firstname"));
//			
//			if(logo.size()>0) {
//				System.out.println("Logo is present ");
//			}else
//			{
//				System.out.println("Logo is not present");
//			}
		
		By firstName= By.className("form-ontrol");
		ElementUtil eleUtil= new ElementUtil(driver);
		boolean flag1=eleUtil.multipleElementsExist(firstName);
		System.out.println(flag1);
		
		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static boolean isElementExist(By locator)
	{
		if(getElements(locator).size()==1) {
			return true;
		}
		return false;
	}
	
	public static boolean isElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
}
