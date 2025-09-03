package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	WebDriver driver;
	public CampaignPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(name="campaignName")
	private WebElement campaignName;
	
	public WebElement getCampaignName() {
		return campaignName;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getTargetAudience() {
		return targetAudience;
	}

	public WebElement getCampaignStatus() {
		return campaignStatus;
	}

	public WebElement getExpectedCloseDate() {
		return expectedCloseDate;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name="targetAudience")
	private WebElement targetAudience;
	
	@FindBy(name="campaignStatus")
	private WebElement campaignStatus;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expectedCloseDate;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement description;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitBtn;
	
	
}
