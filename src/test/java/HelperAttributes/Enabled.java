package HelperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Enabled {

	
	@Test(enabled = true)
	public void all() {
		
		Reporter.log("enabled a11",true);
	}
	
	@Test(enabled= false)
	public void a22() {
		Reporter.log("enabled a22",true);
	}
	
}
