package com.crm.comcast.genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author 91636
 *
 */
public class WebDriverUtility 
{
/**
 * it will wait for 10 seconds till the page gets loaded
 * @param driver
 */
public void waitForPageToLoad(WebDriver driver) 
{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
}
/**
 * it will wait for js element
 * @param driver
 */
public void waitForPageToLoadJSElement(WebDriver driver) 
{
		driver.manage().timeouts().setScriptTimeout(50, TimeUnit.SECONDS);
		
}
/**
 * it will check for the element in the GUI for polling time of 500ms
 * @param driver
 * @param elememt
 */
public void waitForElementToBeClickable(WebDriver driver,WebElement elememt) 
{
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(elememt));	
}
/**
 *  it will check for the title in the GUI for polling time of 500ms
 * @param driver
 * @param title
 */
public void waitForTitleContains(WebDriver driver,String title) 
{
		WebDriverWait wait =new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains(title));	
}
/**
 * here we can change the polling time from default 500ms to any polling time
 * @param driver
 * @param pollingTime
 * @param elememt
 */
public void waitForElementToCustom(WebDriver driver, int pollingTime,WebElement elememt ) 
{
		FluentWait wait= new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(elememt));	
}
/**
 * here we are giving custom timeout
 * @param elememt
 * @throws InterruptedException
 */
public void waitAndClick(WebElement elememt) throws InterruptedException 
{
		int count=0;
		while(count<10)
		{
		
			try {
				elememt.click();
			}
			catch (Exception e) {
				Thread.sleep(1000);
				count++;
			}
			}
		}

/**
 * used to switch from one window to another window
 * @param driver
 * @param partialWindow
 */
public void switchTOWindow(WebDriver driver, String partialWindow)
{
	Set<String> set = driver.getWindowHandles();
	Iterator<String> it = set.iterator();
	while(it.hasNext())
	{
		String wTle = it.next();
		driver.switchTo().window(wTle);
		String currentWindow = driver.getTitle();
		if(currentWindow.contains(partialWindow))
		{
			break;
		}
	}
}

public void switchToWindow1(WebDriver driver)
{
	String parentWindow = driver.getWindowHandle();
	System.out.println("parentWindow"+ parentWindow );
	Set<String> handles = driver.getWindowHandles();
	for (String ChildWindow : handles)
	{
		System.out.println(ChildWindow);
		if (!ChildWindow.equals(parentWindow)) 	
		{
			driver.switchTo().window(ChildWindow);
		//driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		}
	}
	//driver.switchTo().window(parentWindow);
}

public void switchToParentWindow(WebDriver driver)
{
	String parentWindow = driver.getWindowHandle();

	driver.switchTo().window(parentWindow);
}
/**
 * used to switch from one frame to another frame by using index
 * @param driver
 * @param index
 */
public void switchToFrame(WebDriver driver,int index) 
{
		driver.switchTo().frame(index);
		
}
/**
 * used to switch from one frame to another frame by using id_attribute 
 * @param driver
 * @param id_attribute
 */
public void switchToFrame(WebDriver driver,String id_attribute) 
{
		driver.switchTo().frame(id_attribute);
}
/**
 *  used to switch from one frame to another frame by using absolute_path
 * @param driver
 * @param element
 */
public void switchToFrame(WebDriver driver,WebElement element) 
{
		driver.switchTo().frame(element);
		
}
/**
 *  used to switch back from one child to parent farme
 * @param driver
 */
public void switchBackToMainPage(WebDriver driver) 
{
		driver.switchTo().defaultContent();
		
}
/**
 *  used to switch to alert popup and accept
 * @param driver
 */
public void switchToAlertPopupWindowAndAccept(WebDriver driver) 
{
		driver.switchTo().alert().accept();
		
}
/**
 *used to switch to alert popup and dismiss
 * @param driver
 */
public void switchToAlertPopupAndDismiss(WebDriver driver) 
{
		driver.switchTo().alert().dismiss();
		
}
/**
 * used to switch to select dropdown by using index
 * @param element
 * @param index
 */
public void selectDropDown(WebElement element,int index) 
{
		Select select= new Select(element);
		select.selectByIndex(index);	
}
/**
 * used to switch to select dropdown by using value
 * @param element
 * @param value
 */
public void selectDropDown(WebElement element,String value) 
{
		Select select= new Select(element);
		select.selectByValue(value);	
}
/**
 * used to switch to select dropdown by using visible_text
 * @param element
 * @param visible_text
 */
public void selectDropDownByVissibleText(WebElement element,String visible_text) 
{
		Select select= new Select(element);
		select.selectByVisibleText(visible_text);	
}
/**
 * it is usde to mouse over an action
 * @param driver
 * @param element.
 */
/*public void mouseOverAnElement(WebDriver driver,WebElement element) 
{
		Actions act=new Actions(driver);
		act.moveToElement(element);
}*/

public void mouseOverAnElement(WebDriver driver, WebElement element) 
{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
}

/**
 * it is usde to right click on element
 * @param driver
 * @param element
 */
public void rightClickOnElement(WebDriver driver,WebElement element) 
{
	
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
}
/**
 * it is usde to click on enter button using keyboard actions
 * @param driver
 */
public void ClickOnEnterButton(WebDriver driver) 
{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
}
/**
 * it is used to take screenshot
 * @param driver
 * @param screenShotName
 * @return 
 * @throws IOException
 */
public static String takeScreenShot(WebDriver driver, String screenShotName) throws IOException 
{
		TakesScreenshot takescreenshot=  (TakesScreenshot)driver;
		File src = takescreenshot.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenshot/"+screenShotName+"PNG");
		Files.copy(src, dst);
		return screenShotName;		
}



/**
 * it is used to perform scroll Actions
 * @param driver
 */

public void scrollBarAction(WebDriver driver)
{
		JavascriptExecutor javascript= (JavascriptExecutor)driver;
		javascript.executeScript("window.scrollBy(0,500)");
}

public void scrollIntoView(WebDriver driver, WebElement ele)
{
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele);
}
}
