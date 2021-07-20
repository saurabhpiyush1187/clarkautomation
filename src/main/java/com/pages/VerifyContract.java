package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class VerifyContract{
	private WebDriver driver;
	private By popup = PropertyReader.getLocator("popup","Verify_contract");
	private By closePopUp = PropertyReader.getLocator("close_pop_up","Verify_contract");
	private By offerVerify = PropertyReader.getLocator("offer_verify","Verify_contract");
	private Baseutil utils = new Elementutil();
	
	public VerifyContract(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPopup() {
		return utils.waitForElementPresent( driver,popup);
	}



	public WebElement getClosePopUp() {
		return utils.waitForElementPresent( driver,closePopUp);
	}



	public WebElement getOfferVerify() {
		return utils.waitForElementPresent( driver,offerVerify);
	}

	
	public boolean verifyContract(String url)
	{	
		getPopup().click();
		getClosePopUp().click();
		
		String actualUrl = driver.getCurrentUrl();
		if(getOfferVerify() !=null && actualUrl.contains(url))
			return true;
		else
			return false;
		
	}
}
