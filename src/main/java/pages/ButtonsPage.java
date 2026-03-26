package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.HighlightUtil;

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

    public void doubleClick() {
        hideAd(By.id("adplus-banner"));
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(doubleClickBtn));
        HighlightUtil.highlightElement(driver, btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        new Actions(driver).pause(Duration.ofMillis(200)).doubleClick(btn).perform();
    }

    public void rightClick() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(rightClickBtn));
        HighlightUtil.highlightElement(driver, btn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btn);
        new Actions(driver).pause(Duration.ofMillis(200)).contextClick(btn).perform();
    }

    public void clickMe() {
        WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(clickMeBtn));
        click(btn);
    }

    public String getDoubleClickMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(doubleClickMsg)).getText();
        } catch (Exception e) {
            return "DoubleClick message not found";
        }
    }

    public String getRightClickMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(rightClickMsg)).getText();
        } catch (Exception e) {
            return "RightClick message not found";
        }
    }

    public String getClickMeMessage() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(clickMeMsg)).getText();
        } catch (Exception e) {
            return "ClickMe message not found";
        }
    }
}