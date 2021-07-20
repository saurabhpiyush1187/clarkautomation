package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class Recommended_plan{
	
	private WebDriver driver;
	private String str_completenow = PropertyReader.getProperty("str_completenow","Recommended_plan");
	private Baseutil utils = new Elementutil();

	public Recommended_plan(WebDriver driver) {
		this.driver=driver;
	}

	
	public Registration click_complete(String str_complete)
	{   
		By locator_completenow = By.xpath(str_completenow.replaceAll("data", str_complete));
		WebElement element_completenow = utils.waitForElementPresent(driver, locator_completenow);
		
		if(element_completenow!=null)
		{
			element_completenow.click();
		}
		return new Registration(driver);
	}
}
