package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LocatorStratergy {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		//option.addEncodedExtensions("https://chromewebstore.google.com/detail/screen-recorder-for-googl/eclbecdgdoahkliaijlpkigldlkojjdn");
		
		driver = new ChromeDriver(option);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		// 2 Name : can be duplicate

//		driver.findElement(By.name("firstname")).sendKeys("dinesh.km@gmailcom");
//		driver.findElement(By.name("lastname")).sendKeys("12344");

//		By firstName=By.name("firstname");
//		By lastName= By.name("lastname");
////		
//		ElementUtil eleUtil = new ElementUtil(driver);
//
////		eleUtil.doSendKeys(firstName, "Dinesh");
////		eleUtil.doSendKeys(lastName,"lastname");
////	
//		String firstName = "firstname";
//		String lastName = "lastname";
//		By email = By.name("email");
//
//		eleUtil.doSendKeys("name", firstName, "firstname");
//		eleUtil.doSendKeys("name", lastName, "lastName");
//		eleUtil.doSendKeys(email, "email@lastName");

		// 3 class

//		driver.findElement(By.className("form-control")).sendKeys("Testing");

//		String formControl= "form-control";
//		
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys("className", formControl, "anamammam");
////		
//		// 4 Xpath
//		
//		 driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("testinggng");

//		By xpathFisrtname=By.xpath("//*[@id=\"input-firstname\"]");
//	
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(xpathFisrtname, "dinehshsh");
//		
//		//String based
//		String xpathString="//*[@id=\"input-lastname\"]";
//		eleUtil.doSendKeys("xpath", xpathString, "DDJDJDJJJDD");
//		
//		//5 CSS
//		 
//		 driver.findElement(By.cssSelector("#input-firstname")).sendKeys("user name");
//		 driver.findElement(By.cssSelector("#input-lastname")).sendKeys("lastname");
//		
//		By cssFirstName=By.cssSelector("#input-firstname");
//		By cssLastName=By.cssSelector("#input-lastname");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doSendKeys(cssFirstName, "dinehshsh");
//		eleUtil.doSendKeys(cssLastName, "dinehshsh");
//		
//		String SFName="#input-firstname";
//		String SLName="#input-lastname";
//		
//		eleUtil.doSendKeys("css", SFName, "Firstnamememmem");
//		eleUtil.doSendKeys("css", SLName, "ssssss");

//		 //6 linkText
		//Thread.sleep(3000);
		// driver.findElement(By.linkText("Login")).click();

//		By loginLink = By.linkText("Login");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		eleUtil.doClick(loginLink);

		// doClick(loginLink);

		//7
		
		//driver.findElement(By.partialLinkText("Forgotten Pa")).click();
//		By paLText=By.partialLinkText("Forgotten Passw");
//		ElementUtil eleUtil = new ElementUtil(driver);
//		
//		
//		String sPaLText= "Forgotten Passw";
//		eleUtil.doClick("partialLinkText", sPaLText);

		
		//8 Tag name
		
//		String text=driver.findElement(By.tagName("h1")).getText();
//		System.out.println(text);
//		
//		By text= By.tagName("h1");
//		String text1=doGetText(text);
//		System.out.println(text1);
		ElementUtil eleUtil = new ElementUtil(driver);
		//String text2=eleUtil.doGetElementText(text);
		//System.out.println(text2);
		
//		String tg="h1";
//		String text2=eleUtil.doGetElementText("tagname", tg);
//		System.out.println(text2);
		
		
		// get attribute value's
		
		By email= By.id("input-email");
		
		driver.findElement(By.id("input-email")).sendKeys("Dineshhshshs");
		String attributeValue=doGetAttributeValue(email, "value");
		System.out.println(attributeValue);
	}

	public static String doGetText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	public static String doGetAttributeValue(By locator, String attributeName)
	{
		return driver.findElement(locator).getAttribute(attributeName);
	}

}
