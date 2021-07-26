package com.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface Baseutil {

	
	public WebElement getElement(WebDriver driver, By locator);

	public void setImplicitWait(WebDriver driver, int waitTime_InSeconds);

	public boolean isTextPresent(WebDriver driver, By by, String text);

	public WebElement waitForElementPresent(WebDriver driver, final By by, int timeOutInSeconds);

	public WebElement waitForElementPresent(WebDriver driver, final By by);

	public WebElement waitForElementToBeClickable(WebDriver driver, final By by);

	public WebElement waitForElementVisibility(WebDriver driver, final By by);

	public WebElement waitForElementVisibility(WebDriver driver, final By by, final int timeOutInseconds);

	public void waitForElementInvisibility(WebDriver driver, final By by);

	public boolean isElementPresent(WebDriver driver, By by, int timeOutInSeconds);

	public boolean isElementPresent(WebDriver driver, By by);

	public List<WebElement> waitForListElementsPresent(WebDriver driver, final By by, int timeOutInSeconds);

	public boolean areElementsPresent(WebDriver driver, By by);

	public Object executeJS(WebDriver driver, String script);
	

}
