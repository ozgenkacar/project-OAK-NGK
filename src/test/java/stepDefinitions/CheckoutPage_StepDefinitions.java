package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CheckoutPage;

public class CheckoutPage_StepDefinitions {
    CheckoutPage checkoutPage = new CheckoutPage();


    @Then("user enter {string} as a firstname")
    public void userEnterAsAFirstname(String name) {
        checkoutPage.setFirstName(name);
    }

    @Then("user enter {string} as a lastname")
    public void userEnterAsALastname(String lastName) {
        checkoutPage.setLastName(lastName);
    }

    @Then("user enter {string} as a postal-zip code")
    public void userEnterAsAPostalZipCode(String zipcode) {
        checkoutPage.setZipCode(zipcode);
    }

    @Then("user click continue button")
    public void userClickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Then("user click finish button")
    public void userClickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Then("user click cancel button")
    public void userClickCancelButton() {
        checkoutPage.clickCancelButton();
        System.out.println(" the user cancel the checkout process ");
    }

    @Then("user verify that {string} message displayed")
    public void userVerifyThatMessageDisplayed(String message) {
       Assert.assertEquals(checkoutPage.getOrderCompleteHeader(),message);
        System.out.println(checkoutPage.getOrderCompleteHeader()+" message is displayed" );
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: First Name is required");
        System.out.println("'Error: First Name is required' error message is displayed");
    }

    @Then("user check that the product price is {string} at the payment tab")
    public void userCheckThatTheProductPriceIsAtThePaymentTab(String price) {
//int checkoutItemPrice = Integer.parseInt(checkoutPage.itemPrice.getText());
Assert.assertEquals(checkoutPage.itemPrice.getText(),price);
    }
}
