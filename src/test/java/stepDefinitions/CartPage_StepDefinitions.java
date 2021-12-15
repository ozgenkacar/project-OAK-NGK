package stepDefinitions;

import io.cucumber.java.en.Then;
import pages.CartPage;

public class CartPage_StepDefinitions {

    CartPage cartPage = new CartPage();

    @Then("user click checkout button")
    public void userClickCheckoutButton() {
       cartPage.checkoutButton.click();
    }

    @Then("user click remove button for {int} item")
    public void userClickRemoveButtonForItem(int num) {
        cartPage.clickRemoveButton(num);
        System.out.println("the number " + num + " item on the line is removed from the cart");
    }

}
