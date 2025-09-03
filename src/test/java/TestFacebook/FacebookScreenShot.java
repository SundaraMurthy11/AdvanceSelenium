package TestFacebook;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import WebdriverUtility.WebdriverUtility;

public class FacebookScreenShot {
public static void main(String[] args) throws IOException {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.facebook.com/");

	WebdriverUtility wutil= new WebdriverUtility();
	wutil.takesScreenshot(driver, "Screenshot1");
	wutil.takesScreenshot(driver, "Screenshot2");
	wutil.takesScreenshot(driver, "Screenshot3");
	
}
}
