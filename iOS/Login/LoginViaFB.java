package iOS.Login;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import iOS.IdList;
import iOS.ReUseAction;
import iOS.StringList;



public class LoginViaFB{
	//Initiate driver
	public WebDriver driver;
	//private AppiumDriver driver;
	//private AppiumDriver driver;
	
	//public MobileDriver driver;
	IdList	id 	= new IdList();
	ReUseAction action 	= new ReUseAction();
	StringList string	= new StringList();

	@BeforeClass
	public void setUp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "iPhone 5s");
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "10.1");
		capabilities.setCapability("app", "/Users/damarananta/Library/Developer/Xcode/DerivedData/Paktor-blrrravdhtbsevcojsalzwjsfjhe/Build/Products/Debug-iphonesimulator/Paktor.app");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("Setting is OK");
	}

	
	//Test landing page
	@Test (enabled=true, priority=1)
	public void loginFB() throws InterruptedException {
		System.out.println("masuk");
		action.LongWait();
		WebElement loginFB= driver.findElement(id.LoginFacebook);
		//WebElement login = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginFacebook));
		loginFB.click();
		action.wait();
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Email atau Telepon"))).sendKeys("ll");;
		//driver.findElement(By.name(name)("Email atau Telepon")).sendKeys("trial");
	}	
	
	@AfterMethod
	public void delay(){

	}
	@AfterClass
	public void tearDown() throws Exception {
		action.LongWait();
		System.out.println("tearDown system");
		driver.quit();
	}
}
