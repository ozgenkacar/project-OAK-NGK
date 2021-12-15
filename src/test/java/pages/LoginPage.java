package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigurationReader;
import utils.Driver;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "login-button")
    public WebElement loginButton;

    @FindBy(id = "user-name")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(tagName = "h3")
    public WebElement errorMessage;


    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void login() {
        login(ConfigurationReader.getProperty("standard.username"), ConfigurationReader.getProperty("password"));
    }

    public void login(String role) {

        String username = "";
        String password = ConfigurationReader.getProperty("password");

        username = switch (role) {
            case "standard" -> ConfigurationReader.getProperty("standard.username");
            case "locked" -> ConfigurationReader.getProperty("locked.username");
            case "problem" -> ConfigurationReader.getProperty("problem.username");
            case "performance" -> ConfigurationReader.getProperty("performance.username");
            default -> throw new RuntimeException("Invalid role!");
        };
        login(username, password);
    }

    public String getLoginErrorMessage() {
        return errorMessage.getText();
    }

}
