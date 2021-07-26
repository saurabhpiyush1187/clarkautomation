package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class BankDetailsPage  {
	
	private WebDriver driver;
	private By bankTextbox =  PropertyReader.getLocator("bank_textbox","Bank_details");
	private By checkBox =  PropertyReader.getLocator("check_box","Bank_details");
	private By buttonFurther =  PropertyReader.getLocator("button_further","Bank_details");
	
	private Baseutil utils = new Elementutil();
	
	public BankDetailsPage(WebDriver driver) {
		this.driver=driver;
	}

	
	public WebElement getBankTextbox() {
		return utils.waitForElementPresent(driver,bankTextbox);
	}


	public WebElement getCheckBox() {
		return utils.waitForElementPresent(driver,checkBox);
	}



	public WebElement getButtonFurther() {
		return utils.waitForElementPresent( driver,buttonFurther);
	}

	
	public SummaryPage enterbankDetails(String strBank)
	{	
		getBankTextbox().sendKeys(strBank);
		getCheckBox().click();
		getButtonFurther().click();
		return new SummaryPage(driver);
	}
	
}
