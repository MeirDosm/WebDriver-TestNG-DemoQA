package listeners;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;
import utils.LoggerUtil;
import utils.ScreenshotUtil;

import java.io.File;

public class TestListener implements ITestListener {
    private Logger log = LoggerUtil.getLogger(this.getClass());

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();

        String path = ScreenshotUtil.takeScreenshot(driver, result.getName());

        if (path != null) {
            log.error("Test FAILED: " + result.getName());
            log.info("Screenshot saved: " + path);
        } else {
            log.error("Test FAILED: " + result.getName() + " (Failed to capture screenshot)");
        }
    }

    @Override
    public void onTestStart(ITestResult result) { }
    @Override
    public void onTestSuccess(ITestResult result) { }
    @Override
    public void onTestSkipped(ITestResult result) { }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) { }
    @Override
    public void onStart(ITestContext context) {
        File screenshotDir = new File("screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
            log.info("Created screenshots folder at: " + screenshotDir.getAbsolutePath());
        }
    }
    @Override
    public void onFinish(ITestContext context) { }
}