package HelperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority {

	
	@Test(priority = 0)
	public void amazon() {
		Reporter.log("Amazon Executed",true);
	}
	@Test(priority = 2)
	public void flipkart() {
		Reporter.log("Flipkart Executed",true);
	}
	
	@Test(priority = -4)
	public void bookMyShow() {
		Reporter.log("BookMySHow Executed",true);
	}
	
}
