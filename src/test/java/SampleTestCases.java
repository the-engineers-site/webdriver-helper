import com.automation.browser.Browser;
import com.automation.uiactionshelper.ElementActions;
import com.example.oragnehr.pages.Login;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class SampleTestCases extends ElementActions {

    final static Logger logger = Logger.getLogger(SampleTestCases.class);

    @BeforeSuite
    public void beforeSuite() {
        logger.info("Suite Execution Started");
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        logger.info("Execution for " + method.getName() + " Started");
        Login login = new Login();
    }

    @Test
    public void testCase1() {
        String title = Browser.getInstance().getTitle();
        Assert.assertEquals("OrangeHRM", title);
        type("User Name", "Admin", 60);
        click("Login", 30);
        String validationMessage = getText("Validation Message");
        Assert.assertEquals(validationMessage, "Password cannot be empty");
    }

    @Test
    public void testCase2() {
        String title = Browser.getInstance().getTitle();
        Assert.assertEquals("OrangeHRM", title);
        clear("User Name");
        type("Password", "Admin", 60);
        click("Login", 30);
        String validationMessage = getText("Validation Message");
        Assert.assertEquals(validationMessage, "Username cannot be empty");
    }

    @AfterSuite
    public void tearDown() {
        Browser.getInstance().quit();
    }

}
