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
	private By confirmationMsg = PropertyReader.getLocator("confirmation_msg","Summary_page");
	private By completenow = PropertyReader.getLocator("completenow","Summary_page");
	private Baseutil utils = new Elementutil();
	
	
	public WebElement getConfirmationMsg() {
		return utils.waitForElementPresent(driver, confirmationMsg);
	}


	public WebElement getCompletenow() {
		return utils.waitForElementPresent(driver,completenow);
	}



	public SummaryPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public boolean verifySummary(List<String> strMessage)
	{
		String strActualMessage = getConfirmationMsg().getText();
		StringBuilder sb = new StringBuilder();
		for (String s : strMessage)
		{
		    sb.append(s);
		}

		String expectedMessage = sb.toString();
		
		if(strActualMessage.contains(expectedMessage))
		{
			return true;
		}
		else
		return false;
	}
	
	
	public ContractOverviewPage completeNow()
	{			
		getCompletenow().click();		
		return new ContractOverviewPage(driver);
	}
}
