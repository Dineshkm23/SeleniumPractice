package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GoogleSearchSuggestions {

	
		static WebDriver driver;

		public static void main(String[] args) {

			ChromeOptions option = new ChromeOptions();
			option.addArguments("start-maximized");
			//option.addEncodedExtensions("https://chromewebstore.google.com/detail/screen-recorder-for-googl/eclbecdgdoahkliaijlpkigldlkojjdn");
			
			driver = new ChromeDriver(option);
			driver.get("https://www.google.com/");
			driver.findElement(By.name("q")).sendKeys("Selenium");
			//Thread.sleep(3000);
			List<WebElement> suggestions=driver.findElements(By.xpath("//ul[@class='G43f7e' and @role='listbox']//div[@class='wM6W7d']"));

			System.out.println(suggestions.size());
			
			for (WebElement webElement : suggestions) {
				System.out.println(webElement.getText());
			}
			
			
	}

}
