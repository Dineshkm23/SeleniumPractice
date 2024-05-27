package seleniumPractice;

import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegPage1 {
	public static void main(String[] args) {

		long randomNumber =System.currentTimeMillis();
		String randomNuString=String.valueOf(randomNumber);
		String randomEmailId = "Dkautomation"+randomNuString+"@gmail.com";
		System.out.println("Random number:" + randomEmailId);
		BrowserUtils brUtil = new BrowserUtils();
		WebDriver driver = brUtil.launchBrowser("chrome");

		brUtil.launchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		ElementUtil el = new ElementUtil(driver);
		By firstName = By.id("input-firstname");
		By lastName = By.name("lastname");
		By email = By.id("input-email");
		By telePhone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPsw = By.id("input-confirm");
		By subscribeBtn = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input");
		By TMButton = By.name("agree");
		By contBtn = By.className("btn-primary");
		By confirmMsg = By.tagName("h1");

		el.doSendKeys(firstName, "firstname Dinehs");
		el.doSendKeys(lastName, "LastNAmeDinesh");
		el.doSendKeys(email, randomEmailId);

		String attrValue = el.doGetAttributeValue(email, "value");
		System.out.println("email address:" + attrValue);
		el.doSendKeys(telePhone, "9999992882");
		el.doSendKeys(password, "1234123");
		el.doSendKeys(confirmPsw, "1234123");

		el.doClick(subscribeBtn);
		el.doClick(TMButton);
		el.doClick(contBtn);
		String text = el.doGetElementText(confirmMsg);

		if (text.equals("Your Account Has Been Created!")) {
			System.out.println("Account is created");
		} else {
			System.out.println("account is not created");
		}

	}

	public static String getRandomNumber() {
		//return System.currentTimeMillis();
		UUID uuid= UUID.randomUUID();
		System.out.println(uuid);
		return "DkAutomation"+uuid+"@gmail.com";
	}

}
