package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Product {
    WebDriver driver;
    AppSession appSession;

    private final By PRODUCT_BUTTON = By.cssSelector("a[href='/products']");

    private final By ALLPRODUCTS_BUTTON= By.cssSelector("h2[class]");

    private final By SEARCH_BUTTON= By.cssSelector("input[id='search_product']");

    private final By SUBMIT_SEARCH_BUTTON= By.cssSelector("button[id='submit_search']");

    private final By TSHIRT1_ADD_BUTTON= By.cssSelector("a[data-product-id='2']");

    private final By TSHIRT2_ADD_BUTTON= By.cssSelector("a[data-product-id='43']");

    private final By CONTINUE_SHOPPING_BUTTON= By.cssSelector("button[class='btn btn-success close-modal btn-block']");

    public Product(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }

    public void goToProductsPage(){
        // Click Products
        driver.findElement(PRODUCT_BUTTON).click();

    }
    public boolean userOnProductsPage(){
        try{
            driver.findElement(ALLPRODUCTS_BUTTON);
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }


    public void enterProductToSearch(String productName) throws InterruptedException {
        Thread.sleep(2000);
        WebElement searchElement= driver.findElement(SEARCH_BUTTON);
        searchElement.clear();
        searchElement.sendKeys(productName);
        driver.findElement(SUBMIT_SEARCH_BUTTON).click();

    }

    public void addTshirtsToCart() throws InterruptedException {
        //add 1st t-shirt
        driver.findElement(TSHIRT1_ADD_BUTTON).click();
        Thread.sleep(3000);
        //click Continue Shopping
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        //Add 2nd t-shirt
        driver.findElement(TSHIRT2_ADD_BUTTON).click();
        Thread.sleep(3000);

        //click Continue Shopping
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();

    }
}
