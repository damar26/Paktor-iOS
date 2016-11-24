package iOS.Login;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import iOS.IdList;
import iOS.ReUseAction;
import iOS.StringList;
import io.appium.java_client.ios.IOSElement;

public class LoginViaPhone {
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
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
		//capabilities.setCapability(CapabilityType.VERSION, "10.1");
		//capabilities.setCapability(CapabilityType.PLATFORM, "iOS");
		//capabilities.setCapability("device", "iPhone 5s");
		capabilities.setCapability("app", "/Users/damarananta/Library/Developer/Xcode/DerivedData/Paktor-blrrravdhtbsevcojsalzwjsfjhe/Build/Products/Debug-iphonesimulator/Paktor.app");
		
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		System.out.println("Setting is OK");
	}

	
	//Test landing page
	@Test (enabled=true, priority=1)
	public void LandingPage() throws InterruptedException {
		action.LongWait();
		String actualStr ="";
		System.out.println("LandingPage");
	
		driver.findElement(id.videoScreen).isDisplayed();
		
		WebElement landingStatic= driver.findElement(id.LandingStatic1);
		landingStatic.isDisplayed();
		actualStr= landingStatic.getText();
		Assert.assertEquals(actualStr, string.SlandingStatic1);
		System.out.println("OK");
		
		WebElement loginFB= driver.findElement(id.LoginFacebook);
		loginFB.isDisplayed();
		loginFB.isEnabled();
		actualStr= loginFB.getText();
		Assert.assertEquals(actualStr, string.SFacebookLogin);
		System.out.println("OK");
		
		WebElement loginPhone= driver.findElement(id.LoginPhone);
		loginPhone.isDisplayed();
		loginPhone.isEnabled();
		actualStr= loginPhone.getText();
		Assert.assertEquals(actualStr, string.SSignupPhone);	
		System.out.println("OK");
	}	
	@Test (enabled=true,priority=2)
	public void LoginPhoneFlow(){
		//WebDriverWait wait = new WebDriverWait(driver,8000);
		System.out.println("LoginPhoneFlow");
		System.out.println(driver.findElement(id.LoginPhone).getClass());
		WebElement login = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginPhone));
		//WebElement login= driver.findElement(LoginPhone);
		login.isDisplayed();
		login.isEnabled();
		login.click();
		action.Wait();
		//press back
		//wait.until(ExpectedConditions.elementToBeClickable(LoginPhone)).click();
		
		System.out.println("back");
		WebElement backButton=(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginPhonePageBack));
		backButton.isEnabled();
		backButton.isDisplayed();
		backButton.click();
		
		action.Wait(); //should be changed to implicit/explicit wait. But currently not working in this version
		action.Wait();
		System.out.println("login again");
		//driver.findElement(LoginPhone).click();
		WebElement loginAgain = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginPhone));
		loginAgain.click();
		action.Wait();
	}
	@Test (enabled=true,priority=3)
	public void LoginViaPhoneWording(){
		System.out.println("LoginViaPhoneWording");
		String actualStr;
		//driver.findElement(LoginPhonePageEnterNumber).sendKeys("12334567899");
		//action.Wait();
		//driver.findElement(LoginPhonePageCountryCode).click();
		//action.Wait();
		System.out.println("masuk");
		
		WebElement enterPhone = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginPhonePageEnterNumber));
		enterPhone.sendKeys("1234567");
		
		//WebDriverWait wait = new WebDriverWait(driver,1000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(Indonesia)).click();
		//driver.findElement(Indonesia).click();
		
		System.out.println("OK");
		
		//check wording
		actualStr=driver.findElement(id.LoginPhonePageHeader).getText();
		//System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SLoginPhonePageHeader);
		
		actualStr=driver.findElement(id.LoginPhonePageContent).getText();
		//System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SLoginPhonePageContent);
		
		actualStr=driver.findElement(id.LoginPhonePageTitle).getText();
		//System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SLoginPhonePageTitle);
		
		actualStr=driver.findElement(id.LoginPhonePageNextButton).getText();
		//System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SLoginPhonePageButton);
		
		
		driver.findElement(id.LoginPhonePageNextButton).click();
		action.Wait();
	}
	
	@Test(enabled=true,priority=4)
	public void WrongPhonePage(){
		action.Wait();
		String actualStr;
		System.out.println("WrongPhonePage");	
		WebElement header = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.EnterPhonePageHeader));
		actualStr=header.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SLoginPhonePageHeader);
		
		WebElement title = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.EnterPhonePageTitle));
		actualStr=title.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SEnterInvPhoneNumber);
		
		WebElement tryAgain = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.EnterPhonePageTryAgainButton));
		actualStr=tryAgain.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SEnterTryAgainButton);
		
		WebElement cancel = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.EnterPhonePageCancelButton));
		actualStr=cancel.getText();
		System.out.println(actualStr);
		Assert.assertEquals(actualStr, string.SEnterCancelButton);	
	}
	
	@Test(enabled=false,priority=5)
	public void RetryAction(){
		System.out.println("RetryAction");
		//should be added as correct phone so we can go to normal flow
		//String actualStr;
		WebElement tryAgain = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.EnterPhonePageTryAgainButton));
		tryAgain.click();
		action.Wait();
		WebElement enterPhone = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginPhonePageEnterNumber));
		enterPhone.isDisplayed();
		enterPhone.click();
		
		for (int i=0; i<7;i++)
				driver.findElement(id.backspace).click();	
		enterPhone.sendKeys("081285202353");
		
		WebElement countryCode = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginPhonePageCountryCode));
		countryCode.isDisplayed();

		countryCode.sendKeys("+62");
		
		IOSElement countryCodecc = (IOSElement) (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.LoginPhonePageCountryCode));
		countryCodecc.getId();	
	}
	
	@Test(enabled=true, priority=6)
	public void goHome(){
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(id.EnterPhonePageCancelButton)).click();
		action.LongWait();
	}
	
	@AfterMethod
	public void delay(){
		//tempOnly	
		//action.Wait();
	}
	@AfterClass
	public void tearDown() throws Exception {
		System.out.println("tearDown system");
		driver.quit();
	}
}
