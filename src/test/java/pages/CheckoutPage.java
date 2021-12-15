package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.HELPER;

public class CheckoutPage extends BasePage{

    @FindBy(css = "#first-name")
    public WebElement firstName;

    @FindBy(css = "#last-name")
    public WebElement lastName;

    @FindBy(css = "#postal-code")
    public WebElement zipCode;

    @FindBy(css = "#continue")
    public WebElement continueButton;

    @FindBy(css = "#cancel")
    public WebElement cancelButton;

    @FindBy(css = "#finish")
    public WebElement finishButton;

    @FindBy(xpath = "//*[@class='complete-header']")
    public WebElement orderCompleteHeader;

    @FindBy(xpath = "//h3")
    public WebElement errorMessage;

    @FindBy(xpath = "//*[@class='inventory_item_price']")
    public WebElement itemPrice;

    public void setFirstName(String name){
        HELPER.waitForStaleElement(firstName);
        firstName.sendKeys(name);
        System.out.println("the user entered first name");
    }

    public void setLastName(String lastName1){
        HELPER.waitForStaleElement(lastName);
        lastName.sendKeys(lastName1);
        System.out.println("the user entered last name");
    }
    public void setZipCode(String postalCode){
        HELPER.waitForStaleElement(zipCode);
        zipCode.sendKeys(postalCode);
        System.out.println("the user entered zipcode");
    }

    public void clickContinueButton(){
        HELPER.waitForClickablility(continueButton,1);
        continueButton.click();
        System.out.println("the user clicked the continue button");
    }

    public void clickCancelButton(){
        HELPER.waitForClickablility(cancelButton,1);
        cancelButton.click();
        System.out.println("the user clicked the cancel button");
    }

    public void clickFinishButton(){
        HELPER.waitForStaleElement(finishButton);
        finishButton.click();
        System.out.println("the user clicked finish button");
    }

    public String getOrderCompleteHeader(){
        return orderCompleteHeader.getText();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
