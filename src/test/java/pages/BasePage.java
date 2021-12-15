package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class BasePage {

    public BasePage(){

            PageFactory.initElements(Driver.get(), this);
        }

    @FindBy(id = "react-burger-menu-btn")
    public WebElement menuButton;

    @FindBy(id = "inventory_sidebar_link")
    public WebElement allItemsLink;

    @FindBy(id = "about_sidebar_link")
    public WebElement aboutLink;

    @FindBy(id = "logout_sidebar_link")
    public WebElement logOutLink;

    @FindBy(id = "reset_sidebar_link")
    public WebElement resetAppStateLink;

    @FindBy(id = "react-burger-cross-btn")
    public WebElement menuCloseButton;

    @FindBy(css = ".shopping_cart_link")
    public WebElement cartLink;

    @FindBy(css = ".shopping_cart_badge")
    public WebElement cartBadge;

        public String getPageTitle(){
        return Driver.get().getTitle();
    }

        public void clickMenuButtonButton(){
        menuButton.click();
    }

        public void clickAllItemsLink(){ allItemsLink.click(); }

        public void clickLogOutLink(){
            logOutLink.click();
        }

        public void clickAboutLink(){
        aboutLink.click();
    }

        public void clickResetAppStateLink(){ resetAppStateLink.click(); }

        public void clickMenuCloseButton(){ menuCloseButton.click();}

        public void clickCartIcon(){ cartLink.click();}

    public boolean isCartBadgePresent() {
        try {
            cartBadge.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public String getCartBadgeCount() {
        return cartBadge.getText();
    }
}
