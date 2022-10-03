package com.CodingTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.crm.comcast.ObjectRepository.Imdb;
import com.crm.comcast.ObjectRepository.wiki;
import com.crm.comcast.genericUtilities.WebDriverUtility;

public class MovieInformationTest {
	
	public WebDriver driver=null;

	WebDriverUtility WLib = new WebDriverUtility();
	public static final String USERNAME = "shrishylal_Qz2wFG";
	public static final String AUTOMATE_KEY = "BoMj8UwcFZzsNiT5GeLJ";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	@BeforeClass
	
	public void setUp() throws  MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("os", "Windows");
		caps.setCapability("os_version", "10");
		caps.setCapability("browser", "Chrome");
		caps.setCapability("browser_version", "64.0");
		driver = new RemoteWebDriver(new URL(URL), caps);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	@Test
	public void CountryName() throws InterruptedException {

		
		driver.get("https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0");

		Imdb im = new Imdb(driver);
		WebElement releaseDate = im.getReleaseDate();
		WLib.scrollIntoView(driver, releaseDate);

		Thread.sleep(1000);

		WebElement ImdbCountryName = im.getImdbcountryName();
		String imdBCountryName = ImdbCountryName.getText();
		System.out.println(imdBCountryName);
		

		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		wiki wk = new wiki(driver);
		WebElement wikiReleaseDate = wk.getReleaseDate();
		WLib.scrollIntoView(driver, wikiReleaseDate);

		Thread.sleep(1000);

		WebElement WikiCountryName = wk.getWikiCountryName();
		String wikiCountryNAme = WikiCountryName.getText();
		System.out.println(wikiCountryNAme);
		
		Assert.assertEquals(imdBCountryName, wikiCountryNAme, "Country name are not matching");
		Thread.sleep(1000);
		

	}
	
	@Test
	public void ReleaseDate() throws InterruptedException {

		
		driver.get("https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0");

		Imdb im = new Imdb(driver);
		WebElement releaseDate = im.getReleaseDate();
		WLib.scrollIntoView(driver, releaseDate);
		String ImdbreleaseDate = releaseDate.getText();
		System.out.println(ImdbreleaseDate);

		

		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		wiki wk = new wiki(driver);
		WebElement wikiReleaseDate = wk.getReleaseDate();
		WLib.scrollIntoView(driver, wikiReleaseDate);
		String WikireleaseDate = wikiReleaseDate.getText();
		System.out.println(WikireleaseDate);

		Assert.assertEquals(wikiReleaseDate, ImdbreleaseDate, "Release Date are not matching");

		driver.quit();

	}

}
