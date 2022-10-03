package com.crm.comcast.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 

{
	public static WebDriver sdriver;

	public WebDriver driver;
	
	public WebDriverUtility WLib=new WebDriverUtility();
	public ExcelUtility ELib=new ExcelUtility();
	public JavaUtility JLib=new JavaUtility();
	public FileUtility FLib=new FileUtility();
	public DataBaseUtility DLib=new DataBaseUtility();
	
	/**
	 * data base connection
	 */	
@BeforeSuite(groups= {"smokeTest","regressionTest"})

public void dbconfig()
{
	DLib.ConnectToDb();
	
}

/**
 * Launching the browser
 * @throws Throwable 
 */

@Parameters("BROWSER")
@BeforeClass(groups= {"smokeTest","regressionTest"})

public void launchTheBrowser(String BROWSER) throws Throwable
{
	//String BROWSER = FLib.getPropertyKeyValue("browser");
	String URL = FLib.getPropertyKeyValue("url");
	if (BROWSER.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}else if (BROWSER.equalsIgnoreCase("firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
		}else {
			 
			driver=new ChromeDriver();	
		}
	WLib.waitForPageToLoad(driver);
	
	driver.get(URL);
	
	driver.manage().window().maximize();
	
}

/**
 * Login to application
 * @throws Throwable 
 */
@BeforeMethod(groups= {"smokeTest","regressionTest"})

public void LoginToApp() throws Throwable

{

	
}

/**
 * Logout to application
 */

@AfterMethod(groups= {"smokeTest","regressionTest"})

public void LogoutToApp() throws Throwable

{

/*HomePage hp=new HomePage(driver);
hp.SignOut(driver);*/
}

/**
 * Close the browser
 */

@AfterClass(groups= {"smokeTest","regressionTest"})

public void CloseTheBrowser() throws Throwable

{

driver.quit();

}

/**
 * close db connection
 */

@AfterSuite(groups= {"smokeTest","regressionTest"})

public void CloseDb()
{
	DLib.CloseDb();
	
}

}
