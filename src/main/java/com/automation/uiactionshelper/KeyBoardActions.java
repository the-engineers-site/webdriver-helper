package com.automation.uiactionshelper;

import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class KeyBoardActions extends JSExecutor {

    private final static Logger logger = Logger.getLogger(KeyBoardActions.class);

    public static void type(String eleFromCollection, String textToType) {
        logger.info("Setting " + textToType + " on collection Object" + eleFromCollection);
        debugger(eleFromCollection, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(eleFromCollection).sendKeys(textToType);
    }

    public static void type(String eleFromCollection, String textToType, int timeout) {
        logger.info("Setting " + textToType + " on collection object " + eleFromCollection + " with timeout " + timeout);
        debugger(eleFromCollection, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(eleFromCollection, timeout).sendKeys(textToType);
    }

    public static void type(By identifier, String textToType, int timeout) {
        logger.info("Setting " + textToType + " on element with Idenfitier " + identifier.toString() + " with timeout " + timeout);
        debugger(identifier, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(identifier, timeout).sendKeys(textToType);
    }

    public static void type(By identifier, String textToType) {
        logger.info("Setting " + textToType + " on element with Idenfitier " + identifier.toString());
        debugger(identifier, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(identifier).sendKeys(textToType);
    }

    public static void type(WebElement element, String textToType) {
        logger.info("Setting " + textToType + " on web element with tag Name " + element.getText());
        debugger(element, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(element).sendKeys(textToType);
    }

    public static void type(WebDriver browser, By identifier, String textToType) {
        logger.info("Typing " + textToType + "  on " + identifier.toString() + " with specified browser");
        debugger(identifier, "TYPE/SENDKEYS");
        WaitUtils.waitUntilElementDisplayed(browser.findElement(identifier)).sendKeys(textToType);
    }

    public static void type(WebDriver browser, String identifierFromCollection, String textToType) {
        logger.info("Typing " + textToType + "  on " + identifierFromCollection + " with specified browser");
        debugger(identifierFromCollection, "TYPE/SENDKEYS");
        WaitUtils.waitUntilElementDisplayed(
                browser.findElement(WebElementUtils
                        .getIdentifier(identifierFromCollection)))
                .sendKeys(textToType);
    }


    public static void clear(String eleFromCollection) {
        logger.info("Clearing TextField on: " + eleFromCollection);
        debugger(eleFromCollection, "Clear Text field");
        WebElementUtils.getWebElement(eleFromCollection).clear();
    }

    public static void clear(By identifier, int timeout) {
        logger.info("Clearing TextField on: " + identifier.toString());
        debugger(identifier, "Clear Text field");
        WebElementUtils.getWebElement(identifier).clear();
    }

    public static void clear(String eleFromCollection, int timeout) {
        logger.info("Clearing TextField on: " + eleFromCollection);
        debugger(eleFromCollection, "Clear Text field");
        WebElementUtils.getWebElement(eleFromCollection).clear();
    }

    public static void clear(By identifier) {
        logger.info("Clearing TextField on: " + identifier.toString());
        debugger(identifier, "Clear Text field");
        WebElementUtils.getWebElement(identifier).clear();
    }

    public static void clear(WebElement element) {
        logger.info("Clearing TextField on: " + element.toString());
        debugger(element, "Clear Text field");
        WebElementUtils.getWebElement(element).clear();
    }


}
