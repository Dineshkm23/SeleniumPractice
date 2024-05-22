package testngsessions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest {

	@Test
	public void TC101_getTitle() {
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test
	public void TC102_getCurrentUrl() {
		String url=driver.getCurrentUrl();
		Assert.assertTrue(url.contains("google"));
	}
	
}
