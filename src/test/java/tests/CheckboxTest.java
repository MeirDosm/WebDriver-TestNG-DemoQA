package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckboxPage;

public class CheckboxTest extends BaseTest {
    private CheckboxPage checkboxPage;

    @BeforeMethod
    public void setupPage() {
        driver.get("https://demoqa.com/checkbox");
        checkboxPage = new CheckboxPage(driver);
    }

    @Test
    public void testCheckboxSelection() {
        checkboxPage.expandAll();
        checkboxPage.selectAll();
        Assert.assertTrue(checkboxPage.allSelected(), "Not all checkboxes were selected!");
    }
}