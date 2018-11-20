package com.automation.ElementActionsHelper;

import com.automation.browser.Driver;
import com.automation.config.ConfigReader;
import com.automation.reporting.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static boolean waitUntilElementDisplayed(By element, int timeout) {
        WebDriver driver = Driver.getInstance();
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            Reporter.logEvent("Waiting for element to be displayed");
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            Reporter.logEvent("Element is displayed. ");
            return true;
        } catch (TimeoutException e) {
            Reporter.logEvent("Element with " + element + " is not displayed in " + timeout);
            return false;
        }
    }

    public static boolean waitUntilElementDisplayed(By element) {
        int timeout = ConfigReader.getConfigInInt("default_wait");
        timeout = (timeout != 0) ? timeout : 30;
        return waitUntilElementDisplayed(element, timeout);
    }

}
