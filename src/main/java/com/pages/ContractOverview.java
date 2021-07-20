package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class ContractOverview {
	
	private WebDriver driver;
	private String overview= PropertyReader.getProperty("overview","ContractOverview");
	private Baseutil utils = new Elementutil();
	public ContractOverview(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public VerifyContract clickOnOverview(String button)
	{	
		By loactorOverview = By.xpath(overview.replaceAll("data", button));
		utils.waitForElementPresent(driver, loactorOverview);
		utils.waitForElementToBeClickable(driver, loactorOverview).click();
		return new VerifyContract(driver);
	}

}
