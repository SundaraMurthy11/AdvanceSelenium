package HelperAttributes;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviders {

	
	@Test(dataProvider = "loginDetails")
	public void loginInsta(String username, String password) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.instagram.com/");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[text()='Log in']")).click();
		Thread.sleep(3000);
		driver.quit();

		
	}
	
	@DataProvider
	public Object[] loginDetails() throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream("D:\\MyWorkSpace\\ninzaCRM\\TestData\\DataProviderSheet.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		 int row=sh.getLastRowNum();
		 Object[][] objArr= new Object[row][2];
		for(int i=0;i<row;i++) {
			objArr[i][0]=sh.getRow(i+1).getCell(0).getStringCellValue();
			objArr[i][1]=sh.getRow(i+1).getCell(1).getStringCellValue();
			
		}
		return objArr;

	}
	
}
