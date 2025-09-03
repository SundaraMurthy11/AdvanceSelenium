package hardCodedProgram;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class CreateCampaignWithDate {
public static void main(String[] args) throws InterruptedException {
	//launch browser
	System.setProperty("webdriver.edge.driver", "C:\\Drivers\\msedgedriver.exe");


	WebDriver driver=new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get("http://49.249.28.218:8098/");
	Thread.sleep(3000);

	driver.findElement(By.id("username")).sendKeys("rmgyantra");
	Thread.sleep(3000);
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	Thread.sleep(3000);

	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(5000);
	
	Date date= new Date();
	SimpleDateFormat dateFormat= new SimpleDateFormat("MM-dd-YYYY");
	dateFormat.format(date);
	Calendar cal= dateFormat.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, 30);
	String dateRequired= dateFormat.format(cal.getTime());

//	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
	driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();

	 WebElement targetSize=driver.findElement(By.name("targetSize"));
	targetSize.clear();
	targetSize.sendKeys("100");
	//targetAudience
	 WebElement targetAudience=driver.findElement(By.name("targetAudience"));
	 targetAudience.sendKeys("Children");
		driver.findElement(By.name("campaignName")).sendKeys("OnePlus 11R");

    driver.findElement(By.name("expectedCloseDate")).sendKeys(dateRequired);
    
    
    driver.findElement(By.xpath("//button[@type='submit']")).click();



}
}
