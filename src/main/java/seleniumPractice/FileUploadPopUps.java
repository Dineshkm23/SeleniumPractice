package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileUploadPopUps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);

		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
		
		// type=file is mandatory
		
		//String filePath="\"C:\\Users\\Administrator\\Desktop\\ARMADA RESIDENCE.docx\"";
		driver.findElement(By.name("upfile")).sendKeys("C:\\Users\\Administrator\\Desktop\\ARMADA RESIDENCE.docx");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
