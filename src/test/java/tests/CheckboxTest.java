package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckboxPage;
import org.testng.annotations.Listeners;
import listeners.TestListener;

@Listeners(TestListener.class)
public class CheckboxTest extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeMethod
    public void setupPage() {
        checkboxPage = new CheckboxPage(driver);
        checkboxPage.open();
    }

    @Test
    public void testCheckboxSelection() {
        checkboxPage.expandAll();
        checkboxPage.selectAll();
        Assert.assertTrue(checkboxPage.allSelected(), "Not all checkboxes were selected!");
    }
}