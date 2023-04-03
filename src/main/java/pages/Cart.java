package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Cart {
    WebDriver driver;
    AppSession appSession;

    private final By CART_BUTTON = By.cssSelector("a[href='/view_cart']");

    //Product 1 Details Button in cart
    private final By PRODUCT_1_BUTTON = By.cssSelector("a[href='/product_details/2']");
    //Product 2 Details Button in cart
    private final By PRODUCT_2_BUTTON = By.cssSelector("a[href='/product_details/43']");

    //remove button
    private final By REMOVE_BUTTON = By.cssSelector("a[data-product-id='2']");


    public Cart(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }
    public void goToCart(){
        //Click Cart
        driver.findElement(CART_BUTTON).click();

    }


    public boolean userCanSeeAddedProducts() {
        try{
            driver.findElement(PRODUCT_1_BUTTON);
        } catch (NoSuchElementException e){
            return false;
        }
        try{
            driver.findElement(PRODUCT_2_BUTTON);
        } catch (NoSuchElementException e){
            return false;
        }

        return true;

    }

    public void removeOneFromCart() {
        //remove 1 t-shirt
        driver.findElement(REMOVE_BUTTON).click();
    }

}
