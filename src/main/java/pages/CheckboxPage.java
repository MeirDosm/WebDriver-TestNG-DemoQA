package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class CheckboxPage extends AbstractPage {

    private By expandAllBtn = By.cssSelector("button[title='Expand all']");
    private By checkboxes = By.cssSelector(".rc-tree-checkbox");

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    public void expandAll() {
        hideAd(By.id("adplus-banner"));
        List<WebElement> expandBtnList = driver.findElements(expandAllBtn);
        if (!expandBtnList.isEmpty()) {
            click(expandBtnList.get(0));
        } else {
            System.out.println("Expand All button not present, skipping.");
        }
    }

    public void selectAll() {
        hideAd(By.id("adplus-banner"));
        List<WebElement> boxes = driver.findElements(checkboxes);
        for (WebElement box : boxes) {
            if (!box.getAttribute("class").contains("rc-tree-checkbox-checked")) {
                click(box);
            }
        }
    }

    public boolean allSelected() {
        List<WebElement> boxes = driver.findElements(checkboxes);
        for (WebElement box : boxes) {
            if (!box.getAttribute("class").contains("rc-tree-checkbox-checked")) {
                return false;
            }
        }
        return true;
    }
}