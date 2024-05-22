package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AmazonXpathTest {

	static WebDriver driver;

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("incognito");
		//option.addEncodedExtensions("https://chromewebstore.google.com/detail/screen-recorder-for-googl/eclbecdgdoahkliaijlpkigldlkojjdn");
		
		driver = new ChromeDriver(option);
		driver.get("https://www.amazon.ae/");
		
		By footer1=By.xpath("(//div[@class='navFooterLinkCol navAccessibility'])[position()=last()]//li");
		
		List<WebElement> elements = driver.findElements(footer1);
		
		System.out.println(elements);
		
		for(WebElement ele:elements) {
			System.out.println(ele.getText());
		}
		
	}

}
