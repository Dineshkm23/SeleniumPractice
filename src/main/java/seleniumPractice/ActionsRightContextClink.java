package seleniumPractice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsRightContextClink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ExpectedText="Delete";
		WebDriver driver= new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement ele=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
		
		List<WebElement> rightclick=driver.findElements(By.cssSelector("ul.context-menu-list >li:not(.context-menu-separator)"));
		
		
		for (WebElement e : rightclick) {
			String text=e.getText();
			System.out.println(text);
			if(text.contains(ExpectedText)) {
				e.click();
				Alert alert=driver.switchTo().alert();
				alert.accept();
				break;
			}
			
		}
		
			
	}

}
