package com.util;
import org.openqa.selenium.By;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class PropertyReader {
	public static Properties OR;
    public  FileInputStream fs;
    private static String previousFileName;
    private static String currentFileName;

    public PropertyReader(String fileName) {
        //Initialize the OR
        try{
            currentFileName = System.getProperty("user.dir") + "/src/test/resources/com/properties/" + fileName + ".properties";
            //check if this file exist or not
            if(!(new File(currentFileName).exists())){
                throw new IllegalStateException("File "+currentFileName+" does not exist, please provide correct property filename and path");
            }

        if (previousFileName == null || OR == null){
            OR = new Properties();
        try {
             fs = new FileInputStream(currentFileName);
            OR.load(fs);
        } catch (Exception e) {
            System.out.println("Error in initializing property file" + e.getMessage());
        }
    }else if(!previousFileName.equalsIgnoreCase(currentFileName)){
            OR = new Properties();
            try {
                 fs = new FileInputStream(currentFileName);
                OR.load(fs);
            }catch(Exception e){
                System.out.println("Error in initializing property file" + e.getMessage());
            }
        }}finally {
            previousFileName=currentFileName;
        }
    }

    public static By getLocator(String propertyValue, String fileName){
        new PropertyReader(fileName);
        return getLocator(propertyValue);
    }

    /**
     * This method returns the property value from the specified file name
     * @param propertyValue
     * @param fileName
     * @return
     */
    public static String getProperty(String propertyValue, String fileName){
        new PropertyReader(fileName);
        return OR.getProperty(propertyValue);
    }


    public static String getProperty(String propertyValue){
        return OR.getProperty(propertyValue);
    }

    /**
     * returns a new driver object, if driver is already initialized
     * then returns the existing object for using this method make an object of current class and call.
     *
     * @param propertyValue	selector to find the element
     *
     */
    public static By getLocator(String propertyValue){

        By objectValue = null;
        String propValue=OR.getProperty(propertyValue);
        if(propValue==null){
            throw new IllegalStateException("Either given property->"+propertyValue+"<- does not exist in Property file "+currentFileName+" or value is null");
        }
        String[] locatorArray=propValue.split("\\$",2);
        String lowercasePropertyValue =locatorArray[0].toLowerCase();
        String actualLocator=locatorArray[1];
        switch (lowercasePropertyValue){
            case "css": objectValue= By.cssSelector(locatorArray[1]);
                         break;
            case "id": objectValue= By.id(locatorArray[1]);
                         break;
            case "name": objectValue= By.name(locatorArray[1]);
                break;
            case "tagname": objectValue= By.tagName(locatorArray[1]);
                break;
            case "classname": objectValue= By.className(locatorArray[1]);
                break;
            case "linktxt": objectValue= By.linkText(locatorArray[1]);
                break;
            case "prtlinktxt": objectValue= By.partialLinkText(locatorArray[1]);
                break;
            case "xpath": objectValue= By.xpath(locatorArray[1]);
                break;
            default: System.out.println("Object identifier is not named properly, Please append one of the following text for each identifer in OR properties file accordingly");
                //APP_LOGS.info("Object identifier is not named properly, Please append one of the following text for each identifer in OR properties file accordingly");
                System.out.println("---css, id, name, tagname, classname, linktxt, prtlinktxt or xpath---");
                System.out.println("Format of defining the locator is not correct, Please follow below convention-\n" +
                        "e.g. loginBtn=xpath$//*[@name='login']\n" +
                        "loginBtn=css$#login");
                throw new IllegalStateException("Please follow the proper convention, if you are keeping things other than locator then don't initialize them in your page class ");
        }
        return objectValue;
    }

}
