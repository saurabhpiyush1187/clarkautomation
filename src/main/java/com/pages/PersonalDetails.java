package com.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.util.PropertyReader;
import com.util.Baseutil;
import com.util.Elementutil;


public class PersonalDetails{

	private WebDriver driver;
	private By buttonFurther =  PropertyReader.getLocator("button_further","Personal_details");
	private String radioSalutation= PropertyReader.getProperty("radio_salutation","Personal_details");
	private String textboxEntry= PropertyReader.getProperty("textbox_entry","Personal_details");
	private Baseutil utils = new Elementutil();
	
	
	public PersonalDetails(WebDriver driver) {

		this.driver=driver;
	}


	public WebElement getButtonFurther() {
		return utils.waitForElementPresent(driver,buttonFurther);
	}

	
	public WebElement firstname() {
		By locatorFirstname = By.xpath(textboxEntry.replaceAll("field", "Vorname"));
		return utils.waitForElementPresent(driver, locatorFirstname);
		
	}
	
	
	public WebElement lastname() {
		By locatorLastname = By.xpath(textboxEntry.replaceAll("field", "Nachname"));
		return utils.waitForElementPresent(driver, locatorLastname);
		
	}
	
	public WebElement dob() {
		By locatorDob = By.xpath(textboxEntry.replaceAll("field", "Geburtsdatum"));
		return utils.waitForElementPresent( driver,locatorDob);
		
	}
	public WebElement street() {
		By locatorStreet = By.xpath(textboxEntry.replaceAll("field", "Straße"));
		return utils.waitForElementPresent( driver,locatorStreet);
		
	}
	
	public WebElement house() {
		By locatorHouse = By.xpath(textboxEntry.replaceAll("field", "Hausnr."));
		return utils.waitForElementPresent(driver, locatorHouse);
		
	}
	
	public WebElement pin() {
		By locatorPin = By.xpath(textboxEntry.replaceAll("field", "PLZ"));
		return utils.waitForElementPresent( driver,locatorPin);
		
	}
	
	public WebElement place() {
		By locatorPlace = By.xpath(textboxEntry.replaceAll("field", "Ort"));
		return utils.waitForElementPresent( driver,locatorPlace);
		
	}
	
	public WebElement telephone() {
		By locatorTelephone = By.xpath(textboxEntry.replaceAll("field", "Telefonnummer"));
		return utils.waitForElementPresent(driver, locatorTelephone);
		
	}
	
	
	public ChooseOption fillData(List<String> regdata)
	{
		By locatorSalutation = By.xpath(radioSalutation.replaceAll("field", regdata.get(0)));
		utils.waitForElementPresent( driver,locatorSalutation);
		utils.waitForElementToBeClickable( driver,locatorSalutation).click();
		
		firstname().sendKeys(regdata.get(1));
		lastname().sendKeys(regdata.get(2));
		dob().sendKeys(regdata.get(3));
		street().sendKeys(regdata.get(4));
		house().sendKeys(regdata.get(5));
		pin().sendKeys(regdata.get(6));
		place().sendKeys(regdata.get(7));
		telephone().sendKeys(regdata.get(8));
		getButtonFurther().click();
		
		return new ChooseOption(driver);
	}
		
	}
	

	
