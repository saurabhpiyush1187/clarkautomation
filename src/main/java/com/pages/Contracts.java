package com.pages;

import com.util.GlobalConstants;
import com.util.Elementutil;
import com.util.PropertyReader;
import com.util.Baseutil;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contracts {

	private WebDriver driver;
	private By cookiePopup = PropertyReader.getLocator("cookiepopup", "Contracts");
	private By contractPage = PropertyReader.getLocator("contractpage", "Contracts");
	private By menuLocators = PropertyReader.getLocator("menulocators", "Contracts");
	private String strAngebote = PropertyReader.getProperty("str_angebote", "Contracts");
	private Baseutil utils = new Elementutil();

	public Contracts(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getCookiepopup() {
		return utils.waitForElementPresent(driver, cookiePopup);
	}

	public WebElement getContractpage() {
		return utils.waitForElementPresent(driver, contractPage);
	}

	public List<WebElement> getMenulocators() {
		return utils.waitForListElementsPresent(driver, menuLocators, 10);
	}

	public void goToBaseURL() {
		String url = "https://" + GlobalConstants.STAGINGUSERNAME + ":" + GlobalConstants.STAGINGPASSWORD + "@"
				+ GlobalConstants.BASEURL;
		driver.get(url);

		if (getCookiepopup() != null) {
			getCookiepopup().click();
			System.out.println("Pop is clicked\n");
		}
	}

	public boolean goToContractsURL() throws InterruptedException {
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

	public List<String> get_topmenu_list() {
		List<WebElement> element_menuoptions = getMenulocators();
		List<String> menuoptions = new ArrayList<String>();

		for (WebElement e : element_menuoptions) {
			String text = e.getText();
			System.out.println(text);
			menuoptions.add(text);
		}

		return menuoptions;
	}

	public OfferRequest clickon_Angebote(String menuoption) {
		driver.findElement(By.xpath(strAngebote.replaceAll("deal_option", menuoption))).click();
		return new OfferRequest(driver);
	}

}
