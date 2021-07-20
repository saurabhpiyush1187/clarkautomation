package com.util;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Elementutil implements Baseutil {
	
	
	public static final int DEFAULT_IMPLICIT_WAIT = GlobalConstants.DEFAULT_IMPLICIT_WAIT;
	public static final int DEFAULT_EXPLICIT_WAIT = GlobalConstants.DEFAULT_EXPLICIT_WAIT;
	
	 
	/**
	   * Checks if the element is present
   *
	   * @param by - selector to find the element that should contain text
	   * @return WebElement
	   */
	@Override
	public WebElement getElement(WebDriver driver, By locator)
	{
		WebElement element = null;
		try
		{
			element = driver.findElement(locator);
			return element;
		}
		catch(Exception e)
		{
			
			System.out.println("Some error occured while creating element" + locator.toString());
			e.printStackTrace();
		}
		
		return element;
	}
	/**
	 * Set driver implicitlyWait() time to your desired wait time.
	 */
	@Override
	public void setImplicitWait(WebDriver driver,int waitTime_InSeconds) {
		driver.manage().timeouts().implicitlyWait(waitTime_InSeconds, TimeUnit.SECONDS);  
	} 
	
	 /**
	   * Checks if the text is present in the element. 
     *
	   * @param by - selector to find the element that should contain text
	   * @param text - The Text element you are looking for
	   * @return true or false
	   */
	@Override
	public boolean isTextPresent(WebDriver driver,By by, String text)
	{
		try {
				return driver.findElement(by).getText().contains(text);
		} catch (NullPointerException e) {
				return false;
		}
	}
	
	/**
	  * Wait for the element to be present in the DOM, regardless of being displayed or not.
	  * And returns the first WebElement using the given method.
	  *
	  * @param by	selector to find the element
	  * @param timeOutInSeconds	The time in seconds to wait until returning a failure
	  * 
	  * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
	 *
	  */
	@Override
	public WebElement waitForElementPresent(WebDriver driver,final By by, int timeOutInSeconds) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return element; //return the element
		}finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}

	}
	
	
	
	/**
	 * Wait for the element to be present in the DOM, regardless of being displayed or not.
	 * And returns the first WebElement using the given method.
	 *
	 * @param by	selector to find the element
	 *
	 * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
	 *
	 */
	@Override
	public WebElement waitForElementPresent(WebDriver driver,final By by) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
			WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return element; //return the element
		}finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}

	}
	
	/**
	 * Wait for the element to be clickable in the DOM
	 * And returns the first WebElement using the given method.
	 *
	 * @param by	selector to find the element
	 *
	 * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
	 *
	 */
	@Override
	public WebElement waitForElementToBeClickable(WebDriver driver,final By by) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return element; //return the element
		}finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}

	}
	/**
	 * Wait for the element to be present in the DOM and displayed
	 * And returns the first WebElement using the given method.
	 *
	 * @param by	selector to find the element
	 *
	 * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
	 *
	 */
	@Override
	public WebElement waitForElementVisibility(WebDriver driver,final By by) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return element; //return the element
		}finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}

	}
	
	/**
	 * Wait for the element to be present in the DOM and displayed
	 * And returns the first WebElement using the given method.
	 *
	 * @param by	selector to find the element
	 *@param  timeOutInseconds explicit wait time
	 * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
	 *
	 */
	@Override
	public WebElement waitForElementVisibility(WebDriver driver,final By by, final int timeOutInseconds) {
		try {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInseconds);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return element; //return the element
		}finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}

	}
	
	/**
	 * Wait for the element to be present in the DOM and displayed
	 * And returns the first WebElement using the given method.
	 *
	 * @param by	selector to find the element
	 *
	 * @return WebElement	the first WebElement using the given method, or null (if the timeout is reached)
	 *
	 */
	@Override
	public void waitForElementInvisibility(WebDriver driver,final By by) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}

	}
	
	
	
	/**
	 * Checks if the element is in the DOM, regardless of being displayed or not.
	 *
	 * @param by - selector to find the element
	 * @return boolean
	 */
	@Override
	public boolean isElementPresent(WebDriver driver,By by,int timeOutInSeconds) {
		Boolean exists=false;
		try
		{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
			exists=true;
		}
		catch(Exception e)
		{
			exists=false;
		}
		finally
		{
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return exists;
		}
	}

	/**
	 * Checks if the elment is in the DOM, regardless of being displayed or not.
	 *
	 * @param by - selector to find the element
	 * @return boolean
	 */
	@Override
	public boolean isElementPresent(WebDriver driver,By by) {
		Boolean exists=false;
		try
		{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver, DEFAULT_EXPLICIT_WAIT);
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			exists=true;
		}
		catch(Exception e)
		{
			exists=false;
		}
		finally
		{
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return exists;
		}
	}


	
	/**
	  * Wait for the List<WebElement> to be present in the DOM, regardless of being displayed or not.
	  * Returns all elements within the current page DOM. 
	  *
	  * @param by	selector to find the element
	  * @param timeOutInSeconds	The time in seconds to wait until returning a failure
	  *
	  * @return List<WebElement> all elements within the current page DOM, or null (if the timeout is reached)
	  */
	@Override
	public List<WebElement> waitForListElementsPresent(WebDriver driver,final By by, int timeOutInSeconds) {

		try{	
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //nullify implicitlyWait()
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds); 
			wait.until((new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return areElementsPresent(driver,by);
	            }
	        }));

			List<WebElement> elements = driver.findElements(by);
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
			return elements; //return the element	
		}finally {
			driver.manage().timeouts().implicitlyWait(DEFAULT_IMPLICIT_WAIT, TimeUnit.SECONDS); //reset implicitlyWait
		}
	}
	
	
	/**
	 * Checks if the List<WebElement> are in the DOM, regardless of being displayed or not.
	 *
	 * @param by - selector to find the element
	 * @return boolean
	 */
	@Override
	public boolean areElementsPresent(WebDriver driver,By by) {
		try {
			if(driver.findElements(by).size()>0)
				return true;
			else
				return  false;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	
	 /**
     * executeJS:(execute the java script in this page).
     *
     * @param script --the java script we need to execute
     * @return Object
     * @since JDK 1.6
     */
	@Override
    public Object executeJS(WebDriver driver,String script) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        return je.executeScript(script);
    }
	
}
