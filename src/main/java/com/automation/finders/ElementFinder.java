package com.automation.finders;

import com.automation.ElementActionsHelper.WaitUtils;
import com.automation.browser.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
