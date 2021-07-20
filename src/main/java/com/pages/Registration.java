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
	private By buttonRegistration =  PropertyReader.getLocator("button_registration","Registration");
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


	

	public WebElement getButtonRegistration() {
		return utils.waitForElementPresent(driver,buttonRegistration);
	}

    
	public void doLogin(String username, String password)
	{
		int min = 200;  
		int max = 4000; 
		Integer b = (int)(Math.random()*(max-min+1)+min); 
		String add = b.toString();
		
		String actualUsername = username +add+"@mytest.com";
		getEmail().sendKeys(actualUsername);
		getPassword().sendKeys(password);
		getButtonRegistration().click();
		
		
	}
	

	public PersonalDetails register()
	{	
		String username = GlobalConstants.REGUSERNAME;
		String password = GlobalConstants.REGPASSWORD;
		doLogin(username, password);
		return new PersonalDetails(driver);
	}
}
