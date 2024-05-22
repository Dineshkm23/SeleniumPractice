package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class StaticWebTable {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("incognito");
		
		driver = new ChromeDriver(option);
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		List<WebElement>rows=driver.findElements(By.xpath("//table[@id='customers']//tr"));
		System.out.println("Rows count:"+rows.size());
		
		List<WebElement> cols=driver.findElements(By.xpath("//*[@id=\"customers\"]/tbody/tr/th"));
		System.out.println("Cols count:"+cols.size());
		//copy the web table rows xpath by right click
		//*[@id="customers"]/tbody/tr[1]/td[1]
		//*[@id="customers"]/tbody/tr[2]/td[1]
		//*[@id="customers"]/tbody/tr[3]/td[1]
		
		String BeforeXpath="//*[@id=\"customers\"]/tbody/tr[";
		String midleXpath="]/td[";
		String AfterXpath="]";
	
		for(int i=2;i<=rows.size();i++) {
			for (int j = 1; j <= cols.size(); j++) {
				//System.out.println(BeforeXpath+i+AfterXpath+j+AfterXpath);
				String Name=driver.findElement(By.xpath(BeforeXpath+i+midleXpath+j+AfterXpath)).getText();
					System.out.print(Name+" : ");
			}
			System.out.println();
		
		}
	}

}
