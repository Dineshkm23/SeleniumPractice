package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownConcept {

	static boolean flag;
	static boolean checkBoxENabled;
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://orangehrm.com/en/book-a-free-demo/");
//		 WebElement country=driver.findElement(By.id("Form_getForm_Country"));
//		
//		 Select select= new Select(country);
//		 
//		 select.selectByIndex(3);
//		 select.selectByVisibleText("Anguilla");		 
//		 select.selectByVisibleText("India");
//		 
//		 select.selectByValue("Argentina");

		By country = By.id("Form_getForm_Country");

//		doSelectByIndex(country, 4);
//
//		doSelectByVisibleText(country, "India");
//		doSelectByValue(country, null);
		
		ElementUtil eleUtil= new ElementUtil(driver);
		eleUtil.doSelectByVisibleText(country, null);
	}

	public static WebElement getElement(By locator) {
		WebElement element = null;
		System.out.println(locator);
		try {
			element = driver.findElement(locator);

		} catch (Exception e) {
			System.out.println("Element is not present on the WEB Page:" + locator);
			e.printStackTrace();
			return null;
		}
		return element;
	}

	public static void doSelectByIndex(By locator, int indexValue) {
		// WebElement element = getElement(locator);

		Select select = new Select(getElement(locator));
		select.selectByIndex(indexValue);
	}

	public static void doSelectByVisibleText(By locator, String text) {
		nullBlankCheck(text);
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}
	
	public static void doSelectByValue(By locator, String textValue) {
		nullBlankCheck(textValue);
		Select select= new Select(getElement(locator));
		select.selectByValue(textValue);
	}
	
	public static void nullBlankCheck(String textValue)
	{
		if(textValue==null || textValue.length()==0)
		{
			throw new MyElementException("textValue can not be null");
		}
	}

}
