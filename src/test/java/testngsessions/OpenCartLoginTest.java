package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartLoginTest extends BaseTest {
	
	@Test
	public void TC101_getTitle() {
		Assert.assertEquals(driver.getTitle(), "Account Login");
	}
	
	@Test(priority=-1)
	public void TC102_getCurrentUrl() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("route=account/login"));
	}
	
	@Test(priority=-2)
	public void TC103_imageTest() {
		boolean flag=driver.findElement(By.cssSelector(".img-responsive")).isDisplayed();
		Assert.assertEquals(flag, true);
	}

}
