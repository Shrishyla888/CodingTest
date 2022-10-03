# CodingTest

selenium-testng-framework
---

A sample framework based on Page Object Model, Selenium, TestNG using Java.

This framework is based in **Page Object Model (POM).**

The framework uses:

1. Java
2. Selenium
3. TestNG
4. Emailable html report

Steps to create test cases:
----
Let's say we want to automate Imdb website test.  

1.Create Imdb Page in **pages**  object repository package.  
  A page class typically should contain all the elements that are present on the page and corresponding action methods.
  
  ```
  public class Imdb {

	@FindBy(xpath = "//a[.='December 17, 2021 (United States)']")
	private WebElement ReleaseDate;

	@FindBy(xpath = "//a[.='India']")
	private WebElement ImdbcountryName;

	public Imdb(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public WebElement getReleaseDate() {
		return ReleaseDate;
	}

	public WebElement getImdbcountryName() {
		return ImdbcountryName;
	}

}


```
2.Create Wikipedia Page in **pages**  object repository package as same as above(Imdb)

3.Create the test class which class the methods of Imdb and wikipedia pages

4. Create two methoods for country name and release date validation

```
@Test
	public void CountryName() throws InterruptedException {

		try {
		driver.get("https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0");

		Imdb im = new Imdb(driver);
		WebElement releaseDate = im.getReleaseDate();
		WLib.scrollIntoView(driver, releaseDate);

		WebElement ImdbCountryName = im.getImdbcountryName();
		String imdBCountryName = ImdbCountryName.getText();
		System.out.println(imdBCountryName);
		

		driver.get("https://en.wikipedia.org/wiki/Pushpa:_The_Rise");
		wiki wk = new wiki(driver);
		WebElement wikiReleaseDate = wk.getReleaseDate();
		WLib.scrollIntoView(driver, wikiReleaseDate);

		WebElement WikiCountryName = wk.getWikiCountryName();
		String wikiCountryNAme = WikiCountryName.getText();
		System.out.println(wikiCountryNAme);
		
		Assert.assertEquals(imdBCountryName, wikiCountryNAme, "Country name are not matching");
		Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void ReleaseDate() throws InterruptedException {
		
		try {
			
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
		
		} catch (Exception e) {
			e.printStackTrace();
		}
}
```
3.Add the test class in testng.xml file under the folder `src/test/resources/suites/`

```
<suite name="Suite">
  <test thread-count="5" name="Test">
    <classes>
      <class name="com.CodingTest.MovieInformationTest"/>
    </classes>
  </test> <!-- Test -->
</suite> <!-- Suite -->
```
4.Execute the test cases by maven command `mvn clean test`

---

Reproting
---
The framework gives report in two ways,

1. A html report - Which is generated using extent reports, under the folder `ExtentReports`.
2. A mail report - For which the toggle `mail.sendmail` in `test.properties` should be set `true`. And all the properties such as `smtp host, port, proxy details, etc.,` should be provided correctly.

---

Key Points:
---

1. The class `WebDriverContext` is responsible for maintaining the same WebDriver instance throughout the test. So whenever you require a webdriver instance which has been using for current test (In current thread) always call `WebDriverContext.getDriver()`.
2. Always use `PageFactory.initElements` to get the instance of particular Page Object. (Of course you can use `new` but it's better use a single approach across the framework.
