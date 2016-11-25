package iOS.Home;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import iOS.IdList;
import iOS.ReUseAction;
import iOS.StringList;
public class HomeNavigation {
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
	@Test (enabled=true, priority=1)
	public void loginFB() throws InterruptedException {
		/*
		LoginViaFB login = LoginViaFB();
		login.loginFB();
		*/
		action.Wait();
		WebElement loginFB = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginFacebook));
		loginFB.click();
		action.Wait();
		System.out.println("Login");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Email atau Telepon"))).sendKeys("dear.ananta@gmail.com");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Kata Sandi Facebook"))).sendKeys("dear.ananta@gmail.com");
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Masuk"))).click();
		action.Wait();
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("OK"))).click();  //oppposite: Cancel
		action.Wait();
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Cancel"))).click();
		//(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Ask me later"))).click();
	}	
	
	@Test (enabled=true, priority=2)
	public void ClosePopUp(){
		System.out.println("Close Pop Up");
		//WebElement cancel=(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Cancel"))).click();;
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.name("Ask me later"))).click();
		action.Wait();
	}
	
	@Test (enabled=true, priority=3)
	public void HomePage(){
		System.out.println("Home Page");
		String actualStr;
		
		WebElement InterestTab = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.InterestTab));
		actualStr=InterestTab.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SInterestTab);
		InterestTab.click();
		
		WebElement ProfileTab = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.ProfileTab));
		actualStr=ProfileTab.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SProfileTab);
		ProfileTab.click();
		
		WebElement ConnectTab = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.ConnectTab));
		actualStr=ConnectTab.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SConnect);	
		ConnectTab.click();
		
		WebElement HomeTab = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.HomeTab));
		actualStr=HomeTab.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SHomeTab);
		HomeTab.click();
	}
	
	@Test(enabled=true, priority=4)
	public void LikeDislike(){
		System.out.println("Like Dislike");
	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.Like)).click();	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.Dislike)).click();
	}
	
	@Test(enabled=true, priority=5)
	public void Profile(){
		//no assertion yet
		System.out.println("Profile");
		System.out.println((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.Name)).getText());
		System.out.println((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LastLogin)).getText());
		System.out.println((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.Age)).getText());
		System.out.println((new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.Occupation)).getText());
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		action.LongWait();
		System.out.println("tearDown system");
		driver.quit();
	}

}
