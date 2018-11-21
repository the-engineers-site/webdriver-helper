package com.automation.finders;

import org.openqa.selenium.By;

public class ElementFinder {

    public static By tagWithText(String tag, String text) {
        return By.xpath(".//" + tag + "[text()='" + text + "']");
    }

    public static By tagContainsChildTags(String tag, String childTags) {
        return By.cssSelector("" + tag + "> " + childTags);
    }

    public static By elementText(String text) {
        String identifier = ".//*[text()='" + text + "']";
        return By.xpath(identifier);
    }
}
