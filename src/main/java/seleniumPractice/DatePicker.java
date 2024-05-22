package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectedYear= "2025";
		String expectedMonth= "June";
		String expectedDate= "24";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://jqueryui.com/datepicker/");
		driver.switchTo().frame(0);
		//frame((WebElement) By.xpath("//input[@id='datepicker']"));

		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		
		while(true) {
			
			String actualYear= driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			String actualMonth= driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println("Year:"+actualYear+" , Month:"+actualMonth);
			if(expectedYear.equals(actualYear) && expectedMonth.equals(actualMonth)) {
				
				List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));
				
				for (WebElement webElement : dates) {
					String date=webElement.getText();
					System.out.println("Actual Year:"+actualYear+" ,actual Month:"+actualMonth+" ,Actual Date:"+date);
					if(date.equals(expectedDate))
					{
						webElement.click();
						break;
					}
					//break;
				}
				break;
			}
			
			//driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span")).click(); // Back
			
			driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]/span")).click(); //Next
			
		}
		Thread.sleep(2000);
		driver.quit();
	}

}
