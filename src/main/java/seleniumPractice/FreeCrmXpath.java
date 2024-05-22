package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FreeCrmXpath {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		//option.addArguments("incognito");
		//option.addEncodedExtensions("https://chromewebstore.google.com/detail/screen-recorder-for-googl/eclbecdgdoahkliaijlpkigldlkojjdn");
		
		driver = new ChromeDriver(option);
		driver.get("https://classic.freecrm.com/");
		
		By userName=By.name("username");
		By psw=By.name("password");
		By loginBtn= By.xpath("//input[@type='submit']");
		
		
		
		driver.findElement(userName).sendKeys("apiautomation");
		driver.findElement(psw).sendKeys("Selenium@12345");
		driver.findElement(loginBtn).click();
		Thread.sleep(8000);
		
		driver.switchTo().frame("mainpanel");
		By contact= By.xpath("//a[contains(text(),'Contacts')]");
		
		
		driver.findElement(contact).click();
		
		driver.findElement(By.linkText("CONTACTS")).click();
		
//		By checkbx1= By.xpath("//a[contains(text(),'Aman Srivastava')]/parent::td/preceding-sibling::td/input[@type='checkbox']");
//		driver.findElement(checkbx1).click();
//		System.out.println("Check is selected True or False :"+ driver.findElement(checkbx1).isSelected());
//		
//		By company=By.xpath("//a[contains(text(),'Aman Srivastava')]/parent::td/following-sibling::td/a[@context='company']");
//		System.out.println("Company name:"+driver.findElement(company).getText());
//		
//		By mob=By.xpath("(//a[contains(text(),'Aman Srivastava')]/parent::td/following-sibling::td/span[@context='phone'])[last()]");
//		System.out.println("Mobile number: "+driver.findElement(mob).getText());
		
		
		String contactName="Josh Buttler";
		System.out.println("clicked on Check Box, True or False:"+doClickCheckBox(contactName));
		System.out.println("Company name:"+getCompanyName(contactName));
		System.out.println("Home Phone:"+getHomePhone(contactName));
		System.out.println("Mobile Number:"+getMobile(contactName));
		System.out.println("Email Id:"+getEmailId(contactName));
		System.out.println("Phone :"+getPhone(contactName));
		
	}
	
	public static boolean doClickCheckBox(String contactName) {
		By checkbx= By.xpath("//a[contains(text(),'"+contactName+"')]/parent::td/preceding-sibling::td/input[@type='checkbox']");
		driver.findElement(checkbx).click();
		return driver.findElement(checkbx).isSelected();
	}
	
	public static String getPhone(String contactName) {
		By phone= By.xpath("(//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td/span[@context='phone'])[position()=1]");
		return driver.findElement(phone).getText();
	}
	
	public static String getCompanyName(String contactName) {
		By company=By.xpath("//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td/a[@context='company']");
		return driver.findElement(company).getText();
	}
	public static String getEmailId(String contactName) {
		By email=By.xpath("//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td/a[contains(@href,'mailto')]");
		return driver.findElement(email).getText();
	}

	public static String getHomePhone(String contactName) {
		By homePhone=By.xpath("(//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td/span[@context='phone'])[last()-1]");
		return driver.findElement(homePhone).getText();
	}

	public static String getMobile(String contactName) {
		By mob=By.xpath("(//a[contains(text(),'"+contactName+"')]/parent::td/following-sibling::td/span[@context='phone'])[last()]");
		return driver.findElement(mob).getText();
	}

}
