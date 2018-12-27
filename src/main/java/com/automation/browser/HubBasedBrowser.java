package com.automation.browser;

import com.automation.confighandler.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

class HubBasedBrowser {

    private String hubUrl = null;
    private final static Logger logger = Logger.getLogger(HubBasedBrowser.class);

    HubBasedBrowser(String hubUrl) {
        if (hubUrl != null && !hubUrl.equals("")) {
            hubUrl = (hubUrl.startsWith("http://") || hubUrl.startsWith("https://")) ? hubUrl : "http://" + hubUrl;
            this.hubUrl = hubUrl.endsWith("/") ? hubUrl + "wd/hub/" : hubUrl + "/wd/hub/";
        }
        logger.info("Setting up browser execution on " + hubUrl);
    }

    private DesiredCapabilities getCapabilities(String browserType) {
        DesiredCapabilities capability;
        browserType = browserType == null ? "" : browserType;
        switch (browserType.toUpperCase()) {
            case "CHROME":
            case "CH":
                logger.info("Starting " + browserType + " browser on " + hubUrl);
                capability = DesiredCapabilities.chrome();
                capability.setCapability(ChromeOptions.CAPABILITY, ChromeBrowser.getChromeOptions());
                break;
            case "FIREFOX":
            case "FF":
                logger.info("Starting " + browserType + " browser on " + hubUrl);
                capability = DesiredCapabilities.firefox();
                break;
            default:
                logger.info("No Default browser is provided. Starting chrome browser on " + hubUrl);
                capability = DesiredCapabilities.chrome();
                capability.setCapability(ChromeOptions.CAPABILITY, ChromeBrowser.getChromeOptions());
                break;
        }
        return capability;
    }

    WebDriver create() {
        String browserType = ConfigReader.getInstance().getConfig("BROWSER_TYPE");
        try {
            return new RemoteWebDriver(new URL(hubUrl), getCapabilities(browserType));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
