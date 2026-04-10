package tests;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigReader;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;


public class BaseTest {
    protected WebDriver driver;
    protected Logger log = LoggerUtil.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        String env = System.getProperty("env", "dev");
        ConfigReader config = ConfigReader.getInstance(env);

        String browser = config.get("browser");
        String url = config.get("url");

        log.info("=== Starting test on browser: " + browser + ", URL: " + url + " ===");

        driver = DriverManager.getDriver(browser);
        driver.get(url);
        driver.manage().window().maximize();

        log.debug("Driver initialized and URL opened");
    }

    @AfterMethod
    public void tearDown() {
        log.info("=== Closing browser ===");
        DriverManager.quitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}