package seleniumPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AuthPopUp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions option= new ChromeOptions();
		option.addArguments("start-maximized");
		WebDriver driver=new ChromeDriver(option);
		
		//1st Option
		//driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		// 2nd Option
		
		String userName="admin";
		String password="admin";
	//	driver.get("https://"+userName+":"+password+"@the-internet.herokuapp.com/basic_auth");
//		
//		String text = driver.findElement(By.tagName("p")).getText();
//		System.out.println(text);
		
		
		// selenium 4.X
		// HasAuthentication
		((HasAuthentication)driver).register(() -> new UsernameAndPassword(userName, password));
		
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		String text = driver.findElement(By.tagName("p")).getText();
		System.out.println(text);
		driver.quit();
		
	}

}
