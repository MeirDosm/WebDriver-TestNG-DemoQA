package driver;

import org.openqa.selenium.*;
import utils.HighlightUtil;
import org.apache.logging.log4j.Logger;
import java.util.List;

public class WebElementDecorator implements WebElement {

    private WebElement element;
    private WebDriver driver;
    private Logger log;

    public WebElementDecorator(WebElement element, WebDriver driver, Logger log) {
        this.element = element;
        this.driver = driver;
        this.log = log;
    }

    public WebElement getWrappedElement() {
        return element;
    }

    @Override
    public void click() {
        HighlightUtil.highlightElement(driver, element);
        log.info("Clicking element: " + element);
        element.click();
    }

    @Override
    public void sendKeys(CharSequence... keysToSend) {
        HighlightUtil.highlightElement(driver, element);
        log.info("Typing into element: " + element + " value: " + String.join("", keysToSend));
        element.sendKeys(keysToSend);
    }

    @Override public void submit() { element.submit(); }
    @Override public void clear() { element.clear(); }
    @Override public String getTagName() { return element.getTagName(); }
    @Override public String getAttribute(String name) { return element.getAttribute(name); }
    @Override public boolean isSelected() { return element.isSelected(); }
    @Override public boolean isEnabled() { return element.isEnabled(); }
    @Override public String getText() { return element.getText(); }

    @Override
    public List<WebElement> findElements(By by) {
        return element.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return element.findElement(by);
    }

    @Override public boolean isDisplayed() { return element.isDisplayed(); }
    @Override public Point getLocation() { return element.getLocation(); }
    @Override public Dimension getSize() { return element.getSize(); }
    @Override public Rectangle getRect() { return element.getRect(); }
    @Override public String getCssValue(String propertyName) { return element.getCssValue(propertyName); }
    @Override public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return element.getScreenshotAs(target);
    }
}