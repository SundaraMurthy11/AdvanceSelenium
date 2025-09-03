package HelperAttributes;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertDemo {
	@Test
public static void titlecase() {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("https://www.facebook.com/");
	String expectedTitle="Facebook – log iqn or sign up";
	String actualTitle=driver.getTitle();
	

	SoftAssert sa= new SoftAssert();
	sa.assertEquals(actualTitle, expectedTitle);
	
//	Assert.assertEquals(actualTitle, expectedTitle);
	System.out.println("STEP1");
	System.out.println("STEP2");
	sa.assertAll();
}
}
