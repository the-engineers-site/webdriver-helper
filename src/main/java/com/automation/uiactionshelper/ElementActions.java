package com.automation.uiactionshelper;

import com.automation.utils.WebElementUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ElementActions extends MouseActions {

    private final static Logger logger = Logger.getLogger(ElementActions.class);

    @SuppressWarnings("WeakerAccess")
    public static String getText(String eleFromCollection) {
        logger.info("Get Text performed on " + eleFromCollection);
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection).getText();
    }

    public static String getText(String eleFromCollection, int timeout) {
        logger.info("Get Text performed on " + eleFromCollection + " Timeout Specified is " + timeout);
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection, timeout).getText();
    }

    public static String getText(By eleFromCollection) {
        logger.info("Get Text performed on Element With Identifier " + eleFromCollection.toString());
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection).getText();
    }

    public static String getText(By eleFromCollection, int timeout) {
        logger.info("Get Text performed on Element With Timeout: " + timeout + " and Identifier " + eleFromCollection.toString());
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection, timeout).getText();
    }

}
