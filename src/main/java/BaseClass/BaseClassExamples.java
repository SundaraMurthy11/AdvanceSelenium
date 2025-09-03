package BaseClass;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClassExamples {

	
	@Test
	public void TC001() {
		
		Reporter.log("TestCases", true);
	}
	
	@BeforeMethod
	public void beforeMethod() {
		
		Reporter.log("Login", true);
	}
	
	@AfterMethod
	public void afterMethod() {
		
		Reporter.log("Logout", true);
	}
	
	@BeforeClass
	public void beforeClass() {
		
		Reporter.log("Launch browser", true);
	}
	
	@AfterClass
	public void afterClass() {
		
		Reporter.log("Close browser", true);
	}
	
	@BeforeTest
	public void beforeTest() {
		
		Reporter.log("Pre Conditions", true);
	}
	
	@AfterTest
	public void afterTest() {
		
		Reporter.log("Post Conditions", true);
	}
	@BeforeSuite
	public void beforeSuite() {
		
		Reporter.log("DB Connection eshtablished", true);
	}
	
	@AfterSuite
	public void afterSuite() {
		
		Reporter.log("Close database connection", true);
	}
	
	
}
