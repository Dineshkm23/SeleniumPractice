package seleniumPractice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertJsPopUpHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		// Alert
		// Confirm
		// Prompt

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(option);

		// 1 Alert
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();
		String AlertText = alert.getText();
		System.out.println("Alert text:" + AlertText); // Alert text:I am a JS Alert
		System.out.println("HashCode:" + alert.hashCode()); // HashCode:1942828992
		alert.accept();

		// 2. confirm
		// driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert alertConfirm = driver.switchTo().alert();
		String confirmAlertText = alertConfirm.getText();
		System.out.println("Alert text:" + confirmAlertText); // Alert text:I am a JS Alert
		System.out.println("HashCode:" + alertConfirm.hashCode()); // HashCode:1942828992
		Thread.sleep(3000);
		alert.accept();
		String acceptText = driver.findElement(By.id("result")).getText();
		System.out.println("Result:" + acceptText);

		if (acceptText.contains("You clicked: Ok")) {
			System.out.println("Its correct Accept comfirmation text");
		} else {
			System.out.println("Its not accept confirmation text");
		}

		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		Alert alertDismiss = driver.switchTo().alert();
		Thread.sleep(3000);
		alertDismiss.dismiss();
		String dismissText = driver.findElement(By.id("result")).getText();
		System.out.println("Result:" + dismissText);
		if (dismissText.contains("You clicked: Ok")) {
			System.out.println("Its correct Dismiss comfirmation text");
		} else {
			System.out.println("Its not Dismiss confirmation text");
//		}

			// 2. Prompt
			// driver.get("https://the-internet.herokuapp.com/javascript_alerts");
			driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
			Alert alertPrompt = driver.switchTo().alert();
			String promptAlertText = alertPrompt.getText();
			System.out.println("Alert text:" + promptAlertText); // Alert text:I am a JS Alert
			System.out.println("HashCode:" + alertPrompt.hashCode()); // HashCode:1942828992
			// Thread.sleep(3000);
			alert.sendKeys("Dinesh");
			Thread.sleep(3000);
			alert.accept();
			String promptText = driver.findElement(By.id("result")).getText();
			System.out.println("Result:" + promptText);
			if (promptText.contains("You entered:")) {
				System.out.println("Its correct Prompt comfirmation text");
			} else {
				System.out.println("Its not Prompt confirmation text");
			}
			
			driver.quit();
		}

	}
}
