package com.automation.browser;

import com.automation.confighandler.ConfigReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Browser {

    private final static Logger logger = Logger.getLogger(Browser.class);

    private WebDriver driver = null;
    private static Browser browser = new Browser();

    /*
     * This method will help you to use self managed Driver instance
     * Just perform get instance
     */
    private Browser() {
    }

    /*
     * This method will help you to provide own browser instance
     * provide your WebDriver instance to method
     *
     * @Param: WebDriver
     */
    public Browser(WebDriver customBrowser) {
        browser.driver = customBrowser;
        this.webDriverPropertiesSet(customBrowser);
    }

    /*
     * Method will create Self managed webdriver as performed getInstance
     * But webdriver instance was empty
     * provide your WebDriver instance to method
     *
     */
    private void startSelfManagedDriver() {
        logger.info("Starting Self Managed WebDriver Instance");
        String hubUrl = ConfigReader.getInstance().getConfig("HUB_URL");
        if (hubUrl != null && !hubUrl.equals(""))
            this.driver = new HubBasedBrowser(hubUrl).create();
        else
            this.driver = new StandaloneDriver().create();
    }

    private void webDriverPropertiesSet(WebDriver driver) {
        String defaultTimeout = ConfigReader.getInstance().getConfig("IMPLICIT_WAIT");
        String baseUrl = ConfigReader.getInstance().getConfig("BASE_URL");
        driver.manage().window().maximize();
        if (defaultTimeout != null) {
            int timeout = Integer.parseInt(defaultTimeout);
            driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        }
        if (baseUrl != null) {
            driver.get(baseUrl);
        }
    }

    /*
     * Method will create Self managed webdriver as performed getInstance
     * But webdriver instance was empty
     * provide your WebDriver instance to method
     *
     */
    public static WebDriver getInstance() {
        logger.info("Fetching Instance of browser");
        if (browser.driver == null) {
            logger.info("No Existing browser created, Starting new Browser");
            browser.startSelfManagedDriver();
            browser.webDriverPropertiesSet(browser.driver);
        }
        return browser.driver;
    }


    public static void quit() {
        logger.info("Quit Browser action called, Quitting current browser");
        if(browser.driver == null) {
            logger.info("No open browser available to close");
            return;
        }
        browser.driver.quit();
    }

    public static void close() {
        logger.info("Close Browser action called, Closing current browser");
        if(browser.driver == null) {
            logger.info("No open browser available to close");
            return;
        }
        browser.driver.close();
    }

    public static void navigate(String url) {
        logger.info("Navigating to " + url + "");
        if (browser.driver == null) {
            logger.info("No Existing browser created, Starting new Browser");
            browser.startSelfManagedDriver();
            browser.webDriverPropertiesSet(browser.driver);
        }
        browser.driver.get(url);
    }

}
