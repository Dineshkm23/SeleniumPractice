package seleniumPractice;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions option= new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--headless");
		option.addArguments("--incognito");
		WebDriver driver = new ChromeDriver(option);
		driver.get("http://www.deadlinkcity.com/");
		
		// Case1 complete web page screenshot
		TakesScreenshot ts=(TakesScreenshot) driver;
		File sourceFile=ts.getScreenshotAs(OutputType.FILE);
		File targetFile= new File(".\\screenshots\\homepage.png");
		
		sourceFile.renameTo(targetFile);	
		
		// case2: Specific web element screenshot
		By comparisonXpath= By.xpath("//a[@href='/comparison.asp']");
		WebElement comparisonTool=driver.findElement(comparisonXpath);
		File sourceComparison=comparisonTool.getScreenshotAs(OutputType.FILE);
		File targetComparison= new File(System.getProperty("user.dir")+"\\screenshots\\comparisonTool.png");
		sourceComparison.renameTo(targetComparison);
		driver.quit();
	}

}
