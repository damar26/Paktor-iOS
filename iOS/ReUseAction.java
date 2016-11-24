package iOS;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSElement;

public class ReUseAction {
	protected WebDriver driver;

    public void commonLayer(WebDriver driver) {
        this.driver = driver;
    }
    protected void waitForVisibilityOf(By locator) {
    	System.out.println("explisit wait");
        WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void waitForClickabilityOf(By locator) {
    	System.out.println("explisit wait");
    	WebDriverWait wait = new WebDriverWait(driver, 3000);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
	public void swipe() throws InterruptedException {	
		//not working for APPIUM 1.6
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		swipeObject.put("startX", (double) 500);
		swipeObject.put("startY", (double) 200);
		swipeObject.put("endX", (double) 100);
		swipeObject.put("endY", (double) 200);
		swipeObject.put("duration", 1.8);
		js.executeScript("mobile: swipe", swipeObject);
		//(JavascriptExecutor)wd.executeScript("mobile: swipe", new HashMap<String, Double>() {{ put("touchCount", 1); put("startX", 1110); put("startY", 780); put("endX", 110); put("endY", 792); put("duration", 0.5); }});
    }
	
	public void swipe_() throws Exception
	{
		//not working for APPIUM 1.6
		TouchAction xxxx = new TouchAction((MobileDriver) driver);
		//((AppiumDriver) driver).swipe(75, 500, 75, 0, (int) 0.8);
		((TouchAction) xxxx).press(0, 0).perform();		
	}

	public IOSElement swipe__(By Locator){
		//not working for APPIUM 1.6
		WebDriverWait wait = new WebDriverWait(driver,1000);
		return (IOSElement)wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));
		//driver.findElement(videoScreen).getLocation().move(50, 0);
	}
	
	public void CustomImpicitWait(By locator) throws Exception{
        for(int i=0;i<60;i++){
            try{
                driver.findElement(locator).isDisplayed();
                break;
            }catch(Exception e){Thread.sleep(1000);
            	//nothing
            }   
        }
	}
	
    public void Wait() {
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

    }
    public void LongWait() {
    	try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

}
