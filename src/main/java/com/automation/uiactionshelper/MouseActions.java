package com.automation.uiactionshelper;

import com.automation.executionhelper.PageCollection;
import com.automation.utils.WaitUtils;
import com.automation.utils.WebElementUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MouseActions extends KeyBoardActions {
    private final static Logger logger = Logger.getLogger(MouseActions.class);


    public static void click(String eleFromCollection) {
        logger.info("Clicking on collection element " + eleFromCollection);
        debugger(eleFromCollection, "CLICK");
        WebElementUtils.getWebElement(eleFromCollection).click();
    }

    public static Object click(String eleFromCollection, Class destinationPage) {
        logger.info("Clicking on collection element " + eleFromCollection);
        debugger(eleFromCollection, "CLICK");
        WebElementUtils.getWebElement(eleFromCollection).click();
        try {
            return destinationPage.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object click(String eleFromCollection, String destinationPage) {
        logger.info("Clicking on collection element " + eleFromCollection);
        debugger(eleFromCollection, "CLICK");
        WebElementUtils.getWebElement(eleFromCollection).click();
        try {
            return PageCollection.get(destinationPage).newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void click(By identifier) {
        logger.info("Clicking on element with Identifier " + identifier.toString());
        debugger(identifier, "CLICK");
        WebElementUtils.getWebElement(identifier).click();
    }

    public static void click(String eleFromCollection, int timeout) {
        logger.info("Clicking on collection element " + eleFromCollection + " with Timeout: " + timeout);
        debugger(eleFromCollection, "CLICK");
        WebElementUtils.getWebElement(eleFromCollection, timeout).click();
    }

    public static void click(By identifier, int timeout) {
        logger.info("Clicking on element with identifier " + identifier.toString() + " with Timeout: " + timeout);
        debugger(identifier, "CLICK");
        WebElementUtils.getWebElement(identifier, timeout).click();
    }

    public static void click(WebElement element) {
        logger.info("Clicking on WebElement " + element.getTagName() + "");
        debugger(element, "CLICK");
        WebElementUtils.getWebElement(element).click();
    }

    public static void click(WebDriver browser, By identifier) {
        logger.info("Clicking on element " + identifier.toString() + " using provided browser");
        WaitUtils.waitUntilElementDisplayed(browser.findElement(identifier)).click();
    }

    public static void click(WebDriver browser, String identifierFromCollection) {
        logger.info("Clicking on collection element " + identifierFromCollection + " with custom browser");
        WaitUtils.waitUntilElementDisplayed(
                browser.findElement(WebElementUtils
                        .getIdentifier(identifierFromCollection)))
                .click();
    }
}
