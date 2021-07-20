package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class Yourdata_page {
	
	private WebDriver driver;
	private By page_header = PropertyReader.getLocator("page_header","Yourdata_page");
	private By button_showtop = PropertyReader.getLocator("button_showtop","Yourdata_page");
	private By to_offer = PropertyReader.getLocator("to_offer","Yourdata_page");
	private String str_data = PropertyReader.getProperty("str_data","Yourdata_page");
	private Baseutil utils = new Elementutil();
	
	public Yourdata_page(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getPage_header() {
		return utils.waitForElementPresent(driver,page_header);
	}


	public WebElement getButton_showtop() {
		return utils.waitForElementPresent( driver,button_showtop);
	}

	
	public WebElement getTo_offer() {
		return utils.waitForElementPresent( driver,to_offer,40);
	}

	public boolean verify_default_data(List<String> data_given)
	{	
		getPage_header();
		List<String> actualdata = new ArrayList<String>();
		String[] data_header = {"Familienstatus", "im öffentlichen Dienst beschäftigt", "in Rente","Selbstbeteiligung"};
		for (String str_header: data_header)
		{
			By locator_data = By.xpath(str_data.replaceAll("data", str_header));
			actualdata.add(utils.waitForElementPresent(driver, locator_data).getText());			
		}
		
		if(actualdata.containsAll(data_given))
			return true;
		else
			return false;
		
	}
	
	
	
	public Recommended_plan click_showtop()
	{	
		getButton_showtop().click();
		getTo_offer().click();
		return new Recommended_plan(driver);
	}
	
}
