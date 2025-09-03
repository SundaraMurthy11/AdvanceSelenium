package HelperAttributes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ThreadPoolSize {
	@Test(invocationCount = 6, threadPoolSize = 6)
	public void amazon() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		Reporter.log("Execution done", true);
		Thread.sleep(2000);
		driver.quit();
	}
	@Test(invocationCount = 6, threadPoolSize = 6)
	public void amazon1() throws InterruptedException {
		WebDriver driver= new ChromeDriver();
		Reporter.log("Execution done", true);
		Thread.sleep(2000);
		driver.quit();
	}
}
