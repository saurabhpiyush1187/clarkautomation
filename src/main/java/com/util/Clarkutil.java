package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class Clarkutil{
	private  WebDriver driver;
	private  Baseutil utils = new Elementutil();
	private  By email=  PropertyReader.getLocator("email","Registration");
	private  By password=  PropertyReader.getLocator("password","Registration");
	private  String radioSalutation= PropertyReader.getProperty("radio_salutation","Personal_details");
	private  String textboxEntry= PropertyReader.getProperty("textbox_entry","Personal_details");
	private  By cookiePopup = PropertyReader.getLocator("cookiepopup", "BasePage");	
	private  By contractPage = PropertyReader.getLocator("contractpage", "Contracts");
	private  String optionHeader = PropertyReader.getProperty("option_header","Choose_option");
	private  String url = "https://" + GlobalConstants.STAGINGUSERNAME + ":" + GlobalConstants.STAGINGPASSWORD + "@" + GlobalConstants.BASEURL;
	
	
	public Clarkutil(WebDriver driver) {
		this.driver=driver;
	}
	
	public  WebElement getEmail() {
		return utils.waitForElementPresent(driver, email);
	}

	
	public  WebElement getPassword() {
		return utils.waitForElementPresent(driver,password);
	}


	
	public  WebElement firstname() {
		By locatorFirstname = By.xpath(textboxEntry.replaceAll("field", "Vorname"));
		return utils.waitForElementPresent(driver, locatorFirstname);
		
	}
	
	
	public  WebElement lastname() {
		By locatorLastname = By.xpath(textboxEntry.replaceAll("field", "Nachname"));
		return utils.waitForElementPresent(driver, locatorLastname);
		
	}
	
	public  WebElement dob() {
		By locatorDob = By.xpath(textboxEntry.replaceAll("field", "Geburtsdatum"));
		return utils.waitForElementPresent( driver,locatorDob);
		
	}
	public  WebElement street() {
		By locatorStreet = By.xpath(textboxEntry.replaceAll("field", "Straße"));
		return utils.waitForElementPresent( driver,locatorStreet);
		
	}
	
	public  WebElement house() {
		By locatorHouse = By.xpath(textboxEntry.replaceAll("field", "Hausnr."));
		return utils.waitForElementPresent(driver, locatorHouse);
		
	}
	
	public  WebElement pin() {
		By locatorPin = By.xpath(textboxEntry.replaceAll("field", "PLZ"));
		return utils.waitForElementPresent( driver,locatorPin);
		
	}
	
	public  WebElement place() {
		By locatorPlace = By.xpath(textboxEntry.replaceAll("field", "Ort"));
		return utils.waitForElementPresent( driver,locatorPlace);
		
	}
	
	public  WebElement telephone() {
		By locatorTelephone = By.xpath(textboxEntry.replaceAll("field", "Telefonnummer"));
		return utils.waitForElementPresent(driver, locatorTelephone);
		
	}
	
	public  WebElement getCookiepopup() {
		return utils.waitForElementPresent(driver, cookiePopup);
	}

	

	public  WebElement getContractpage() {
		return utils.waitForElementPresent(driver, contractPage);
	}
	
	/**
	   * Redirect the driver to the base url
 *

	   */

	public  void goToBaseURL() {
		
		driver.get(url);

		if (getCookiepopup() != null) {
			getCookiepopup().click();
			System.out.println("Pop is clicked\n");
		}
	}
	
	/**
	   * Checks if the user is on the Contracts page
 *

	   * @return Boolean
	   */
	public  boolean goToContractsURL() throws InterruptedException {
		String contract_url = GlobalConstants.CONTRACTSURL;

		utils.executeJS(driver, "window.open('');");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		driver.navigate().to(contract_url);

		if (getContractpage() != null) {
			return true;
		} else
			return false;
	}
	
	/**
	   * Register and Login with a new user on the login page
 *
	   * @param String :Username
	   * @param String :Password
	   */
	
	
	public  void doLogin(String username, String password )
	{
		int min = 200;  
		int max = 4000; 
		Integer randomNumber = (int)(Math.random()*(max-min+1)+min); 
		String strRandomNumber = randomNumber.toString();
		
		String actualUsername = username +strRandomNumber+"@mytest.com";
		getEmail().sendKeys(actualUsername);
		getPassword().sendKeys(password);
		
		
		
	}
	/**
	   * Enter the user details on the registration page
 *
	   * @param List of String input by the user
	   */
	
	public  void enterRegDetails(List<Map<String, String>> regList)
	{
		By locatorSalutation = By.xpath(radioSalutation.replaceAll("field",regList.get(0).get("Anrede")));
		utils.waitForElementPresent( driver,locatorSalutation);
		utils.waitForElementToBeClickable( driver,locatorSalutation).click();
		
		firstname().sendKeys(regList.get(0).get("Vorname"));
		lastname().sendKeys(regList.get(0).get("Nachname"));
		dob().sendKeys(regList.get(0).get("Geburtsdatum"));
		street().sendKeys(regList.get(0).get("Straße"));
		house().sendKeys(regList.get(0).get("Hausnr."));
		pin().sendKeys(regList.get(0).get("PLZ"));
		place().sendKeys(regList.get(0).get("Ort"));
		telephone().sendKeys(regList.get(0).get("Telefonnummer"));
		
	}
	
	/**
	   * Choose options
 *
	   * @param Strng: startDate : Option given by the user
	   * @param Strng: previousDamage : Option given by the user
	   */

	
	
	public void chooseOptions(String startDate, String previousDamage)
	{
		String[] dataHeader = {"Gewünschter Versicherungsbeginn", "Vorschäden"};
		for (String strHeader: dataHeader)
		{
			String 	header = optionHeader.replaceAll("data", strHeader);
			if(strHeader.equalsIgnoreCase("Gewünschter Versicherungsbeginn"))
			{
				By option = By.xpath(header.replaceAll("value", startDate));
				utils.waitForElementPresent(driver, option).click();
			}
			else if(strHeader.equalsIgnoreCase("Vorschäden"))
			{
				By option = By.xpath(header.replaceAll("value", previousDamage));
				utils.executeJS(driver, "window.scrollTo(0, document.body.scrollHeight)");
				utils.waitForElementPresent(driver, option).click();
			}
		}

	}
}
