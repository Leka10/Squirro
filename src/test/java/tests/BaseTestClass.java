package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.LoggerUtils;
import utils.WebDriverUtils;

public class BaseTestClass extends LoggerUtils {

    public WebDriver driver;



    protected WebDriver setUpDriver() {
        log.debug("setUpDriver()");
        return WebDriverUtils.setUpDriver();
    }
    protected void quitDriver(WebDriver driver) {
        log.debug("quitDriver()");
        WebDriverUtils.quitDriver(driver);
    }


    protected void  tearDown(WebDriver driver, ITestResult testResult) {
        String sTestName = testResult.getTestClass().getName();
        log.debug("tearDown(" + sTestName + ")");
        try {
            if (testResult.getStatus() == ITestResult.FAILURE) {
                // Take Screenshot
                log.warn("Test " + sTestName + " has failed");
            }

        } catch (AssertionError | Exception e) {
            log.error("Exception occurred in tearDown(" + sTestName + ")! Message:" + e.getMessage());
        }
        finally {
            quitDriver(driver);

        }

    }

    @BeforeMethod
    public void setUpTest() {
        log.debug("[SETUP TEST] ");
        driver = setUpDriver();
    }
//    @AfterMethod(alwaysRun = true)
//    public void tearDownTest(ITestResult testResult) {
//        log.debug("[END TEST] ");
//        tearDown(driver, testResult);
//    }

}
