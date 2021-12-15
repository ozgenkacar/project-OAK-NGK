package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Driver;
import utils.HELPER;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(css = ".cart_item")
    public List<WebElement> items;

    @FindBy(id="checkout")
    public WebElement checkoutButton;

    @FindBy(xpath = "//*[@class='btn btn_secondary btn_small cart_button']")
    public List<WebElement> removeButtons;


    public int getItemsCount() {
        return items.size();
    }

    public void clickRemoveButton(int num){
        HELPER.waitForSpinnerNotVisible(5, Driver.get());
            removeButtons.get(num-1).click();

    }

}
