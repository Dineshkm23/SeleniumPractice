package seleniumPractice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinksFirefox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// WebDriver driver = new FirefoxDriver();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> Links = driver.findElements(By.tagName("a"));

		System.out.println("Total links:" + Links.size());
		int brokeLinksCount = 0;
		int noBrokeLinksCount = 0;
		int emptyHrefLinks = 0;
		for (WebElement link : Links) {
			String hrefAttValue = link.getAttribute("href");
			if (hrefAttValue.isBlank() || hrefAttValue.isEmpty() || hrefAttValue == null) {
				System.out.println("Unable to find the broken links..");
				emptyHrefLinks++;
			}

			try {
				URL linksUrl = new URL(hrefAttValue);

				HttpURLConnection conn = (HttpURLConnection) linksUrl.openConnection();
				conn.connect();
				int respCode = conn.getResponseCode();
				if (respCode >= 400) {
					System.out.println("Its a broken link and Response code is:" + respCode + ":  URL:" + hrefAttValue);
					brokeLinksCount++;
				} else {
					System.out.println(
							"Its Not a broken link and Response code is:" + respCode + ":  URL:" + hrefAttValue);
					noBrokeLinksCount++;
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // converting string url to Actual url
		}
		System.out.println("Broken links count:" + brokeLinksCount);
		System.out.println("Not broken links count:" + noBrokeLinksCount);
		System.out.println("Empty hrefLinks:" + emptyHrefLinks);
		driver.quit();

	}

}
