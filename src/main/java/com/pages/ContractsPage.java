package com.pages;

import com.util.PropertyReader;
import com.util.Clarkutil;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContractsPage {

	private WebDriver driver;
	private Clarkutil clarkUtil;
	private String strAngebote = PropertyReader.getProperty("str_angebote", "Contracts");

	public ContractsPage(WebDriver driver) {
		this.driver = driver;
		clarkUtil = new Clarkutil(driver);
	}

	public boolean goToContractsURL() throws InterruptedException {
		return clarkUtil.goToContractsURL();
	}

	public OfferRequestPage clickon_Angebote(String menuoption) {
		driver.findElement(By.xpath(strAngebote.replaceAll("deal_option", menuoption))).click();
		return new OfferRequestPage(driver);
	}

}
