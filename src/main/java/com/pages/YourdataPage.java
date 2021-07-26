package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class YourdataPage {
	
	private WebDriver driver;
	private By pageHeader = PropertyReader.getLocator("page_header","Yourdata_page");
	private By buttonShowtop = PropertyReader.getLocator("button_showtop","Yourdata_page");
	private By toOffer = PropertyReader.getLocator("to_offer","Yourdata_page");
	private String strData = PropertyReader.getProperty("str_data","Yourdata_page");
	private Baseutil utils = new Elementutil();
	
	public YourdataPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPageHeader() {
		return utils.waitForElementPresent(driver,pageHeader);
	}


	public WebElement getButtonShowtop() {
		return utils.waitForElementPresent( driver,buttonShowtop);
	}

	
	public WebElement getToOffer() {
		return utils.waitForElementPresent( driver,toOffer,40);
	}

	public boolean verify_default_data(List<Map<String, String>> credList)
	{	
		getPageHeader();
		List<String> dataoptions = new ArrayList<String>();
		dataoptions.add(credList.get(0).get("Familienstatus"));
		dataoptions.add(credList.get(0).get("im öffentlichen Dienst beschäftigt"));
		dataoptions.add(credList.get(0).get("in Rente"));
		dataoptions.add(credList.get(0).get("Selbstbeteiligung"));
		
		
		List<String> actualdata = new ArrayList<String>();
		String[] dataHeader = dataoptions.toArray(new String[0]);
		for (String strHeader: dataHeader)
		{
			By locatorData = By.xpath(strData.replaceAll("data", strHeader));
			actualdata.add(utils.waitForElementPresent(driver, locatorData).getText());			
		}
		
		if(actualdata.containsAll(dataoptions))
			return true;
		else
			return false;
		
	}
	
	
	
	public RecommendedPlanPage click_showtop()
	{	
		getButtonShowtop().click();
		getToOffer().click();
		return new RecommendedPlanPage(driver);
	}
	
}
