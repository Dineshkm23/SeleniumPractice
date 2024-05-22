package testngsessions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.internal.invokers.InvokedMethod;

public class openCartTest {

	@BeforeSuite
	public void dbConnection()
	{
		System.out.println("BS dbConnection");
	}
	
	@BeforeTest
	public void launchBrowser()
	{
		System.out.println("BT dbConnection");
	}
	
	@BeforeClass
	public void launchUrl() {
		System.out.println("BC launchUrl");
	}
	
	@BeforeMethod
	public void logIn() {
		System.out.println("BM logIn");
	}
	
	@Test(invocationCount=10)
	public void test34() {
		System.out.println("test repear");
	}
	
	@Test
	public void test()
	{
		System.out.println("Test");
	}
	
	@Test
	public void test1()
	{
		System.out.println("Test1");
	}
	
	@Test
	public void test2()
	{
		System.out.println("Test2");
	}
	
	@AfterMethod
	public void logOut() {
		System.out.println("AM logOut");
	}
	
	@AfterClass
	public void closeUrl() {
		System.out.println("AC closeUrl");
	}
	
	@AfterTest
	public void closeBrowser() {
		System.out.println("AT closeBrowser");
	}
	
	@AfterSuite
	public void closeDbConnection() {
		System.out.println("AS closeDbConnection");
	}
	
}
