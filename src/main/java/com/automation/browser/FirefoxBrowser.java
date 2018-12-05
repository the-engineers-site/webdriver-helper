package com.automation.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

class FirefoxBrowser {
    final static Logger logger = Logger.getLogger(FirefoxBrowser.class);
    WebDriver create() {
        logger.info("Starting firefox on standalone machine");
        WebDriverManager.firefoxdriver().setup();
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", "false");
        profile.setAcceptUntrustedCertificates(true);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(profile);
        return new FirefoxDriver(options);
    }
}
