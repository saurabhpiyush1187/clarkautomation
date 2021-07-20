package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class SummaryPage {
	
	private WebDriver driver;
	private By confirmation_msg = PropertyReader.getLocator("confirmation_msg","Summary_page");
	private By completenow = PropertyReader.getLocator("completenow","Summary_page");
	private Baseutil utils = new Elementutil();
	
	
	public WebElement getConfirmation_msg() {
		return utils.waitForElementPresent(driver, confirmation_msg);
	}


	public WebElement getCompletenow() {
		return utils.waitForElementPresent(driver,completenow);
	}



	public SummaryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public boolean verify_summary(List<String> str_message)
	{
		String str_actualmessage = getConfirmation_msg().getText();
		StringBuilder sb = new StringBuilder();
		for (String s : str_message)
		{
		    sb.append(s);
		}

		String expected_message = sb.toString();
		
		if(str_actualmessage.contains(expected_message))
		{
			return true;
		}
		else
		return false;
	}
	
	
	public ContractOverview complete_now()
	{			
		getCompletenow().click();		
		return new ContractOverview(driver);
	}
}
