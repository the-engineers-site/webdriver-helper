package com.automation.ElementActionsHelper;

import com.automation.browser.Driver;
import com.automation.config.ConfigReader;
import com.automation.finders.ElementFinder;
import com.automation.reporting.Reporter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitUtils {

    private static WebDriverWait getWait(int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getInstance(), 140);
        wait.withTimeout(timeout, TimeUnit.SECONDS);
        wait.pollingEvery(500, TimeUnit.MILLISECONDS);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(ElementNotVisibleException.class);
        return wait;
    }


    private static WebDriverWait getWait() {
        int timeout = ConfigReader.getConfigInInt("default_wait");
        timeout = (timeout != 0) ? timeout : 30;
        return getWait(timeout);
    }

    public static Alert alertIsPresent() {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }

    public static boolean attributeContains(WebElement element, String attribute, String value) {
        return getWait().until(ExpectedConditions.attributeContains(element, attribute, value));
    }

    public static boolean attributeToBe(WebElement element, String attribute, String value) {
        return getWait().until(ExpectedConditions.attributeToBe(element, attribute, value));
    }

    public static boolean attributeToBeNotEmpty(WebElement element, String attribute) {
        return getWait().until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public static boolean elementSelectionStateToBe(WebElement element, boolean selected) {
        return getWait().until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }

    public static WebElement elementToBeClickable(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(By element) {
        return getWait().until(ExpectedConditions.elementToBeClickable(waitUntilElementDisplayed(element)));
    }

    public static WebElement elementToBeClickable(WebElement element, int timeout) {
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement elementToBeClickable(By element, int timeout) {
        return getWait(timeout).until(ExpectedConditions.elementToBeClickable(waitUntilElementDisplayed(element, timeout)));
    }

    public static boolean elementToBeSelected(WebElement element) {
        return getWait().until(ExpectedConditions.elementToBeSelected(element));
    }

    public static WebDriver frameToBeAvailableAndSwitchToIt(WebElement frameLocator) {
        return getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public static Boolean numberOfWindowsToBe(int expectedNumberOfWindows) {
        return getWait().until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows));
    }

    public static Boolean stalenessOf(WebElement element) {
        return getWait().until(ExpectedConditions.stalenessOf(element));
    }

    public static Boolean textToBePresentInElement(WebElement element, String text) {
        return getWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static Boolean textToBePresentInElementValue(WebElement element, String text) {
        return getWait().until(ExpectedConditions.textToBePresentInElementValue(element, text));
    }

    public static Boolean titleIs(String title) {
        return getWait().until(ExpectedConditions.titleIs(title));
    }

    public static Boolean titleContains(String subTitle) {
        return getWait().until(ExpectedConditions.titleContains(subTitle));
    }

    public static Boolean urlContains(String fraction) {
        return getWait().until(ExpectedConditions.urlContains(fraction));
    }

    public static WebElement waitUntilElementDisplayed(WebElement element) {
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitUntilElementDisplayed(WebElement element, int timeout) {
        return getWait(timeout).until(ExpectedConditions.visibilityOf(element));
    }


    public static WebElement waitUntilElementDisplayed(By element) {
        Reporter.logEvent("Waiting for element to be displayed");
        WebElement ele = getWait().until(ExpectedConditions.visibilityOfElementLocated(element));
        Reporter.logEvent("Element is displayed. ");
        return ele;
    }

    public static WebElement waitUntilElementDisplayed(By element, int timeout) {
        Reporter.logEvent("Waiting for element to be displayed");
        WebElement ele = getWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(element));
        Reporter.logEvent("Element is displayed. ");
        return ele;
    }
}
