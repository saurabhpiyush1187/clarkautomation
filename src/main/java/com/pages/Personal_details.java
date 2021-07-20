package com.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;


public class Personal_details{

	private WebDriver driver;
	private By button_further =  PropertyReader.getLocator("button_further","Personal_details");
	private String radio_salutation= PropertyReader.getProperty("radio_salutation","Personal_details");
	private String textbox_entry= PropertyReader.getProperty("textbox_entry","Personal_details");
	private Baseutil utils = new Elementutil();
	
	
	public Personal_details(WebDriver driver) {

		this.driver=driver;
	}


	public WebElement getButton_further() {
		return utils.waitForElementPresent(driver,button_further);
	}

	
	public WebElement firstname() {
		By locator_firstname = By.xpath(textbox_entry.replaceAll("field", "Vorname"));
		return utils.waitForElementPresent(driver, locator_firstname);
		
	}
	
	
	public WebElement lastname() {
		By locator_lastname = By.xpath(textbox_entry.replaceAll("field", "Nachname"));
		return utils.waitForElementPresent(driver, locator_lastname);
		
	}
	
	public WebElement dob() {
		By locator_dob = By.xpath(textbox_entry.replaceAll("field", "Geburtsdatum"));
		return utils.waitForElementPresent( driver,locator_dob);
		
	}
	public WebElement street() {
		By locator_street = By.xpath(textbox_entry.replaceAll("field", "Straße"));
		return utils.waitForElementPresent( driver,locator_street);
		
	}
	
	public WebElement house() {
		By locator_house = By.xpath(textbox_entry.replaceAll("field", "Hausnr."));
		return utils.waitForElementPresent(driver, locator_house);
		
	}
	
	public WebElement pin() {
		By locator_pin = By.xpath(textbox_entry.replaceAll("field", "PLZ"));
		return utils.waitForElementPresent( driver,locator_pin);
		
	}
	
	public WebElement place() {
		By locator_place = By.xpath(textbox_entry.replaceAll("field", "Ort"));
		return utils.waitForElementPresent( driver,locator_place);
		
	}
	
	public WebElement telephone() {
		By locator_telephone = By.xpath(textbox_entry.replaceAll("field", "Telefonnummer"));
		return utils.waitForElementPresent(driver, locator_telephone);
		
	}
	
	
	public ChooseOption fill_data(List<String> regdata)
	{
		By locator_salutation = By.xpath(radio_salutation.replaceAll("field", regdata.get(0)));
		utils.waitForElementPresent( driver,locator_salutation);
		utils.waitForElementToBeClickable( driver,locator_salutation).click();
		
		firstname().sendKeys(regdata.get(1));
		lastname().sendKeys(regdata.get(2));
		dob().sendKeys(regdata.get(3));
		street().sendKeys(regdata.get(4));
		house().sendKeys(regdata.get(5));
		pin().sendKeys(regdata.get(6));
		place().sendKeys(regdata.get(7));
		telephone().sendKeys(regdata.get(8));
		getButton_further().click();
		
		return new ChooseOption(driver);
	}
		
	}
	

	
