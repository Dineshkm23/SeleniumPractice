package seleniumPractice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public By getBy(String locatorType, String locatorValue) {

		By locator = null;
		switch (locatorType.toLowerCase().trim()) {
		case "id":
			locator = By.id(locatorValue);
			System.out.println("Inside getBy id");
			break;
		case "name":
			locator = By.name(locatorValue);
			System.out.println("Inside getBy name");
			break;
		case "tagname":
			locator = By.tagName(locatorValue);
			System.out.println("Inside getBy TagName");
		case "linktext":
			locator = By.linkText(locatorValue);
			System.out.println("Inside getBy linkText");
		case "classname":
			locator = By.className(locatorValue);
			System.out.println("Inside getBy className");
		case "xpath":
			locator = By.xpath(locatorValue);
			System.out.println("Inside getBy xapth");
		case "css":
			locator = By.cssSelector(locatorValue);
			System.out.println("Inside getBy CSS Selectors");
		case "partiallinktext":
			locator = By.partialLinkText(locatorValue);
			System.out.println("Inside getBy partiallunkText Selectors");
		default:
			System.out.println();
		}

		return locator;
	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		System.out.println(locator);
		try {
			element = driver.findElement(locator);

		} catch (Exception e) {
			System.out.println("Element is not present on the WEB Page:" + locator);
			e.printStackTrace();
			return null;
		}
		return element;
	}

	public WebElement getElement(String locatorType, String value) {
		return driver.findElement(getBy(locatorType, value));
	}

	// to get the List of WebElement of links/textBox
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public boolean isElementExist(By locator) {
		if (getElements(locator).size() == 1) {
			return true;
		}
		return false;
	}

	public boolean multipleElementsExist(By locator) {
		if (getElements(locator).size() > 1) {
			System.out.println("Multiple elements present");
			return true;
		}
		System.out.println("Multiple elements not present");
		return false;
	}

	// to get the total number of links
	public int getElementsCount(By locator) {
		return getElements(locator).size();
	}

	public ArrayList<String> getElementsText(By locator) {
		List<WebElement> eleList = getElements(locator);
		ArrayList<String> arrList = new ArrayList<>();

		for (WebElement e : eleList) {
			String text = e.getText();
			if (text.length() != 0) {
				arrList.add(text);
			}
		}
		return arrList;
	}

	public ArrayList<String> getElementsAttributeList(By locator, String attributeName) {
		List<WebElement> eleAttrList = getElements(locator);

		ArrayList<String> arrAttrList = new ArrayList<>();

		for (WebElement attrList : eleAttrList) {
			String attrValue = attrList.getAttribute(attributeName);

			if (attrValue.length() != 0) {
				arrAttrList.add(attrValue);
			}

		}
		return arrAttrList;
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	

	public void doSendKeys(String locatorType, String locatorValue, String value) {
		getElement(getBy(locatorType, locatorValue)).sendKeys(value);
	}

	public void doClick(By locator) {
		getElement(locator).click();
		// driver.findElement(locator).click();
	}

	public void doClick(String locatorType, String locatorValue) {
		getElement(getBy(locatorType, locatorValue)).click();
	}

	public String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	public String doGetElementText(String locatorType, String value) {
		return getElement(locatorType, value).getText();
	}

	public String doGetAttributeValue(By locator, String attributeName) {
		return getElement(locator).getAttribute(attributeName);
	}

	public boolean isElementDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	//// ****************Select based dropdown
	//// utils*********************************************
	public void doSelectByIndex(By locator, int indexValue) {
		// WebElement element = getElement(locator);

		Select select = new Select(getElement(locator));
		select.selectByIndex(indexValue);
	}

	public void doSelectByVisibleText(By locator, String text) {
		nullBlankCheck(text);
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(text);
	}

	public void doSelectByValue(By locator, String textValue) {
		nullBlankCheck(textValue);
		Select select = new Select(getElement(locator));
		select.selectByValue(textValue);
	}

	private void nullBlankCheck(String textValue) {
		if (textValue == null || textValue.length() == 0) {
			throw new MyElementException("textValue can not be null");
		}
	}

	public  ArrayList<String> getDropDownOptionsListText(By locator) {
		List<WebElement> element = getDropDownOptionsList(locator);

		ArrayList<String> elementText = new ArrayList<>();

		for (WebElement text : element) {
			elementText.add(text.getText());
		}
		return elementText;
	}

	public  void doSelectDropDownValue(By locator, String text) {

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

	public  void printSelectDropDownValue(By locator, String text) {

		List<WebElement> countryOptions = getDropDownOptionsList(locator);

		System.out.println("Country count: " + countryOptions.size());

		for (WebElement webElement : countryOptions) {
			String countryName = webElement.getText();
			System.out.println(countryName);
		}
	}

	public  List<WebElement> getDropDownOptionsList(By locator) {
		WebElement element = getElement(locator);
		Select select = new Select(element);
		return select.getOptions();
	}

	public int getDropDownValuesCount(By locator) {
		return getDropDownOptionsList(locator).size();
	}
	// Without select class , select the drop down
	public void doSelectValueFromDropDown(By locator, String value) {
		List<WebElement> element=getElements(locator);
		
		for(WebElement ele: element){
			String text=ele.getText();
			if(text.equals(value)) {
				ele.click();
				break;
			}
		}
	}
		
	

	// ********************************************************************************

}