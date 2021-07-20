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
	private By close_pop_up = PropertyReader.getLocator("close_pop_up","Verify_contract");
	private By offer_verify = PropertyReader.getLocator("offer_verify","Verify_contract");
	private Baseutil utils = new Elementutil();
	
	public VerifyContract(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPopup() {
		return utils.waitForElementPresent( driver,popup);
	}



	public WebElement getClose_pop_up() {
		return utils.waitForElementPresent( driver,close_pop_up);
	}



	public WebElement getOffer_verify() {
		return utils.waitForElementPresent( driver,offer_verify);
	}

	
	public boolean verify_contract(String url)
	{	
		getPopup().click();
		getClose_pop_up().click();
		
		String actual_url = driver.getCurrentUrl();
		if(getOffer_verify() !=null && actual_url.contains(url))
			return true;
		else
			return false;
		
	}
}
