package BaseClass;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import PageObjectModel.HomePage;
import PageObjectModel.LoginPage;
import PropertiesFileUtility.PropertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public WebDriver driver=null;
	public static WebDriver sdriver=null;
	public PropertiesUtility putil = new PropertiesUtility();
	
	@BeforeSuite(groups = {"Smoke","Regression"})
	public void beforeSuite() {
		
		Reporter.log("Before Suite", true);
	}
	
	@AfterSuite(groups = {"Smoke","Regression"})
	public void afterSuite() {
		Reporter.log("After SUite", true);
	}
	
	@BeforeTest(groups = {"Smoke","Regression"})
	public void beforeTest() {
		Reporter.log("Preconditions");
	}
	
	@AfterTest(groups = {"Smoke","Regression"})
	public void afterTest() {
		Reporter.log("Post Conditions");
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups = {"Smoke","Regression"})
	public void beforeClass() throws IOException {

		
	String browser=putil.getDataFromPropertiesFile("browser");
	if(browser.equalsIgnoreCase("edge")) {
		WebDriverManager.edgedriver().setup();
		   // Load msedgedriver.exe from resources folder
		  URL resource = getClass().getClassLoader().getResource("msedgedriver.exe");
		    if (resource == null) {
		        throw new RuntimeException("msedgedriver.exe not found in resources folder!");
		    }
		    
		    File driverFile = new File(resource.getFile());
		    String driverPath = driverFile.getAbsolutePath();

		    System.setProperty("webdriver.edge.driver", driverPath);
		    driver = new EdgeDriver();
	} else 	if(browser.equals("chrome")) {
		driver=new ChromeDriver();
		
	}else 	if(browser.equals("firefox")) {
		driver=new FirefoxDriver();
		
	}
	sdriver=driver;
	
	System.out.println("Launch Browser");
	driver.manage().window().maximize();
		
	}
	
	@BeforeMethod(groups = {"Smoke","Regression"})
	public void beforeMethod() throws IOException {
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");

		    driver.get(url);
		    LoginPage lp = new LoginPage(driver);
		    lp.getUN().sendKeys(username);
		    lp.getPassword().sendKeys(password);
		    lp.submitBtn().click();
		    System.out.println("Login Completed");

		
	}
	

@AfterMethod(groups = {"Smoke","Regression"})
public void afterMethod() {
	
	HomePage hutil= new HomePage(driver);
	hutil.getUserLogo().click();
	hutil.getLogout().click();
	
}
@AfterClass(groups = {"Smoke","Regression"})
public void afterClass() throws IOException {

	
	System.out.println("Closing Browser");
	driver.quit();
		
	}
	
	
}

	

