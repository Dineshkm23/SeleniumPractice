package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleSelectionWithSelectClass {
	static boolean flag;
	static boolean checkBoxENabled;
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();
		driver.get("file:///C:/Users/Administrator/Documents/Documents/multiple.html");

		WebElement ele = driver.findElement(By.xpath("//*[@id='cars']"));

		Select select = new Select(ele);

		if (select.isMultiple()) {
			select.selectByVisibleText("Volvo");
			select.selectByVisibleText("Saab");
			select.selectByVisibleText("Audi");
		}
		select.deselectByVisibleText("Audi");

		//select.deselectAll();
	}

}
