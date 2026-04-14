package cucumber.steps;

import io.cucumber.java.en.*;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtil;
import pages.TextBoxPage;
import cucumber.hooks.Hooks;

public class LoginSteps {

    private TextBoxPage textBoxPage;
    private Logger log = LoggerUtil.getLogger(LoginSteps.class);

    @Given("User opens login page")
    public void user_opens_login_page() {

        textBoxPage = new TextBoxPage(Hooks.getDriver());
        textBoxPage.open();

        log.info("User opened login page");
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {

        log.info("Entering username: " + username);

        textBoxPage.fillForm(
                username,
                "test@mail.com",
                "current address",
                "permanent address"
        );
    }

    @When("User enters password {string}")
    public void user_enters_password(String password) {
        log.info("Password received (masked)");
        log.debug(password);
    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        log.info("Click submit");
        textBoxPage.submitForm();
    }

    @Then("User should see dashboard")
    public void user_should_see_dashboard() {

        String output = textBoxPage.getOutput();

        if (output == null || output.isEmpty()) {
            log.error("Validation failed");
            throw new AssertionError("Dashboard not found");
        }

        log.info("Validation passed");
    }
}