package com.automation.ElementActionsHelper;

import com.automation.browser.Driver;
import com.automation.reporting.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class UIActions {

    public static void click(By element) {
        WaitUtils.waitUntilElementDisplayed(element);
        WebElement webElement = Driver.getInstance().findElement(element);
        if (System.getProperty("DEBUG_MODE") != null && System.getProperty("DEBUG_MODE").equalsIgnoreCase("true")) {
            JavaScriptUtilities.blinkBackground(webElement);
        }
        try {
            webElement.click();
        } catch (NoSuchElementException ee) {
            ee.printStackTrace();
        }
    }


    public static String getText(By element) {
       return WaitUtils.waitUntilElementDisplayed(element, 30).getText();
    }

    public static void sendKeys(By element, String textToSet) {
        Reporter.logEvent("Setting text on " + element + " : "+textToSet);
        WaitUtils.waitUntilElementDisplayed(element, 60).sendKeys(textToSet);
    }
}