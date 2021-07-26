package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class OfferRequestPage {

	private WebDriver driver;
	private By getStarted = PropertyReader.getLocator("get_started", "Offer_request");
	private String strPrivathaftpflicht = PropertyReader.getProperty("str_privathaftpflicht", "Offer_request");
	private Baseutil utils = new Elementutil();

	public OfferRequestPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getGetStarted() {
		utils.waitForElementPresent(driver, getStarted);
		return utils.waitForElementToBeClickable(driver, getStarted);

	}

	public YourdataPage selectInsurance(String strInsurance) {
		By locatorPrivathaftpflicht = By.xpath(strPrivathaftpflicht.replaceAll("name", strInsurance));
		WebElement elementPrivathaftpflicht = utils.waitForElementPresent(driver, locatorPrivathaftpflicht);

		if (elementPrivathaftpflicht != null) {
			elementPrivathaftpflicht.click();
		}

		getGetStarted().click();

		return new YourdataPage(driver);
	}

}
