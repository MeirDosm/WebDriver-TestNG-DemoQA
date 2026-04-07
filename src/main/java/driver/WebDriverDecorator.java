package driver;

import org.openqa.selenium.*;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WebDriverDecorator implements WebDriver, TakesScreenshot, JavascriptExecutor {

    private WebDriver driver;
    private Logger log = LoggerUtil.getLogger(WebDriverDecorator.class);

    public WebDriverDecorator(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void get(String url) {
        log.info("Navigating to: " + url);
        driver.get(url);
    }

    @Override
    public WebElement findElement(By by) {
        WebElement element = driver.findElement(by);
        return new WebElementDecorator(element, driver, log);
    }

    @Override
    public List<WebElement> findElements(By by) {
        List<WebElement> elements = driver.findElements(by);
        return elements.stream()
                .map(e -> new WebElementDecorator(e, driver, log))
                .collect(Collectors.toList());
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        log.info("Closing browser");
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        if (driver instanceof TakesScreenshot) {
            return ((TakesScreenshot) driver).getScreenshotAs(target);
        }
        throw new RuntimeException("Driver does not support screenshots");
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeAsyncScript(script, args);
    }

    public WebDriver getDriver() {
        return driver;
    }
}
