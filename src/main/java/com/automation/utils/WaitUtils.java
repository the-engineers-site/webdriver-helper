package com.automation.utils;

import com.automation.browser.Browser;
import com.automation.confighandler.ConfigReader;
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

    public static WebElement waitUntilElementDisplayed(By element, int timeout) {
        logger.info("Waiting for element " + element.toString() + " with wait timeout " + timeout);
        return getWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement waitUntilElementDisplayed(By element) {
        logger.info("Waiting for element " + element.toString() + " with default timeout");
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public static WebElement waitUntilElementDisplayed(WebElement element) {
        logger.info("Waiting for element " + element.toString() + " with default timeout");
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }
}
