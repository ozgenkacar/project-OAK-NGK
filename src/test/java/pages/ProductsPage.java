package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;
import utils.HELPER;

import java.util.List;

public class ProductsPage extends BasePage {

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    public List<WebElement> productsList;

    @FindBy(xpath = "//button[contains(text(),'ADD TO CART')]")
    public List<WebElement> addToCartButton;

    @FindBy(xpath = "//button[contains(text(),'REMOVE')]")
    public List<WebElement> removeButton;

    @FindBy(xpath = "//*[@class='inventory_item_desc']")
    public List<WebElement> itemDescriptions;

    @FindBy(xpath = "//*[@class='inventory_item_name']")
    public List<WebElement> itemNames;



    public int getNumberOfProduct(){
        return HELPER.getListOfString(productsList).size();
    }


    public void addProductToCart(String itemName) {
        WebElement addToCartButtonForSelectedItem = Driver.get().findElement(By.xpath("//*[contains(text(),'"+itemName+"')]//..//..//..//*[@class='btn btn_primary btn_small btn_inventory']"));

        addToCartButtonForSelectedItem.click();
    }

    public void removeProductFromCart(int index) {
        removeButton.get(index - 1).click();
    }





}
