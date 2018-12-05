package com.automation.uiactionshelper;

import com.automation.utils.WebElementUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class ElementActions extends MouseActions {

    private final static Logger logger = Logger.getLogger(ElementActions.class);
    public static String getText(String eleFromCollection) {
        logger.info("Fetching Text From " + eleFromCollection + "");
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection).getText();
    }

    public static String getText(String eleFromCollection, int timeout) {
        logger.info("Fetching Text From " + eleFromCollection + " with timeout :" +timeout);
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection, timeout).getText();
    }

    public static String getText(By eleFromCollection) {
        logger.info("Fetching Text From " + eleFromCollection + "");
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection).getText();
    }

    public static String getText(By eleFromCollection, int timeout) {
        logger.info("Fetching Text From " + eleFromCollection + " with timeout :" +timeout);
        debugger(eleFromCollection, "Get Text");
        return WebElementUtils.getWebElement(eleFromCollection, timeout).getText();
    }

}
