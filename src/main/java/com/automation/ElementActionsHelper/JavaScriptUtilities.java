package com.automation.ElementActionsHelper;

import com.automation.browser.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptUtilities {

    //static WebDriver browser = Driver.getInstance();
    public static boolean glowStatus = false;

    public static boolean executeScript(String script, WebElement identifier) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
        try {
            js.executeScript(script, identifier);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return true;
    }

    public static boolean executeScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getInstance();
        try {
            js.executeScript(script);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        return true;
    }


    public static void debugInfo(WebElement ele, String actionType, String message) {
        if (System.getProperty("DEBUG_MODE") != null && System.getProperty("DEBUG_MODE").equalsIgnoreCase("true")) {
            displayMessage(actionType, message);
            blinkBackground(ele);
        }
    }

    private static void displayMessage(String actionType, String message) {
        if (!glowStatus) {
            addGlow();
            glowStatus = true;
        }
        executeScript("$.growl.notice({ title: '" + actionType + "', message: '" + message + "' });");
    }

    public static void addGlow() {
        executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
        executeScript("$('head').append('<link rel=\"stylesheet\" "
                + "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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


    public static void debugInfo(By element, String actionType, String message) {
        WebElement ele = WaitUtils.waitUntilElementDisplayed(element);
        debugInfo(ele, actionType, message);
    }
}
