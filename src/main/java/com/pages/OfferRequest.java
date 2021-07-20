package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class OfferRequest{
	
	private WebDriver driver;
	private By get_started= PropertyReader.getLocator("get_started","Offer_request");
	private String str_privathaftpflicht = PropertyReader.getProperty("str_privathaftpflicht","Offer_request");
	private Baseutil utils = new Elementutil();
	
	public OfferRequest(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getGet_started() {
		utils.waitForElementPresent( driver,get_started);
		return utils.waitForElementToBeClickable(driver,get_started);
		
	}
	
	
	public Yourdata_page select_insurance(String str_insurance)
	{
		By locator_privathaftpflicht = By.xpath(str_privathaftpflicht.replaceAll("name", str_insurance));
		WebElement element_privathaftpflicht = utils.waitForElementPresent(driver,locator_privathaftpflicht);
		
		if(element_privathaftpflicht!=null)
		{
			element_privathaftpflicht.click();
		}
		
		getGet_started().click();
		
		return new Yourdata_page(driver);
	}
	
	
	}


