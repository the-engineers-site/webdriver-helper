package com.automation.browser;

import com.automation.confighandler.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

class StandaloneDriver {
    private final static Logger logger = Logger.getLogger(StandaloneDriver.class);

    WebDriver create() {
        String browserType = ConfigReader.getInstance().getConfig("BROWSER_TYPE");
        switch (browserType.toUpperCase()) {
            case "CHROME":
            case "CH":
                logger.info("Starting " + browserType + " browser");
                return new ChromeBrowser().create();
            case "FIREFOX":
            case "FF":
                logger.info("Starting Firefox browser");
                return new FirefoxBrowser().create();
            default:
                logger.info("Starting default browser");
                return new ChromeBrowser().create();
        }
    }
}
