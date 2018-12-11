package com.automation.executionhelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;

public class IdentifierCollection {

    private final static Logger logger = Logger.getLogger(IdentifierCollection.class);
    private static HashMap<String, By> identifierCollection = new HashMap<>();

    public static void put(HashMap<String, By> collection) {
        logger.info("Bulk identifiers added to collection");
        for (Map.Entry entry : collection.entrySet()) {
            identifierCollection.put((String) entry.getKey(), (By) entry.getValue());
        }
    }


    public static void put(String key, By value) {
        logger.info("Identifiers " + key + " added to collection with value "+ value);
        identifierCollection.put(key, value);
    }

    public static By get(String key) {
        By iden = identifierCollection.get(key);
        logger.info("Returning value for " + key + ", With Value: "+ iden);
        return iden;
    }

    public static void loadIdentifier(String key, By value) {
        logger.info("Identifiers " + key + " added to collection");
        identifierCollection.put(key, value);
    }

    @Deprecated
    public static By getElement(String key) {
        return identifierCollection.get(key);
    }

}
