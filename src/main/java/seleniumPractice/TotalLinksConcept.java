package seleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TotalLinksConcept {
 static WebDriver driver;
	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");

		 driver = new ChromeDriver(option);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

//		List<WebElement> ele = driver.findElements(By.tagName("a"));
//		System.out.println(ele.size());
//
//		int count = 0;
//		for (WebElement e : ele) {
//			String linktex = e.getText();
//
//			if (linktex.length() != 0) {
//				System.out.println(e.getText());
//			} else {
//				count++;
//			}
//		}
//		System.out.println(count);
////
//		int link = 0;
//		for (int i = 0; i < ele.size(); i++) {
//			String linkText = ele.get(i).getText();
//
//			if (linkText.length() != 0) {
//				System.out.println(linkText);
//			} else {
//				link++;
//			}
//		}
//		System.out.println(count);
//		System.out.println("---------------------------");
		
//		List<WebElement> textBoxes=driver.findElements(By.className("form-control"));
//		System.out.println("Text Boxes:"+textBoxes.size());
//		System.out.println("---------------------------");
//		
//		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
//		System.out.println("Total Links:"+allLinks.size());
//		
		
		//
		By aTagname=By.tagName("a");
		By inputTagname=By.tagName("input");
		//List<WebElement> allLinks=getElements(aTagname);
		
		//System.out.println("Total links:"+getElementsCount(aTagname));
//		for (WebElement linksHref : allLinks) {
//			String hrefValue=linksHref.getAttribute("href");
//			System.out.println(hrefValue);
//			System.out.println("---");
//			
//		}
		
		ArrayList<String> text=getElementsText(aTagname);
		System.out.println("ArrayList Size:" +text.size());
		System.out.println(text);
		
		ArrayList<String> attrValue=getElementsAttributeList(inputTagname,"name");
		System.out.println("ArrayList attribut count:"+attrValue.size());
		System.out.println(attrValue);
		
		
	}
	
	
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static int getElementsCount(By locator) {
		return driver.findElements(locator).size();
	}

	public static ArrayList<String> getElementsText(By locator ){
		List<WebElement> eleList=getElements(locator);
		ArrayList<String> arrList= new ArrayList<>();
		
		for (WebElement e : eleList) {
			String text=e.getText();
			if(text.length()!=0) {
				arrList.add(text);
			}						
		}
		return arrList;
	}
	
	public static ArrayList<String> getElementsAttributeList(By locator, String attributeName) {
		List<WebElement> eleAttrList=getElements(locator);
		
		ArrayList<String> arrAttrList = new ArrayList<>();
		
		for (WebElement attrList : eleAttrList) {
			String attrValue=attrList.getAttribute(attributeName);
			
			if(attrValue.length()!=0) {
				arrAttrList.add(attrValue);
			}
			
		}
	return 	arrAttrList;
	}
	
	
}
