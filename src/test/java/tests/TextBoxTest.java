package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.TextBoxPage;
import org.testng.annotations.Listeners;
import listeners.TestListener;

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
        Assert.assertTrue(output.contains("John Doe"));
        Assert.assertTrue(output.contains("john@example.com"));
        Assert.assertTrue(output.contains("123 Main St"));
        Assert.assertTrue(output.contains("456 Elm St"));
    }
}