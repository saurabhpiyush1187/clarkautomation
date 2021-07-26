package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.Baseutil;
import com.util.Clarkutil;
import com.util.Elementutil;
import com.util.GlobalConstants;
import com.util.PropertyReader;

public class RegistrationPage {
	private WebDriver driver;
	private Clarkutil clarkUtil;
	private Baseutil utils = new Elementutil();
	private By buttonRegistration = PropertyReader.getLocator("button_registration", "Registration");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		clarkUtil = new Clarkutil(driver);
	}

	public WebElement getButtonRegistration() {
		return utils.waitForElementPresent(driver, buttonRegistration);
	}

	public PersonalDetailsPage register() {
		String username = GlobalConstants.REGUSERNAME;
		String password = GlobalConstants.REGPASSWORD;
		clarkUtil.doLogin(username, password);
		getButtonRegistration().click();
		return new PersonalDetailsPage(driver);
	}
}
