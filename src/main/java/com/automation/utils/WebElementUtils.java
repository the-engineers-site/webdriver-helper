package com.automation.utils;

import com.automation.executionhelper.IdentifierCollection;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebElementUtils {

    private final static Logger logger = Logger.getLogger(WebElementUtils.class);
    public static WebElement getWebElement(By ele) {
        logger.info("Fetch webElement for "+ ele.toString());
        return WaitUtils.waitUntilElementDisplayed(ele);
    }

    public static WebElement getWebElement(By ele, int timeout) {
        logger.info("Fetch webElement for "+ ele.toString());
        return WaitUtils.waitUntilElementDisplayed(ele, timeout);
    }

    public static WebElement getWebElement(WebElement ele) {
        logger.info("Fetch webElement for "+ ele.toString());
        return WaitUtils.waitUntilElementDisplayed(ele);
    }

    public static By getIdentifier(String ele) {
        logger.debug("Fetching " + ele + " from collection");
        By identifierFromCollection =  IdentifierCollection.getElement(ele);
        logger.info("Fetch webElement for "+ identifierFromCollection.toString());
        return identifierFromCollection;
    }

    public static WebElement getWebElement(String ele) {
        logger.debug("Fetching " + ele + " from collection");
        By identifierFromCollection =  IdentifierCollection.getElement(ele);
        logger.info("Fetch webElement for "+ identifierFromCollection.toString());
        return WaitUtils.waitUntilElementDisplayed(identifierFromCollection);
    }

    public static WebElement getWebElement(String ele, int timeout) {
        logger.debug("Fetching " + ele + " from collection");
        By identifierFromCollection =  IdentifierCollection.getElement(ele);
        logger.info("Fetch webElement for "+ identifierFromCollection.toString());
        return WaitUtils.waitUntilElementDisplayed(identifierFromCollection, timeout);
    }
}
