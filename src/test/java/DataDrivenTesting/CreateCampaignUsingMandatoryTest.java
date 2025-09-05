package DataDrivenTesting;


import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import PageObjectModel.CampaignPage;
import PageObjectModel.HomePage;

import WebdriverUtility.WebdriverUtility;

@Listeners(listeners.ListenersImplementation.class)

public class CreateCampaignUsingMandatoryTest extends BaseClass{
	@Test(groups = "Regression")
    public void createCampaign() throws IOException, InterruptedException {

//Excel Test Data Fetching Code
	ExcelUtility eutil= new ExcelUtility();
    WebdriverUtility wutil= new WebdriverUtility();
	String campaignName=	eutil.getExcelCellData("Campaign", 1, 1);
	String targetSizes=	eutil.getExcelCellData("Campaign", 1, 2);

	Thread.sleep(8000);
    HomePage hpage= new HomePage(driver);
    hpage.getCampaign().click();
    hpage.getCreateCampaign().click();
    
    
    CampaignPage cpage=new CampaignPage(driver);
    cpage.getTargetSize().clear();
    cpage.getTargetSize().sendKeys(targetSizes);
    
    cpage.getCampaignName().sendKeys(campaignName);
    cpage.getSubmitBtn().click();
    
    WebElement alert = hpage.toastMessage();
    wutil.waitforVisibilityofElement(driver, alert);
    hpage.closeToast().click();
    

    
    

}
}
