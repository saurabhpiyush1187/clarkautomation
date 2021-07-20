package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class ChooseOption {
	private WebDriver driver;
	
	private String optionHeader = PropertyReader.getProperty("option_header","Choose_option");
	private By buttonFurther = PropertyReader.getLocator("button_further","Choose_option");
	private Baseutil utils = new Elementutil();
	
	public ChooseOption(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getButtonFurther() {
		return utils.waitForElementPresent(driver, buttonFurther);
	}
	
	
	public BankDetails chooseOptions(String startDate, String previousDamage)
	{
		String[] dataHeader = {"Gewünschter Versicherungsbeginn", "Vorschäden"};
		for (String strHeader: dataHeader)
		{
			String 	header = optionHeader.replaceAll("data", strHeader);
			if(strHeader.equalsIgnoreCase("Gewünschter Versicherungsbeginn"))
			{
				By option = By.xpath(header.replaceAll("value", startDate));
				utils.waitForElementPresent(driver, option).click();
			}
			else if(strHeader.equalsIgnoreCase("Vorschäden"))
			{
				By option = By.xpath(header.replaceAll("value", previousDamage));
				utils.executeJS(driver, "window.scrollTo(0, document.body.scrollHeight)");
				utils.waitForElementPresent(driver, option).click();
			}
		}
		
		getButtonFurther().click();
		
		return new BankDetails(driver);
	}

}
