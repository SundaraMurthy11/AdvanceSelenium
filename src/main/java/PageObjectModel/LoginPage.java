package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	public LoginPage(WebDriver driver){
		this.driver=driver;
	PageFactory.initElements(driver, this);
	
	}
	@FindBy(id="username")
	private WebElement UN;
	
	@FindBy(id="inputPassword")
	private WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement signInBtn;
	
	public WebElement getUN() {
		return UN;
	}
	
	public WebElement getPassword() {
		
		return password;
	}
	public WebElement submitBtn() {
		return signInBtn;
	}
	
}
