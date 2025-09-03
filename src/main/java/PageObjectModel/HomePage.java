package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[text()='Campaigns']")
	private WebElement campaign;
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastMessage;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closeToast;
	
	public WebElement closeToast() {
		return closeToast;
	}
	
	public WebElement toastMessage() {
		return toastMessage;
	}
	
	
	
	public WebElement getCampaign() {
		return campaign;
	}

	public WebElement getProduct() {
		return product;
	}

	public WebElement getUserLogo() {
		return userLogo;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getCreateCampaign() {
		return createCampaign;
	}

	public WebElement getAddProducts() {
		return addProducts;
	}

	@FindBy(xpath="//a[text()='Products']")
	private WebElement product;
	
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement userLogo;
	
	@FindBy(xpath="//div[text()='Logout ']")
	private WebElement logout;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement createCampaign;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement addProducts;
	
	
	
	
}
