package com.automation.browser;

import com.automation.config.ConfigReader;
import com.automation.reporting.Reporter;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private WebDriver browser = null;
    private static Driver driver = new Driver();

    private Driver() {
        startBrowser();
    }

    public static WebDriver getInstance() {
        try {
            driver.browser.getTitle();
        } catch (Exception ee) {
            driver.browser = null;
            driver.startBrowser();
        }
        return driver.browser;
    }

    private void startBrowser() {
        int defaultTimeout = Integer.parseInt(ConfigReader.getConfig("implicit_wait"));
        String hubUrl = ConfigReader.getConfig("hub_url");
        String browserType = ConfigReader.getConfig("browser");
        String baseUrl = ConfigReader.getConfig("base_url");
        baseUrl = (baseUrl != null) ? baseUrl : "https://www.google.com";
        if (browserType != null) {
            openBrowser(browserType, defaultTimeout, baseUrl, hubUrl);
        } else {
            Reporter.logEvent("Browser is not specified in config file, Selecting default browser");
            openBrowser("chrome", defaultTimeout, baseUrl, hubUrl);
        }
    }

    private void openBrowser(String browserType, int defaultTimeout, String baseUrl, String hubUrl) {

        switch (browserType) {
            case Type.chrome:
                browser = ChromeBrowser.getInstance(hubUrl);
                break;
            case Type.firefox:
                browser = FirefoxBrowser.getInstance(hubUrl);
                break;
            default:
                browser = ChromeBrowser.getInstance(hubUrl);
        }

        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(defaultTimeout, TimeUnit.SECONDS);
        browser.get(baseUrl);
    }


}
