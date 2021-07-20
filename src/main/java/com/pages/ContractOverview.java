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
	
	
	public VerifyContract click_on_overview(String button)
	{	
		By loactor_overview = By.xpath(overview.replaceAll("data", button));
		utils.waitForElementPresent(driver, loactor_overview);
		utils.waitForElementToBeClickable(driver, loactor_overview).click();
		return new VerifyContract(driver);
	}

}
