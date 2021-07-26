package com.pages;

import org.openqa.selenium.WebDriver;

import com.util.Clarkutil;

public class StagingLoginPage {

	private WebDriver driver;
	private Clarkutil clarkUtil;
	public StagingLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
		clarkUtil = new Clarkutil(driver);
	}
	
	
	public ContractsPage goToBaseURL() {
		clarkUtil.goToBaseURL();
		return new ContractsPage(driver);
	}


	
	
}





