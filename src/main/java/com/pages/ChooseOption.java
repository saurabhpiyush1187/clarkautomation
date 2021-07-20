package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class ChooseOption {
	private WebDriver driver;
	
	private String option_header = PropertyReader.getProperty("option_header","Choose_option");
	private By button_further = PropertyReader.getLocator("button_further","Choose_option");
	private Baseutil utils = new Elementutil();
	
	public ChooseOption(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getButton_further() {
		return utils.waitForElementPresent(driver, button_further);
	}
	
	
	public BankDetails choose_options(String startdate, String previous_damage)
	{
		String[] data_header = {"Gewünschter Versicherungsbeginn", "Vorschäden"};
		for (String str_header: data_header)
		{
			String 	header = option_header.replaceAll("data", str_header);
			if(str_header.equalsIgnoreCase("Gewünschter Versicherungsbeginn"))
			{
				By option = By.xpath(header.replaceAll("value", startdate));
				utils.waitForElementPresent(driver, option).click();
			}
			else if(str_header.equalsIgnoreCase("Vorschäden"))
			{
				By option = By.xpath(header.replaceAll("value", previous_damage));
				utils.executeJS(driver, "window.scrollTo(0, document.body.scrollHeight)");
				utils.waitForElementPresent(driver, option).click();
			}
		}
		
		getButton_further().click();
		
		return new BankDetails(driver);
	}

}
