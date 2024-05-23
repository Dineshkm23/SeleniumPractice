package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownConcept1 {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions option= new ChromeOptions();
		option.addArguments("incognito");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.orangehrm.com/30-day-free-trial");
		By userName= By.id("Form_getForm_subdomain");
		By fullName= By.id("Form_getForm_Name");
		By emailId= By.id("Form_getForm_Email");
		By country=By.id("Form_getForm_Country");
		
		getElement(userName).sendKeys("Dineshlllll");
		getElement(fullName).sendKeys("kuuummmmmaaa");
		doSendKeys(emailId,"dinesh.tdhkmm@gmail.com");
		
		
		doSelectByIndex(country,4);
		System.out.println("4");
		Thread.sleep(4000);
		doSelectByValue(country,"Aruba");
		System.out.println("Aruba");
		
		
	}

	public static WebElement getElement(By ele) {
		return driver.findElement(ele);
	}
	public static void doSendKeys(By ele, String text) {
		getElement(ele).sendKeys(text);
	}

	public static void doSelectByIndex(By ele, int index) {
		Select select= new Select(driver.findElement(ele));
		select.selectByIndex(index);
	}
	
	public static void doSelectByVisibleText(By ele,String text) {
		Select select= new Select(getElement(ele));
		select.selectByVisibleText(text);
		select.selectByValue(text);
	}
	
	public static void doSelectByValue(By ele,String value) {
		Select select=new Select(getElement(ele));
		select.selectByValue(value);
	}
}
