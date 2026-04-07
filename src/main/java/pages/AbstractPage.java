package pages;

import driver.WebElementDecorator;
import org.openqa.selenium.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected Logger log = LogManager.getLogger(this.getClass());
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void click(WebElement element) {

        if (element instanceof WebElementDecorator) {
            element = ((WebElementDecorator) element).getWrappedElement();
        }

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);

        new WebElementDecorator(element, driver, log).click();
    }

    protected void type(WebElement element, String text) {

        if (element instanceof WebElementDecorator) {
            element = ((WebElementDecorator) element).getWrappedElement();
        }

        new WebElementDecorator(element, driver, log).sendKeys(text);
    }

    protected void hideAd(By locator) {
        if (!driver.findElements(locator).isEmpty()) {
            WebElement ad = driver.findElement(locator);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].style.display='none';", ad);
        }
    }

    protected WebElement waitVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}