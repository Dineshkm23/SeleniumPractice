package seleniumPractice;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDownAllOption {

	static boolean flag;
	static boolean checkBoxENabled;
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://orangehrm.com/en/book-a-free-demo/");
		By country = By.id("Form_getForm_Country");
		doSelectDropDownValue(country, "India");
		int count = getDropDownValuesCount(country);
		System.out.println("Country count:" + count);

		List<WebElement> countryCount = getDropDownOptionsList(country);
		System.out.println("Country count is:" + countryCount.size());
		ArrayList<String> countryNames = getDropDownOptionsListText(country);
		System.out.println(countryNames);
//		 select.selectByIndex(3);
//		 select.selectByVisibleText("Anguilla");		 
//		 select.selectByVisibleText("India");
//		 select.selectByValue("Argentina");
//		By country = By.id("Form_getForm_Country");

	}

	public static ArrayList<String> getDropDownOptionsListText(By locator) {
		List<WebElement> element = getDropDownOptionsList(locator);

		ArrayList<String> elementText = new ArrayList<>();

		for (WebElement text : element) {
			elementText.add(text.getText());
		}
		return elementText;
	}

	public static void doSelectDropDownValue(By locator, String text) {

		List<WebElement> countryOptions = getDropDownOptionsList(locator);

		System.out.println("Country count: " + countryOptions.size());

		for (WebElement webElement : countryOptions) {
			String countryName = webElement.getText();

			if (countryName.contains(text)) {
				// System.out.println(countryName);
				webElement.click();
				break;
			}
		}
	}

	public static void printSelectDropDownValue(By locator, String text) {

		List<WebElement> countryOptions = getDropDownOptionsList(locator);

		System.out.println("Country count: " + countryOptions.size());

		for (WebElement webElement : countryOptions) {
			String countryName = webElement.getText();
			System.out.println(countryName);
		}
	}

	public static List<WebElement> getDropDownOptionsList(By locator) {
		WebElement element = driver.findElement(locator);
		Select select = new Select(element);
		return select.getOptions();
	}

	public static int getDropDownValuesCount(By locator) {
		return getDropDownOptionsList(locator).size();
	}

}
