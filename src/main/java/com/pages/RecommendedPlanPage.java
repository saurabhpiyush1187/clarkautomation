package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;

public class RecommendedPlanPage {

	private WebDriver driver;
	private String strCompletenow = PropertyReader.getProperty("str_completenow", "Recommended_plan");
	private Baseutil utils = new Elementutil();

	public RecommendedPlanPage(WebDriver driver) {
		this.driver = driver;
	}

	public RegistrationPage clickComplete(String strComplete) {
		By locatorCompletenow = By.xpath(strCompletenow.replaceAll("data", strComplete));
		WebElement element_completenow = utils.waitForElementPresent(driver, locatorCompletenow);

		if (element_completenow != null) {
			element_completenow.click();
		}
		return new RegistrationPage(driver);
	}
}
