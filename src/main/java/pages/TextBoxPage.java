package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


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

        type(driver.findElement(fullNameField), name);
        type(driver.findElement(emailField), email);
        type(driver.findElement(currentAddressField), currentAddress);
        type(driver.findElement(permanentAddressField), permanentAddress);
    }

    public void submitForm() {
        click(driver.findElement(submitBtn));
    }

    public String getOutput() {
        return waitVisible(output).getText();
    }
}