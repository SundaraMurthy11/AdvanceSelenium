package HelperAttributes;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependsOn {


	
	@Test(priority = 3)
	public void method1() {
		
		Reporter.log("enabled method1",true);
	}
	
	@Test
	public void method2() {
		Reporter.log("enabled method2",true);
	}
	
	@Test(dependsOnMethods = "method1")
	public void method3() {
		Reporter.log("enabled method3",true);
	}
	
}
