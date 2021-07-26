package com.pages;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Clarkutil;
import com.util.Elementutil;


public class PersonalDetailsPage{

	private WebDriver driver;
	private Clarkutil clarkUtil;
	private By buttonFurther =  PropertyReader.getLocator("button_further","Personal_details");
	private Baseutil utils = new Elementutil();
	
	
	public PersonalDetailsPage(WebDriver driver) {

		this.driver=driver;
		clarkUtil = new Clarkutil(driver);
	}


	public WebElement getButtonFurther() {
		return utils.waitForElementPresent(driver,buttonFurther);
	}

	
	
	
	
	public ChooseOptionPage fillData(List<Map<String, String>> regList)
	{
		clarkUtil.enterRegDetails(regList);
		getButtonFurther().click();
		return new ChooseOptionPage(driver);
	}
		
	}
	

	
