package iOS.Login;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import iOS.IdList;
import iOS.ReUseAction;
import iOS.StringList;



public class LoginViaFB{
	public WebDriver driver;
	
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
		action.Wait();
		//action.Wait();
		System.out.println("masuk");
		WebElement loginFB = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginFacebook));
		//WebElement loginFB= driver.findElement(id.LoginFacebook);
		//WebElement login = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginFacebook));
		loginFB.click();
		action.Wait();
		System.out.println("MasukFB");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Email atau Telepon"))).sendKeys("dear.ananta@gmail.com");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Kata Sandi Facebook"))).sendKeys("dear.ananta@gmail.com");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Masuk"))).click();
		action.Wait();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("OK"))).click();  //oppposite: Cancel
		action.Wait();
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Cancel"))).click();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Ask me later"))).click();
	}	
	
	@AfterClass
	public void tearDown() throws Exception {
		action.LongWait();
		System.out.println("tearDown system");
		driver.quit();
	}
}
