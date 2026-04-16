package cucumber.hooks;

import driver.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static WebDriver driver;
    private Logger log = LoggerUtil.getLogger(Hooks.class);

    @Before
    public void setUp() {
        log.info("Starting browser");

        driver = DriverManager.getDriver("chrome");
        driver.manage().window().maximize();

        log.info("Browser started");
    }

    @After
    public void tearDown() {
        log.info("Closing browser");

        DriverManager.quitDriver();

        log.info("Browser closed");
    }

    public static WebDriver getDriver() {
        return driver;
    }
}