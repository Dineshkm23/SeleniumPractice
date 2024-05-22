package seleniumPractice;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class AmazonTest {
      static WebDriver driver;
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		BrowserUtils brUtil = new BrowserUtils();
		driver=brUtil.launchBrowser("chrome");
//		brUtil.launchUrl(new URL("https://www.amazon.com"));
//		String title = brUtil.getTitle();
//		System.out.println("Title is:" + title);
//	System.out.println("Current URL is:"+brUtil.getUrl());
//	
//		brUtil.launchUrl("https://www.Google.com");
//		String nTitle = brUtil.getTitle();
//		System.out.println("Title is:" + nTitle);
//		Thread.sleep(1000);
//		brUtil.doBackword();
//		String brTitle = brUtil.getTitle();
//		System.out.println("Backword Title:" + brTitle);
//		Thread.sleep(1000);
//		brUtil.doForward();
//		String frTitle = brUtil.getTitle();
//		System.out.println("Forward Title:" + frTitle);
//		Thread.sleep(1000);
//
//		brUtil.doBackword();
//		String brTitle1 = brUtil.getTitle();
//		System.out.println("Backword Title:" + brTitle1);
//		Thread.sleep(1000);

		By email= By.id("in00ut-email");
		brUtil.launchUrl(new URL("https://naveenautomationlabs.com/opencart/index.php?route=account/register"));
		ElementUtil eleUtil= new ElementUtil(driver);
		eleUtil.doSendKeys(email, "dinesh...@gmail");
		System.out.println("Dinesh");
		System.out.println("Dinesh");
		System.out.println("Dinesh");
		
		
		//brUtil.closeBrowser();
	}

}
