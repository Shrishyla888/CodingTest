package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class wiki {
	
	@FindBy(xpath = "//div[@class=\"plainlist\" and contains(.,'1')]")
	private WebElement wikiReleaseDate;
	
	@FindBy(xpath = "//td[.='India']")
	private WebElement WikiCountryName;
	
	public wiki(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getReleaseDate() {
		return wikiReleaseDate;
	}


	public WebElement getWikiCountryName() {
		return WikiCountryName;
	}
	
	

}
