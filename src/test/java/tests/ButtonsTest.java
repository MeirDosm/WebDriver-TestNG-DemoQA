package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.ButtonsPage;

public class ButtonsTest {

    private WebDriver driver;
    private ButtonsPage buttonsPage;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/buttons");
        buttonsPage = new ButtonsPage(driver);
    }

    @Test
    public void testButtons() {
        buttonsPage.doubleClick();
        String doubleMsg = buttonsPage.getDoubleClickMessage();
        Assert.assertEquals(doubleMsg, "You have done a double click", "Double click failed");

        buttonsPage.rightClick();
        String rightMsg = buttonsPage.getRightClickMessage();
        Assert.assertEquals(rightMsg, "You have done a right click", "Right click failed");

        buttonsPage.clickMe();
        String clickMsg = buttonsPage.getClickMeMessage();
        Assert.assertEquals(clickMsg, "You have done a dynamic click", "Click Me failed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}