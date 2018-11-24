package com.automation;

import com.automation.ElementActionsHelper.UIActions;
import com.automation.browser.Driver;
import com.automation.finders.ElementFinder;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tset extends UIActions {

    @Test
    public void testthis() throws InterruptedException {
        System.setProperty("DEBUG_MODE", "true");
        UIActions.click(By.id("btnLogin"));
        Assert.assertEquals(UIActions.getText(By.id("spanMessage")), "Username cannot be empty");
        UIActions.sendKeys(By.id("txtUsername"), "Admin");
        UIActions.click(By.id("btnLogin"));
        Assert.assertEquals(UIActions.getText(By.id("spanMessage")), "Password cannot be empty");
        Thread.sleep(5000);
        Driver.getInstance().quit();
    }



    @Test
    public void testthisagauin() throws InterruptedException {
        System.setProperty("DEBUG_MODE", "true");
        Driver.getInstance().get("https://www.google.com");
        By nothanks = ElementFinder.tagWithText("a", "NO, THANKS");
        click(nothanks);
        sendKeys(ElementFinder.attributeWithValue("name", "q"), "maven central");
        click(ElementFinder.attributeWithValue("value", "Google Search"));
        Driver.getInstance().quit();
    }


}
