package com.automation;

import com.automation.ElementActionsHelper.UIActions;
import com.automation.browser.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tset {

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
}
