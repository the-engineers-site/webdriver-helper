package com.automation;

import com.automation.browser.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class tset {

    @Test
    public void testthis() {
        WebDriver browser = Driver.getInstance();

        browser.quit();
    }

}
