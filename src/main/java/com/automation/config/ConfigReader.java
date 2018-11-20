package com.automation.config;

import com.automation.reporting.Reporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static ConfigReader configReader = new ConfigReader();
    private Properties properties = new Properties();

    /**
     * Create object of config reader with loading file from resources folder
     * Config file name needs to be set to "WEBDRIVER_HELPER_CONFIG" property
     * default name of file will be selected as "automation-config.properties"
     */
    private ConfigReader() {
        System.setProperty("WEBDRIVER_HELPER_CONFIG", (System.getProperty("WEBDRIVER_HELPER_CONFIG") != null) ? System.getProperty("WEBDRIVER_HELPER_CONFIG") : "automation-config.properties");
        Reporter.logEvent("Using " + System.getProperty("WEBDRIVER_HELPER_CONFIG") + " Config file for execution");
        String resourceName = System.getProperty("WEBDRIVER_HELPER_CONFIG");
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getConfig(String key) {
        String value = configReader.properties.getProperty(key);
        if (value != null) {
            Reporter.logEvent("Returning key : " + key + " Value is " + value);
            return value;
        } else {
            Reporter.logEvent("Key :" + key + " does not exist in collection/property file");
            return "";
        }
    }


    public static int getConfigInInt(String key) {
        if(getConfig(key) != null)
            return Integer.parseInt(getConfig(key));
        else
            return 0;
    }
}
