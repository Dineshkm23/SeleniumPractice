package testngsessions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHrmTest extends BaseTest{

	
	@Test
	public void TC101_getTitle() {
		Assert.assertEquals(driver.getTitle(), "Book Your Free Demo | OrangeHRM");
	}
	
	@Test
	public void TC103_imageTest() {
		boolean flag=driver.findElement(By.xpath("//img[@alt='OrangeHRM Logo']")).isDisplayed();
		Assert.assertEquals(flag, true);
	}
	@Test
	public void TC102_getCurrentUrl() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("book-a-free-demo/"));
	}
	
	
	
}
