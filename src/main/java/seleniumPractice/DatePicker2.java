package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectedYear= "1925";
		String expectedMonth= "June";
		String expectedDate= "24";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize()	;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().deleteAllCookies();
		
		By frame= By.id("frame-one796456169");
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().frame("frame-one796456169");
		driver.findElement(By.xpath("//span[@role='button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
		List<WebElement> years=driver.findElements(By.xpath("//select[@aria-label='Select year']/option"));
		
		for (WebElement yearList : years) {
			String year=yearList.getText();
			System.out.println("Actaul Year:"+year);
			if(year.equals(expectedYear)) {
				yearList.click();
				System.out.println("Year is Selected:"+year);
				break;
			}
		}
		
		while(true){
			String actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println("Actual month:"+actualMonth);
			if(actualMonth.equals(expectedMonth)) {
			break;
			}
			driver.findElement(By.className(".ui-datepicker-prev")).click();
		}
		List<WebElement> actualDates=driver.findElements(By.xpath("//tbody/tr/td[@data-handler='selectDay']"));
		System.out.println(actualDates);
	}

}
