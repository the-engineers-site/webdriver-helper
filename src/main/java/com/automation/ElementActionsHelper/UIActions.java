package com.automation.ElementActionsHelper;

import com.automation.browser.Driver;
import com.automation.reporting.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class UIActions {

    public static void click(By element) {
        JavaScriptUtilities.debugInfo(element, "CLICK", "Clicking on " + element.toString());
        try {
            WaitUtils.waitUntilElementDisplayed(element).click();
        } catch (NoSuchElementException ee) {
            ee.printStackTrace();
        }
    }

    public static String getText(By element) {
        JavaScriptUtilities.debugInfo(element, "GET_TEXT", "Retrieving text from " + element.toString());
        return WaitUtils.waitUntilElementDisplayed(element, 30).getText();
    }

    public static void sendKeys(By element, String textToSet) {
        Reporter.logEvent("Setting text on " + element + " : " + textToSet);
        JavaScriptUtilities.debugInfo(element, "SEND_KEYS", "Typing " + textToSet + " to input field " + element.toString());
        WaitUtils.waitUntilElementDisplayed(element, 60).sendKeys(textToSet);
    }
}
