package com.automation.executionhelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class IdentifierCollection {

    private final static Logger logger = Logger.getLogger(IdentifierCollection.class);
    public static HashMap<String, By> identifierCollection = new HashMap<>();

    public static void loadIdentifiers(HashMap<String, By> collection) {
        logger.info("Bulk identifiers added to collection");
        for (Map.Entry entry : collection.entrySet()) {
            identifierCollection.put((String) entry.getKey(), (By) entry.getValue());
        }
    }


    public static void loadIdentifier(String key, By value) {
        logger.info("Identifiers " + key + " added to collection");
        identifierCollection.put(key, value);
    }

    public static By getElement(String key) {
        return identifierCollection.get(key);
    }

}
