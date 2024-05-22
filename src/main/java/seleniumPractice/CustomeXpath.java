package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomeXpath {

		static boolean flag;
		static boolean checkBoxENabled;
		static WebDriver driver;

		public static void main(String[] args) {

			driver = new ChromeDriver();

			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
			By country = By.xpath("//div[@class='list-group']/a");
			
			ElementUtil ele= new ElementUtil(driver);
			List<WebElement> list=ele.getElements(country);
			
			System.out.println("Count:"+ list.size());
			
			for (WebElement webElement : list) {
				System.out.println(webElement.getText());
			}
	}
		
		

}
