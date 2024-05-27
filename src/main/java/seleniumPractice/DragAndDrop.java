package seleniumPractice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		
		
		WebElement washington=driver.findElement(By.id("box3"));
		WebElement us=driver.findElement(By.id("box103"));
		
		Actions action= new Actions(driver);
		action.dragAndDrop(washington, us).perform();
		Thread.sleep(3000);
		WebElement dropLocation= driver.findElement(By.id("dropContent"));
		WebElement capitalWashington= driver.findElement(By.xpath("//div[@id='box103']/div[@id='box3']"));
		action.dragAndDrop(capitalWashington, dropLocation).perform();
		System.out.println("Done");
		
		WebElement rome= driver.findElement(By.id("box6"));
		int x=756;
		int y=411;
		
	x=driver.findElement(By.id("box102")).getLocation().getX();
	y=driver.findElement(By.id("box102")).getLocation().getY();
	System.out.println("X and Y:"+x+" ,"+y);
	//	action.dragAndDropBy(rome, x,y).perform();
		action.clickAndHold(rome).moveByOffset(x, y).release().build();
			
	}

}
