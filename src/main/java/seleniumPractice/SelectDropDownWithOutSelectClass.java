package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectDropDownWithOutSelectClass {
	static boolean flag;
	static boolean checkBoxENabled;
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://orangehrm.com/en/book-a-free-demo/");
		By country = By.xpath("//select[@id='Form_getForm_Country']/option");
		
//		List<WebElement> element=driver.findElements(country);
//		
//		for (WebElement webElement : element) {
//			if(webElement.getText().equals("India")){
//				System.out.println(webElement.getText());
//				webElement.click();
//			}
//		}
		
		doSelectValueFromDropDown(country, "India");
		doSelectValueFromDropDown(country, "Australia");	
	
	}
	
	
	public static void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> element=driver.findElements(locator);
		
		for(WebElement ele: element){
			String text=ele.getText();
			if(text.equals(value)) {
				ele.click();
				break;
			}
		}
		
	}

}
