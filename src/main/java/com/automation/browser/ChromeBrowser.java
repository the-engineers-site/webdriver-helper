package com.automation.browser;

import com.automation.config.ConfigReader;
import com.automation.reporting.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

class ChromeBrowser {

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("test-type");
        options.addArguments("disable-infobars");
        options.addArguments("start-maximized");
        options.addArguments("--js-flags=--expose-gc");
        options.addArguments("--enable-precise-memory-info");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-default-apps");
        return options;
    }

    protected static WebDriver getInstance(String hubUrl) {


        if (hubUrl != null) {
            try {
                hubUrl = hubUrl.endsWith("/") ? hubUrl + "wd/hub/" : hubUrl + "/wd/hub/";
                Reporter.logEvent("Starting browser on Grid " + hubUrl);
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                if (ConfigReader.getConfig("proxy") != null) {
                    Proxy p = new Proxy();
                    p.setHttpProxy(ConfigReader.getConfig("proxy"));
                    capability.setCapability(CapabilityType.PROXY, p);
                }
                capability.setCapability(ChromeOptions.CAPABILITY, getChromeOptions());
                WebDriver browser = new RemoteWebDriver(new URL(hubUrl), capability);
                return browser;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            WebDriverManager.chromedriver().setup();
            WebDriver browser = new ChromeDriver(getChromeOptions());
            return browser;
        }
    }
}
