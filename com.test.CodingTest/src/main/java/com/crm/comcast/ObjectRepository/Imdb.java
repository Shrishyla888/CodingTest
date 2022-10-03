package com.crm.comcast.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Imdb {
	
	@FindBy(xpath = "//a[.='December 17, 2021 (United States)']")
	private WebElement ReleaseDate;
	
	@FindBy(xpath = "//a[.='India']")
	private WebElement ImdbcountryName;
	
	public Imdb(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}


	public WebElement getReleaseDate() {
		return ReleaseDate;
	}


	public WebElement getImdbcountryName() {
		return ImdbcountryName;
	}
	
	
	
	
	
}
