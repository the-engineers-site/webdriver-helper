package com.automation.utils;

import com.automation.browser.Browser;
import com.automation.confighandler.ConfigReader;
import com.automation.executionhelper.IdentifierCollection;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitUtils {

    private final static Logger logger = Logger.getLogger(WaitUtils.class);

    private static Wait<WebDriver> getWait(int timeout) {
        logger.debug("Retrieving wait with " + timeout);
        FluentWait<WebDriver> webDriverFluentWait = new FluentWait<>(Browser.getInstance());
        webDriverFluentWait.withTimeout(Duration.ofSeconds(timeout));
        webDriverFluentWait.pollingEvery(Duration.ofSeconds(5));
        webDriverFluentWait.ignoring(NoSuchElementException.class);
        webDriverFluentWait.ignoring(ElementNotVisibleException.class);
        return webDriverFluentWait;
    }

    private static Wait<WebDriver> getWait() {
        String timeout = ConfigReader.getInstance().getConfig("DEFAULT_WAIT");
        if (timeout != null) {
            logger.debug("Retrieving wait with " + timeout);
            return getWait(Integer.parseInt(timeout));
        } else {
            logger.debug("Retrieving wait with default wait of 30 seconds");
            return getWait(30);
        }
    }

    /*
     *  wait until element visible
     */
    @SuppressWarnings(value = "WeakerAccess")
    public static WebElement waitUntilElementDisplayed(By element, int timeout) {
        logger.info("Waiting for element " + element.toString() + " with wait timeout " + timeout);
        WebElement webElement = getWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
        logger.info("Wait for " + element.toString() + " completed");
        return webElement;
    }

    @SuppressWarnings(value = "WeakerAccess")
    public static WebElement waitUntilElementDisplayed(By element) {
        logger.info("Waiting for element " + element.toString() + " with default timeout");
        WebElement webElement = getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
        logger.info("Wait for " + element.toString() + " completed");
        return webElement;
    }

    public static WebElement waitUntilElementDisplayed(WebElement element) {
        logger.info("Waiting for element " + element.getText() + " with default timeout");
        WebElement webElement = getWait().until(ExpectedConditions.visibilityOf(element));
        logger.info("Wait for " + element.getText() + " completed");
        return webElement;
    }


    public static WebElement waitUntilElementDisplayed(String element, int timeout) {
        logger.info("Waiting for element " + element + " with " + timeout);
        By identifier = IdentifierCollection.get(element);
        return waitUntilElementDisplayed(identifier, timeout);
    }

    public static WebElement waitUntilElementDisplayed(String element) {
        logger.info("Waiting for element " + element + " with default timeout");
        By identifier = IdentifierCollection.get(element);
        return waitUntilElementDisplayed(identifier);
    }

    /*
     * wait until element is not visible
     */

    public static boolean waitUntilElementDisappear(By element, int timeout) {
        logger.debug("Waiting for element to disappear " + element.toString() + " with wait timeout " + timeout);
        boolean result = getWait(timeout).until(ExpectedConditions.invisibilityOfElementLocated(element));
        logger.debug("Waiting for element to disappear " + element.toString() + " completed");
        return result;
    }

    public static boolean waitUntilElementDisappear(By element) {
        logger.info("Waiting for element to disappear " + element.toString() + " with default timeout");
        boolean result = getWait().until(ExpectedConditions.invisibilityOfElementLocated(element));
        logger.debug("Waiting for element to disappear " + element.toString() + " completed");
        return result;
    }

    public static Boolean waitUntilElementDisappear(WebElement element) {
        logger.info("Waiting for element to disappear " + element.getText() + " with default timeout");
        Boolean webElement = getWait().until(ExpectedConditions.invisibilityOf(element));
        logger.debug("Waiting for element to disappear " + element.getText() + " completed");
        return webElement;
    }


    public static WebElement waitUntilElementDisappear(String element, int timeout) {
        logger.info("Waiting for element to disappear " + element + " with " + timeout);
        By identifier = IdentifierCollection.get(element);
        return waitUntilElementDisplayed(identifier, timeout);
    }

    public static WebElement waitUntilElementDisappear(String element) {
        logger.info("Waiting for element to disappear " + element + " with default timeout");
        By identifier = IdentifierCollection.get(element);
        return waitUntilElementDisplayed(identifier);
    }

}
