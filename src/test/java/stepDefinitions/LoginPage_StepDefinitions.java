package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.LoginPage;
import utils.ConfigurationReader;
import utils.Driver;
import utils.HELPER;

import java.lang.invoke.MethodHandles;

public class LoginPage_StepDefinitions {
    Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    LoginPage loginPage = new LoginPage();
    BasePage basePage = new BasePage();

    @Then("user logs in as standard user")
    public void user_logs_in_as_standard_user() {
        logger.debug("user logs in as standard user");
        loginPage.login("standard.user", "password");

        Assert.assertEquals("Swag Labs", Driver.get().getTitle());


    }


    @Given("user is on the login page")
    public void user_is_on_the_login_page(){
        logger.debug("user is on the login page");
        Driver.get().get(ConfigurationReader.getProperty("url"));
        loginPage.loginButton.click();
    }

    @Then("user logs in as {string}")
    public void user_logs_in_as(String string) {
        loginPage.login(string);
    }

    @Then("user verifies that {string} page title is displayed")
    public void user_verifies_that_page_title_is_displayed(String string) {
        logger.debug("user verifies page title is correct");
        Assert.assertEquals(string, Driver.get().getTitle());
    }

    @Then("user enters {string} username and {string} password")
    public void user_enters_username_and_password(String string, String string2) {
        loginPage.login(string, string2);
    }

    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String string) {
        Assert.assertEquals(string, loginPage.errorMessage.getText());

    }

    @Then("user verifies that {string} error message is displayed")
    public void userVerifiesThatErrorMessageIsDisplayed(String string) {
HELPER.waitForStaleElement(loginPage.errorMessage);
                Assert.assertEquals(loginPage.getLoginErrorMessage(),string);
    }
}
