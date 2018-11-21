package com.automation.ElementActionsHelper;

import com.automation.browser.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {

    static WebDriver browser = Driver.getInstance();

    public static boolean executeScript(String script, WebElement identifier) {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        try {
            js.executeScript(script, identifier);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return true;
    }


    public static void blinkBackground(WebElement elem) {
        String style = "'background: lightblue;border: solid;'";
        String styleReset = "''";
        try {
            for (int i = 0; i < 3; i++) {
                executeScript("arguments[0].style=" + style, elem);
                Thread.sleep(500);
                executeScript("arguments[0].style=" + styleReset, elem);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
