package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Product {
    WebDriver driver;
    AppSession appSession;
    private final By PRODUCT_BUTTON= By.xpath("//a[@href='/products']");
    private final By ALL_PRODUCTS_TEXT = By.xpath("//h2[text()='All Products']");
    private final By SEARCH_INPUT = By.xpath("//input[@id='search_product' and @type='text' ]");
    private final By SUBMIT_SEARCH_BUTTON= By.xpath("//button[@id='submit_search' and @type='button']");
    private final By TSHIRT1_ADD_BUTTON= By.xpath("//div[1]/div[1]/a[1][@data-product-id='2']");
    private final By TSHIRT2_ADD_BUTTON= By.xpath("//div[1]/div[1]/a[1][@data-product-id='43']");
//    private final By TSHIRT2_ADD_BUTTON= By.xpath("//a[@data-product-id='43' and text()='Add to cart']");
    private final By CONTINUE_SHOPPING_BUTTON= By.xpath("//button[text()='Continue Shopping']");
    public Product(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }

    public void goToProductsPage(){
        // Click Products
        driver.findElement(PRODUCT_BUTTON).click();
    }
    public boolean userOnProductsPage(){
            driver.findElement(ALL_PRODUCTS_TEXT).isDisplayed();
            return true;
    }


    public void enterProductToSearch(String productName){
        WebElement searchElement= driver.findElement(SEARCH_INPUT);
        searchElement.clear();
        searchElement.sendKeys(productName);
        driver.findElement(SUBMIT_SEARCH_BUTTON).click();
    }

    public void addTshirtsToCart(){
        //add 1st t-shirt

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(TSHIRT2_ADD_BUTTON)));
        driver.findElement(TSHIRT1_ADD_BUTTON).click();
        //explicit wait--- wait until the continue shopping button is clickable
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CONTINUE_SHOPPING_BUTTON)));
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        //Add 2nd t-shirt
        driver.findElement(TSHIRT2_ADD_BUTTON).click();
        //click Continue Shopping
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(CONTINUE_SHOPPING_BUTTON)));
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();

    }
}
