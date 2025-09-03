package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import PageObjectModel.ProductsPage;
import PropertiesFileUtility.PropertiesUtility;
import WebdriverUtility.WebdriverUtility;

public class CreateProductTest extends BaseClass{

	@Test(groups = "Smoke")
    public void createCampaignUsingExpectedDate() throws IOException, InterruptedException {

//
//	PropertiesUtility putil= new PropertiesUtility();
//	String URL=putil.getDataFromPropertiesFile("url");
//	String USERNAME=putil.getDataFromPropertiesFile("username");
//	String PASSWORD=putil.getDataFromPropertiesFile("password");
//	
//
//	
	WebdriverUtility wutil= new WebdriverUtility();
	ExcelUtility eutil= new ExcelUtility();
	String productName=	eutil.getExcelCellData("Products", 1, 1);
	String productCategory=	eutil.getExcelCellData("Products", 1, 2);
	String vendorName=	eutil.getExcelCellData("Products", 1, 3);

//		driver.switchTo().alert().accept();
    HomePage hpage= new HomePage(driver);
    hpage.getProduct().click();
    hpage.getAddProducts().click();

    ProductsPage ppage= new ProductsPage(driver);
    ppage.getProductName().sendKeys(productName);
    WebElement productcatdd=ppage.getProductCategory();
    
    wutil.select(productcatdd, productCategory);
    WebElement vendordd=  ppage.getVendorId();
    wutil.selectByVisibleText(vendordd,vendorName);

		
		//campaign Status
	  //  driver.findElement(By.xpath("//button[@type='submit']")).click();


}
}
