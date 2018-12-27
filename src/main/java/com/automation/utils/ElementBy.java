package com.automation.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementBy extends By {


    @Override
    public List<WebElement> findElements(SearchContext searchContext) {
        return null;
    }

    public static By AttributeWithValue(String attribute, String value) {
        return By.cssSelector("[" + attribute + "='" + value + "']");

    }

    public static By AttributeValueStartWith(String attribute, String value) {
        return By.cssSelector("[" + attribute + "^='" + value + "']");
    }

    public static By AttributeContainsValue(String attribute, String value) {
        return By.cssSelector("[" + attribute + "*='" + value + "']");

    }

    public static By Id(String id) {
        return By.cssSelector("#" + id);
    }


    public static By elementWithText(String text) {
        return elementWithText(text, 1);
    }

    @SuppressWarnings("WeakerAccess")
    public static By elementWithText(String text, int index) {
        return By.xpath(".//*[text()='" + text + "'][" + index + "]");
    }


}
