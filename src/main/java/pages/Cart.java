package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;


public class Cart {
    WebDriver driver;
    AppSession appSession;

    private final By CART_BUTTON = By.xpath("//div//a[text()=' Cart']");
    //Product 1 Details Button in cart
    private final By PRODUCT_1_NAME = By.xpath("//td//a[text()='Men Tshirt']");
    //Product 2 Details Button in cart
    private final By PRODUCT_2_NAME = By.xpath("//td//a[text()='GRAPHIC DESIGN MEN T SHIRT - BLUE']");
    //remove button
    private final By REMOVE_BUTTON = By.xpath("//a[@class='cart_quantity_delete'][@data-product-id='2']");
    public Cart(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }
    public void goToCart(){
        //Click Cart
        driver.findElement(CART_BUTTON).click();

    }


    public boolean userCanSeeAddedProducts() {
        //Check the added products are on cart
            driver.findElement(PRODUCT_1_NAME).isDisplayed();
            driver.findElement(PRODUCT_2_NAME).isDisplayed();
        return true;
    }

    public void removeOneFromCart() {
        //remove 1 t-shirt
        driver.findElement(REMOVE_BUTTON).click();
    }

}
