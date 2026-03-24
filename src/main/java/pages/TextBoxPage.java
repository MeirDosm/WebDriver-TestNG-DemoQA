package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TextBoxPage extends AbstractPage {

    private By fullNameField = By.id("userName");
    private By emailField = By.id("userEmail");
    private By currentAddressField = By.id("currentAddress");
    private By permanentAddressField = By.id("permanentAddress");
    private By submitBtn = By.id("submit");
    private By output = By.id("output");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm(String name, String email, String currentAddress, String permanentAddress) {
        hideAd(By.id("adplus-banner"));

        WebElement nameField = driver.findElement(fullNameField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameField);
        nameField.clear();
        nameField.sendKeys(name);

        WebElement emailFld = driver.findElement(emailField);
        emailFld.clear();
        emailFld.sendKeys(email);

        WebElement currentFld = driver.findElement(currentAddressField);
        currentFld.clear();
        currentFld.sendKeys(currentAddress);

        WebElement permanentFld = driver.findElement(permanentAddressField);
        permanentFld.clear();
        permanentFld.sendKeys(permanentAddress);
    }

    public void submitForm() {
        WebElement btn = driver.findElement(submitBtn);
        click(btn);
    }

    public String getOutput() {
        return waitVisible(output).getText();
    }
}