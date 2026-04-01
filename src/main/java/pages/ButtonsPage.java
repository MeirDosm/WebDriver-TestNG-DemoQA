package pages;

import driver.WebElementDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class ButtonsPage extends AbstractPage {

    private By doubleClickBtn = By.xpath("//button[contains(text(),'Double Click Me')]");
    private By rightClickBtn = By.id("rightClickBtn");
    private By clickMeBtn = By.xpath("//button[text()='Click Me']");

    private By doubleClickMsg = By.id("doubleClickMessage");
    private By rightClickMsg = By.id("rightClickMessage");
    private By clickMeMsg = By.id("dynamicClickMessage");

    public ButtonsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://demoqa.com/buttons");
    }

    public void doubleClick() {
        hideAd(By.id("adplus-banner"));
        WebElement btn = waitClickable(doubleClickBtn);

        WebElement rawBtn = btn instanceof WebElementDecorator
                ? ((WebElementDecorator) btn).getWrappedElement()
                : btn;
        WebDriver rawDriver = driver instanceof driver.WebDriverDecorator
                ? ((driver.WebDriverDecorator) driver).getDriver()
                : driver;

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rawBtn);
        new Actions(rawDriver).pause(Duration.ofMillis(200)).doubleClick(rawBtn).perform();
    }

    public void rightClick() {
        WebElement btn = waitClickable(rightClickBtn);

        WebElement rawBtn = btn instanceof WebElementDecorator
                ? ((WebElementDecorator) btn).getWrappedElement()
                : btn;
        WebDriver rawDriver = driver instanceof driver.WebDriverDecorator
                ? ((driver.WebDriverDecorator) driver).getDriver()
                : driver;

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rawBtn);
        new Actions(rawDriver).pause(Duration.ofMillis(200)).contextClick(rawBtn).perform();
    }

    public void clickMe() {
        WebElement btn = waitClickable(clickMeBtn);
        click(btn);
    }

    public String getDoubleClickMessage() {
        try {
            return waitVisible(doubleClickMsg).getText();
        } catch (Exception e) {
            return "DoubleClick message not found";
        }
    }

    public String getRightClickMessage() {
        try {
            return waitVisible(rightClickMsg).getText();
        } catch (Exception e) {
            return "RightClick message not found";
        }
    }

    public String getClickMeMessage() {
        try {
            return waitVisible(clickMeMsg).getText();
        } catch (Exception e) {
            return "ClickMe message not found";
        }
    }
}