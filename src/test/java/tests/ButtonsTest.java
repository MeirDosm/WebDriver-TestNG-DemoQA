package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.ButtonsPage;
import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)
public class ButtonsTest extends BaseTest {

    private ButtonsPage buttonsPage;

    @BeforeMethod
    public void setupPage() {
        buttonsPage = new ButtonsPage(driver);
        buttonsPage.open();
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
}