package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Clarkutil;
import com.util.Elementutil;

public class ChooseOptionPage {
	private WebDriver driver;
	private Clarkutil clarkUtil;
	private By buttonFurther = PropertyReader.getLocator("button_further","Choose_option");
	private Baseutil utils = new Elementutil();
	
	public ChooseOptionPage(WebDriver driver) {
		this.driver=driver;
		clarkUtil = new Clarkutil(driver);
	}
	
	
	public WebElement getButtonFurther() {
		return utils.waitForElementPresent(driver, buttonFurther);
	}
	
	
	public BankDetailsPage chooseOptions(String startDate, String previousDamage)
	{
		clarkUtil.chooseOptions(startDate, previousDamage);		
		getButtonFurther().click();		
		return new BankDetailsPage(driver);
	}

}
