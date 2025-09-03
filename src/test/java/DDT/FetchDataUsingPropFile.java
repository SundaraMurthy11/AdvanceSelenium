package DDT;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataUsingPropFile {
public static void main(String[] args) throws IOException, InterruptedException {
	
FileInputStream fis=new FileInputStream("D:\\MyWorkSpace\\ninzaCRM\\src\\test\\resources\\commondata.properties");
Properties prop= new Properties();
prop.load(fis);
String URL=prop.getProperty("url");
String USERNAME=prop.getProperty("userName");
String PASSWORD=prop.getProperty("password");

	//launch browser
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(URL);
	Thread.sleep(3000);

	driver.findElement(By.id("username")).sendKeys(USERNAME);
	Thread.sleep(3000);
	driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
	Thread.sleep(3000);

	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);

//	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
	driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
	
	driver.findElement(By.name("campaignName")).sendKeys("OnePlus 11R");

	 WebElement targetSize=driver.findElement(By.name("targetSize"));
	targetSize.clear();
	targetSize.sendKeys("100");
	//targetAudience
	 WebElement targetAudience=driver.findElement(By.name("targetAudience"));
	 targetAudience.sendKeys("Children");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    Thread.sleep(2000);
//    Campaign sdsa Successfully Added
   String name= driver.findElement(By.xpath("//div[@class=\"Toastify__toast-body\"]")).getText();
    System.out.println(name);
    String expectedName="Campaign OnePlus R Successfully Added";
    if(name.equals(expectedName)) {
    	System.out.println("Campaign created");
    } else {
    	System.out.println("Not created");
    }
    Thread.sleep(5000);

    driver.findElement(By.xpath("//a[text()='Contacts']")).click();
    driver.findElement(By.xpath("//span[text()='Create Contact']")).click();
    driver.findElement(By.xpath("//*[name()='svg' and @data-icon='plus']")).click();
    
  String parent=driver.getWindowHandle();
  Set<String> child=driver.getWindowHandles();
  child.remove(parent);
  for(String s:child) {
	  driver.switchTo().window(s);
	    Thread.sleep(5000);

	  driver.findElement(By.id("search-input")).sendKeys("CAM05087",Keys.ENTER);
	
  }
  
    Thread.sleep(5000);


    driver.findElement(By.className("select-btn")).click();
}
}

