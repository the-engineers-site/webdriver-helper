package com.automation.finders;

import com.automation.ElementActionsHelper.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElementFinder {

    public static By tagWithText(String tag, String text) {
        return By.xpath(".//" + tag + "[text()='" + text + "']");
    }

    public static By tagContainsChildTags(String tag, String childTags) {
        return By.cssSelector("" + tag + "> " + childTags);
    }


    public static WebElement childElement(WebElement parentElement, By element) {
        return WaitUtils.waitUntilElementDisplayed(parentElement).findElement(element);
    }


    public static By elementText(String text) {
        String identifier = ".//*[text()='" + text + "']";
        return By.xpath(identifier);
    }

    public static By attributeWithValue(String attribute, String value) {
        return By.cssSelector("[ " + attribute + "= '" + value + "']");
    }

    public static By attributeContainsValue(String attribute, String value) {
        return By.cssSelector("[ " + attribute + "*= '" + value + "']");
    }

    public static By attributeValueStartWith(String attribute, String value) {
        return By.cssSelector("[ " + attribute + "^= '" + value + "']");
    }

    public static By attributeAndParentTag(String parentTag, String attribute, String value) {
        return By.cssSelector("" + parentTag + "[ " + attribute + "= '" + value + "']");
    }


}
