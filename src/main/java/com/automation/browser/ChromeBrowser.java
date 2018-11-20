package com.automation.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class ChromeBrowser {

    private static WebDriver browser;

    static WebDriver getInstance() {
        WebDriverManager.chromedriver().setup();
        if (browser == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("test-type");
            options.addArguments("disable-infobars");
            options.addArguments("start-maximized");
            options.addArguments("--js-flags=--expose-gc");
            options.addArguments("--enable-precise-memory-info");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-default-apps");
            browser = new ChromeDriver(options);
            return browser;
        } else {
            return browser;
        }
    }
}
