package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import PageObjectModel.CampaignPage;
import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebdriverUtility.WebdriverUtility;

public class CreateCampaignWithDatesTest extends BaseClass{
	
	@Test(groups = "Smoke")
    public void createCampaignUsingExpectedDate() throws IOException, InterruptedException {


	ExcelUtility eutil= new ExcelUtility();
    WebdriverUtility wutil= new WebdriverUtility();

	String campaignName=	eutil.getExcelCellData("Campaign", 2, 1);
	String targetSizes=	eutil.getExcelCellData("Campaign", 2, 2);




    HomePage hpage= new HomePage(driver);
    hpage.getCampaign().click();
    hpage.getCreateCampaign().click();
    
    
    CampaignPage cpage=new CampaignPage(driver);
    cpage.getTargetSize().clear();
    cpage.getTargetSize().sendKeys(targetSizes);
    
    cpage.getCampaignName().sendKeys(campaignName);
    JavaUtility jutil = new JavaUtility();
	String dateRequired= jutil.toGetRequired(30);
    cpage.getExpectedCloseDate().sendKeys(dateRequired);

    cpage.getSubmitBtn().click();
    
    WebElement alert = hpage.toastMessage();
    wutil.waitforVisibilityofElement(driver, alert);
    hpage.closeToast().click();


}
}
