package seleniumPractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DatePicker2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String expectedYear= "1941";
		String expectedMonth= "June";
		String expectedDate= "24";
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize()	;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.manage().deleteAllCookies();
		
		By frame= By.id("frame-one796456169");
				
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.switchTo().frame("frame-one796456169");
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.id("q4_label"))).build().perform();
		driver.findElement(By.xpath("//span[@role='button']")).click();
		Thread.sleep(5000);
//		driver.findElement(By.xpath("//span[@class='icon_calendar']")).click();
//		List<WebElement> years=driver.findElements(By.xpath("//select[@aria-label='Select year']/option"));
//		
		
//		for (WebElement yearList : years) {
//			String year=yearList.getText();
//			System.out.println("Actaul Year:"+year);
//			if(year.equals(expectedYear)) {
//				Thread.sleep(2000);
//				yearList.click();
//				System.out.println("Year is Selected:"+year);
//				break;
//			}
//		}
		
		//************************************
		WebElement ele=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select select= new Select(ele);
		
		//select.selectByVisibleText(expectedYear);
		select.selectByValue(expectedYear);
		
		//************************************
		while(true){
			String actualMonth=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			System.out.println("Actual month:"+actualMonth);
			if(actualMonth.equals(expectedMonth)) {
			break;
			}
			driver.findElement(By.xpath("//a[@data-handler='prev']")).click();
		}
		List<WebElement> actualDates=driver.findElements(By.xpath("//tbody/tr/td[@data-handler='selectDay']"));
		//System.out.println(actualDates);
		for(WebElement aDates:actualDates) {
			String date=aDates.getText();
			System.out.println("Actual Date:"+date);
			if(date.equals(expectedDate))
			{
				aDates.click();
				break;
			}
		}
		
	}

}
