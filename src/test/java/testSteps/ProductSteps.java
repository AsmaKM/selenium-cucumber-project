package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Ad;
import pages.Home;
import pages.Product;
import properties.TestContext;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ProductSteps {

    private Product product;
    private Home home;
    public ProductSteps(TestContext textContext){
        product = textContext.getPageManager().getProduct();
    }

    @And("I go to the Products Page")
    public void iGoToTheProductsPage() {
        //From home page click products
        product.goToProductsPage();
    }

    @Then("I can see the Products page")
    public void iCanSeeTheProductsPage() {
        //'ALL Products' is Displayed
        product.userOnProductsPage();
        assertTrue(product.userOnProductsPage(),"User is not on Products Page");


    }


    @And("I can search {string}")
    public void iCanSearch(String productName) throws InterruptedException {
    product.enterProductToSearch(productName);
    }


    @And("I can add two tshirts to cart")
    public void iCanAddTwoTshirtsToCart() throws InterruptedException {
        //Add 2 tshirts
        product.addTshirtsToCart();


    }


}
