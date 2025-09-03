package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
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
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import PageObjectModel.CampaignPage;
import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import WebdriverUtility.WebdriverUtility;

public class CreateCampaignUsingStatusTest extends BaseClass {
	@Test(groups = "Smoke")
    public void createCampaignUsingStatus() throws IOException, InterruptedException {
	

	//Excel Test Data Fetching Code
	ExcelUtility eutil= new ExcelUtility();
	  WebdriverUtility wutil= new WebdriverUtility();
	String campaignName=	eutil.getExcelCellData("Campaign", 3, 1);
	String targetSizes=	eutil.getExcelCellData("Campaign", 3, 2);
	String status=	eutil.getExcelCellData("Campaign", 3, 3);


    HomePage hpage= new HomePage(driver);
    hpage.getCampaign().click();
    hpage.getCreateCampaign().click();
	

    
    CampaignPage cpage=new CampaignPage(driver);

    
    cpage.getCampaignName().sendKeys(campaignName);
    cpage.getCampaignStatus().sendKeys(status);
    cpage.getSubmitBtn().click();
    
    WebElement alert = hpage.toastMessage();
    wutil.waitforVisibilityofElement(driver, alert);
    hpage.closeToast().click();

}
}
