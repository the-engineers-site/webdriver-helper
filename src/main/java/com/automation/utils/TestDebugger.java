package com.automation.utils;

import com.automation.uiactionshelper.JSExecutor;
import netscape.javascript.JSObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestDebugger {

    private static boolean glowStatus = false;
    private final static Logger logger = Logger.getLogger(TestDebugger.class);

    private static void displayMessage(String actionType, String message) {
        if (!glowStatus) {
            addGlow();
            glowStatus = true;
        }
        JSExecutor.executeScript("$.growl.notice({ title: '" + actionType + "', message: '" + message + "' });");
    }

    private static void addGlow() {
        logger.debug("DEBUG: ToastFlow: Added");
        JSExecutor.executeScript("if (!window.jQuery) {"
                + "var jquery = document.createElement('script'); jquery.type = 'text/javascript';"
                + "jquery.src = 'https://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js';"
                + "document.getElementsByTagName('head')[0].appendChild(jquery);" + "}");
        JSExecutor.executeScript("$.getScript('https://the-internet.herokuapp.com/js/vendor/jquery.growl.js')");
        JSExecutor.executeScript("$('head').append('<link rel=\"stylesheet\" "
                + "href=\"https://the-internet.herokuapp.com/css/jquery.growl.css\" " + "type=\"text/css\" />');");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void blinkBackground(WebElement elem) {
        logger.debug("DEBUG: BLINKING: BACKGROUND For:" + elem.toString());
        String style = "'box-shadow: 0px 0px 6px 6px rgba(255, 0, 0, 1);'";
        String styleReset = "''";
        try {
            for (int i = 0; i < 3; i++) {
                JSExecutor.executeScript("arguments[0].style=" + style, elem);
                Thread.sleep(500);
                JSExecutor.executeScript("arguments[0].style=" + styleReset, elem);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void addDebugInfo(By element, String message) {
        displayMessage(message.split(":")[0], message.split(":")[1]);
        blinkBackground(WebElementUtils.getWebElement(element));
    }

    public static void addDebugInfo(WebElement element, String message) {
        displayMessage(message.split(":")[0], message.split(":")[1]);
        blinkBackground(element);
    }
}
