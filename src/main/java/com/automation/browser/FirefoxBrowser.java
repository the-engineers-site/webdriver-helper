package com.automation.browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

class FirefoxBrowser {

    private static WebDriver browser;

    static WebDriver getInstance() {
        WebDriverManager.firefoxdriver().setup();
        if (browser == null) {
            FirefoxProfile profile = new FirefoxProfile();
            profile.setPreference("dom.ipc.plugins.enabled.libflashplayer.so", "false");
            profile.setAcceptUntrustedCertificates(true);
            FirefoxOptions options = new FirefoxOptions();
            options.setProfile(profile);
            browser = new FirefoxDriver(options);
            return browser;
        } else {
            return browser;
        }
    }
}
