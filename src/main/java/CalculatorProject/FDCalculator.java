package CalculatorProject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Map<String, Object> pf = new HashMap<String, Object>();
	      // disable pop up browser preference added to Map
	      pf.put("profile.default_content_setting_values.notifications", 2);
	      //object of ChromeOptions
	      
		ChromeOptions option= new ChromeOptions();
		option.setExperimentalOption("prefs", pf);
		option.setExperimentalOption("excludeSwitches", new String[] {"disable-popup-blocking"});
		option.addArguments("--start-maximized");
		option.addArguments("--incognito");
		
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().deleteAllCookies();
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		
		String filePath=System.getProperty("user.dir")+"\\Datafolder\\InputData.xlsx";
		System.out.println("FilePath is:"+filePath);
		
		int rowCount=ExcelUtils.getRowCount(filePath, "Sheet2");
		
		System.out.println("Row counts:"+rowCount);
		
		
		for(int i=1; i<=rowCount;i++) {
			
			// 1 Read the data from Excel
			String principle=ExcelUtils.getCellData(filePath, "Sheet2", i, 0);
			String RateOfInterest=ExcelUtils.getCellData(filePath, "Sheet2", i, 1);
			String Per1=ExcelUtils.getCellData(filePath, "Sheet2", i, 2);
			String Per2=ExcelUtils.getCellData(filePath, "Sheet2", i, 3);
			String freq=ExcelUtils.getCellData(filePath, "Sheet2", i, 4);
			String exp_maturity=ExcelUtils.getCellData(filePath, "Sheet2", i, 5);
			
			// Pass the date into application
			//driver.findElement(By.xpath("//input[@id='principal']")).clear();
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(RateOfInterest);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(Per1);
			
			Select periodDays= new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
			periodDays.selectByVisibleText(Per2);
			
			Select selectFrequency= new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			selectFrequency.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			
			
			String actul_Maturity=driver.findElement(By.id("resp_matval")).getText();
			System.out.println("actul_Maturity:"+actul_Maturity);
			
			
			// Validate the result
			
			if(Double.parseDouble(exp_maturity)==Double.parseDouble(actul_Maturity)) {
				System.out.println("Passed:  Expected Value:"+exp_maturity+" Actual Value:"+actul_Maturity);
				ExcelUtils.setCellData(filePath, "Sheet2", i, 7, "Pass");
				ExcelUtils.fillGreenColor(filePath, "Sheet2", i, 7);
			}
			else {
				System.out.println("Failed:  Expected Value:"+exp_maturity+" Actual Value:"+actul_Maturity);
				ExcelUtils.setCellData(filePath, "Sheet2", i, 7, "Fail");
				ExcelUtils.fillRedColor(filePath, "Sheet2", i, 7);
			}
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
		}
		driver.quit();
	}

}
