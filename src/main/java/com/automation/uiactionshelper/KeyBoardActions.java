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
        logger.info("Type on: " + eleFromCollection + ": text: " + textToType);
        debugger(eleFromCollection, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(eleFromCollection).sendKeys(textToType);
    }

    public static void type(By identifier, String textToType, int timeout) {
        logger.info("Type on: " + identifier.toString() + ": text: " + textToType+ " with timeout:"+timeout);
        debugger(identifier, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(identifier, timeout).sendKeys(textToType);
    }

    public static void type(String eleFromCollection, String textToType, int timeout) {
        logger.info("Type on: " + eleFromCollection + ": text: " + textToType + " with timeout:"+timeout);
        debugger(eleFromCollection, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(eleFromCollection, timeout).sendKeys(textToType);
    }

    public static void type(By identifier, String textToType) {
        logger.info("Type on: " + identifier.toString() + ": text: " + textToType);
        debugger(identifier, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(identifier).sendKeys(textToType);
    }

    public static void type(WebElement element, String textToType) {
        logger.info("Type on: " + element.getTagName() + ": text: " + textToType);
        debugger(element, "TYPE/SENDKEYS");
        WebElementUtils.getWebElement(element).sendKeys(textToType);
    }

    public static void type(WebDriver browser, By identifier, String textToType) {
        logger.info("Existing Browser Action: Type on: " + identifier + ": text: " + textToType);
        debugger(identifier, "TYPE/SENDKEYS");
        WaitUtils.waitUntilElementDisplayed(browser.findElement(identifier)).sendKeys(textToType);
    }

    public static void type(WebDriver browser, String identifierFromCollection, String textToType) {
        logger.info("Existing Browser Action: Type on: " + identifierFromCollection + ": text: " + textToType);
        debugger(identifierFromCollection, "TYPE/SENDKEYS");
        WaitUtils.waitUntilElementDisplayed(
                browser.findElement(WebElementUtils
                        .getIdentifier(identifierFromCollection)))
                .sendKeys(textToType);
    }


    public static void clear(String eleFromCollection) {
        logger.info("Clearing TextField on: " + eleFromCollection );
        debugger(eleFromCollection, "Clear Text field");
        WebElementUtils.getWebElement(eleFromCollection).clear();
    }

    public static void clear(By identifier, int timeout) {
        logger.info("Clearing TextField on: " + identifier.toString() );
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
