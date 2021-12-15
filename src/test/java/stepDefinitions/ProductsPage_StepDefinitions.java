package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.ProductsPage;
import utils.Driver;
import utils.HELPER;

import java.util.List;

public class ProductsPage_StepDefinitions {

    BasePage basePage = new BasePage();
    ProductsPage productsPage = new ProductsPage();

    @When("I add an {int} item to cart")
    public void iAddAnItemToCart(int index) {
        List<WebElement> addToCartButtons = Driver.get().findElements(By.xpath("//button[contains(text(),'ADD TO CART')]"));
        addToCartButtons.get(index-1).click();
    }

    @When("I remove the item from cart")
    public void iRemoveTheItemFromCart() {
        productsPage.removeProductFromCart(1);
    }

    @Then("cart badge count disappears")
    public void cartBadgeCountDisappears() {
        Assert.assertFalse(basePage.isCartBadgePresent());
    }

    @Then("cart badge count is {string}")
    public void cartBadgeCountIs(String count) {
        Assert.assertEquals(basePage.getCartBadgeCount(), count);
    }

    @Then("user verify that {int} items at the inventory")
    public void userVerifyThatItemsAtTheInventory(int num){
        HELPER.wait(5);
        List<WebElement> productList = Driver.get().findElements(By.xpath("//*[@class='inventory_item_name']"));

        System.out.println("Number of product is : "+ productList.size());

         Assert.assertEquals(productList.size(),num);

        }


    @Then("user get list of all items at the inventory")
    public void userGetListOfAllItemsAtTheInventory() {
        List<WebElement> productList = Driver.get().findElements(By.xpath("//*[@class='inventory_item_name']"));

        System.out.println("Number of product is : "+ productList.size());

        for (WebElement webElement : productList) {
            String name = webElement.getText();
            System.out.println(name);
        }
    }

    @Then("user verify that when select {string} title is same with fallowing page")
    public void userVerifyThatWhenSelectTitleIsSameWithFallowingPage(String itemName) {
        List<WebElement> productList = Driver.get().findElements(By.xpath("//*[@class='inventory_item_name']"));

        for (WebElement webElement : productList) {
            HELPER.wait(1);
            if (webElement.getText().equals(itemName)){
                webElement.click();
                break;
            }
        }
        HELPER.wait(1);
        WebElement newName= Driver.get().findElement(By.xpath("//*[@class='inventory_details_name large_size']"));

        Assert.assertEquals(newName.getText(),itemName);

    }

    @Then("user verify that when select {string} item price is same with fallowing page")
    public void userVerifyThatWhenSelectItemPriceIsSameWithFallowingPage(String selectedItem) {
        WebElement firstPrice = Driver.get().findElement(By.xpath("//*[contains(text(),'"+selectedItem+"')]//..//..//..//*[@class='pricebar']/div[@class='inventory_item_price']"));
        String firstPagePrice =firstPrice.getText();
        List<WebElement> productList = Driver.get().findElements(By.xpath("//*[@class='inventory_item_name']"));

        System.out.println("first page price is "+firstPrice.getText());
        for (WebElement webElement : productList) {
            HELPER.wait(1);
            if (webElement.getText().equals(selectedItem)){
                webElement.click();
                break;
            }
        }
        HELPER.wait(3);
        WebElement newPrice= Driver.get().findElement(By.xpath("//*[@class='inventory_details_price']"));
        String secondPagePrice =newPrice.getText();
        System.out.println("second page price is "+secondPagePrice);
        Assert.assertEquals(secondPagePrice,firstPagePrice);
    }


    @Then("user verify that when select {string} item description is same with fallowing page")
    public void userVerifyThatWhenSelectItemDescriptionIsSameWithFallowingPage(String selectedItem) {
        WebElement firstDescription = Driver.get().findElement(By.xpath("//*[contains(text(),'"+selectedItem+"')]//..//..//..//*[@class='inventory_item_desc']"));
        String firstPageDescription =firstDescription.getText();

        List<WebElement> productList = Driver.get().findElements(By.xpath("//*[@class='inventory_item_name']"));

        System.out.println("first page description is "+firstPageDescription);
        for (WebElement webElement : productList) {
            HELPER.wait(1);
            if (webElement.getText().equals(selectedItem)){
                webElement.click();
                break;
            }
        }
        HELPER.wait(3);
        WebElement newDescription= Driver.get().findElement(By.xpath("//*[@class='inventory_details_desc large_size']"));
        String secondPageDescription =newDescription.getText();
        System.out.println("second page price is "+secondPageDescription);
        Assert.assertEquals(secondPageDescription,firstPageDescription);
    }

    @Then("user click add to cart button to buy {string}")
    public void userClickAddToCartButtonToBuy(String itemName) {
       productsPage.addProductToCart(itemName);
        }


    // when "add to cart" button clicked, "remove" button is appear
    @Then("user verify that added to cart button at the {string} is clicked")
    public void userVerifyThatAddedToCartButtonAtTheIsClicked(String selectedItem) {
        WebElement removeButton = Driver.get().findElement(By.xpath("//*[contains(text(),'"+selectedItem+"')]//..//..//..//*[@class='btn btn_secondary btn_small btn_inventory']"));
        Assert.assertTrue(removeButton.isDisplayed());
    }

    @Then("user click cart icon")
    public void userClickCartIcon() {
        productsPage.cartBadge.click();
    }

    @Then("user see {int} item on the cart")
    public void userSeeItemOnTheCart(int num) {
        System.out.println("There is/are " + productsPage.cartBadge.getText()+ " item(s) at the cart");
        int itemNumberAtTheCart = Integer.parseInt(productsPage.cartBadge.getText());
        Assert.assertEquals(itemNumberAtTheCart,num);
    }
}

