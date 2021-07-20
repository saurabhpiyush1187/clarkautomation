package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;
import com.util.GlobalConstants;

public class Registration {
	private WebDriver driver;
	private By email=  PropertyReader.getLocator("email","Registration");
	private By password=  PropertyReader.getLocator("password","Registration");
	private By button_registration =  PropertyReader.getLocator("button_registration","Registration");
	private Baseutil utils = new Elementutil();
	
	
	public Registration(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getEmail() {
		return utils.waitForElementPresent(driver, email);
	}


	
	public WebElement getPassword() {
		return utils.waitForElementPresent(driver,password);
	}


	

	public WebElement getButton_registration() {
		return utils.waitForElementPresent(driver,button_registration);
	}

    
	public void doLogin(String username, String password)
	{
		int min = 200;  
		int max = 4000; 
		Integer b = (int)(Math.random()*(max-min+1)+min); 
		String add = b.toString();
		
		String actual_username = username +add+"@mytest.com";
		getEmail().sendKeys(actual_username);
		getPassword().sendKeys(password);
		getButton_registration().click();
		
		
	}
	

	public Personal_details register()
	{	
		String username = GlobalConstants.REG_USERNAME;
		String password = GlobalConstants.REG_PASSWORD;
		doLogin(username, password);
		return new Personal_details(driver);
	}
}
