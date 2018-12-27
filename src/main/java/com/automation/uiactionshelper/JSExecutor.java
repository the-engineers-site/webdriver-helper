package com.automation.uiactionshelper;

import com.automation.browser.Browser;
import com.automation.confighandler.ConfigReader;
import com.automation.utils.TestDebugger;
import com.automation.utils.WebElementUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static com.automation.utils.TestDebugger.addDebugInfo;

public class JSExecutor {

    private final static Logger logger = Logger.getLogger(JSExecutor.class);

    private static boolean enableDebugger() {
        String debugMode = ConfigReader.getInstance().getConfig("DEBUG_MODE");
        String debugModeProperty = System.getProperty("DEBUG_MODE");
        return (debugMode != null && debugMode.equals("true")) || (debugModeProperty != null && debugModeProperty.equals("true"));
    }

    static void debugger(By element, String action) {
        if (enableDebugger()) {
            addDebugInfo(element, action + ":" + "performed on " + element.toString());
        }
    }

    static void debugger(WebElement element, String action) {
        if (enableDebugger()) {
            addDebugInfo(element, action + ":" + "performed on " + element.toString());
        }
    }

    static void debugger(String identifier, String action) {
        By element = WebElementUtils.getIdentifier(identifier);
        if (enableDebugger()) {
            addDebugInfo(element, action + ":" + "performed on " + identifier);
        }
    }


    private static JavascriptExecutor getJsObject() {
        return (JavascriptExecutor) Browser.getInstance();
    }


    public static void executeScript(String script, WebElement identifier) {
        logger.info("Javascript execution: " + script + " On webElement");
        try {
            getJsObject().executeScript(script, identifier);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void executeScript(String script) {
        logger.info("Executing JS " + script);
        try {
            getJsObject().executeScript(script);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void executeAsyncScript(String script) {
        logger.info("Async Script execution " + script);
        try {
            getJsObject().executeAsyncScript(script);
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

}
