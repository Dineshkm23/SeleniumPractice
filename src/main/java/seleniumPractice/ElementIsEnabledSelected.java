package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementIsEnabledSelected {
	static boolean flag;
	static boolean checkBoxENabled;
	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		
		driver.get("https://classic.freecrm.com/register/");
		 flag=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag);
		
		
		
		checkBoxENabled=driver.findElement(By.name("agreeTerms")).isSelected();
		
		if(checkBoxENabled==false) {
			System.out.println("check box is not checked hencce enabling");
			driver.findElement(By.name("agreeTerms")).click();
		}
		 checkBoxENabled=driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("Check box enabled :"+checkBoxENabled);
		 flag=driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(flag);
		
		
	}

}
