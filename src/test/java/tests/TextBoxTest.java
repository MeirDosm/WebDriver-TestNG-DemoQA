package tests;

import org.testng.annotations.*;
import pages.TextBoxPage;
import org.testng.annotations.Listeners;
import listeners.TestListener;
import org.testng.asserts.SoftAssert;

@Listeners(TestListener.class)
public class TextBoxTest extends BaseTest {
    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setupPage() {
        textBoxPage = new TextBoxPage(driver);
        textBoxPage.open();
    }

    @Test
    public void testTextBoxForm() {
        textBoxPage.fillForm(
                "John Doe",
                "john@example.com",
                "123 Main St",
                "456 Elm St"
        );
        textBoxPage.submitForm();

        String output = textBoxPage.getOutput();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(output.contains("John Doe"), "Name is incorrect");
        softAssert.assertTrue(output.contains("john@example.com"), "Email is incorrect");
        softAssert.assertTrue(output.contains("123 Main St"), "Current address is incorrect");
        softAssert.assertTrue(output.contains("456 Elm St"), "Permanent address is incorrect");

        softAssert.assertAll();
    }
}