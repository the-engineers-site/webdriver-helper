package com.automation.executionhelper;

import com.automation.confighandler.ConfigReader;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PageCollection {

    private final static Logger logger = Logger.getLogger(PageCollection.class);
    private static HashMap<String, Class> pageCollection = new HashMap<>();

    public static void put(HashMap<String, Class> collection) {
        logger.info("Bulk Pages added to collection");
        for (Map.Entry entry : collection.entrySet()) {
            pageCollection.put((String) entry.getKey(), (Class) entry.getValue());
        }
    }


    public static void put(String key, Class value) {
        logger.debug("Page  " + key + " added to collection");
        pageCollection.put(key, value);
    }

    public static Class get(String key) {
        Class iden = pageCollection.get(key);
        logger.debug("Returning Page Class for " + key);
        return iden;
    }

    public static void loadIdentifier(String key, Class value) {
        logger.debug("Page " + key + " added to collection");
        pageCollection.put(key, value);
    }

    public static void setStartPage() {
        String startPage = ConfigReader.getInstance().getConfig("START_PAGE_CLASS");
        logger.info("Setting up first page " + startPage);
        try {
            Class destinationPage = Class.forName(startPage);
            IdentifierCollection.loadIdentifier(destinationPage);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
