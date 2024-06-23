package seleniumPractice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.deadlinkcity.com/");

		List<WebElement> Links = driver.findElements(By.tagName("a"));
		System.out.println("Total links:" + Links.size());
		int broken_Links_Count = 0;
		for (WebElement e : Links) {
			String hrefAttValue = e.getAttribute("href");

			if (hrefAttValue == null || hrefAttValue.isEmpty() || hrefAttValue.isBlank()) {
				System.out.println("Href value is null or empty hence not possible to check");
				continue;
			}

			try {

				// Hit the Url to the server
				URL linkurl = new URL(hrefAttValue); // convert href value from string to URL Format
				HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection();
				conn.connect(); // connect to server and sent the request to the server
				if (conn.getResponseCode() >= 400) {
					System.out.println("Its a broken links:" + linkurl);
					broken_Links_Count++;
				} else {
					System.out.println("Its not a broken link:" + linkurl);
				}

			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} // Open connection to the server

		}
		System.out.println("Total broken links:" + broken_Links_Count);
		driver.quit();

	}

}
