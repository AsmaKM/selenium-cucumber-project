package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Ad;
import pages.Product;
import properties.TestContext;
import static utils.AssertAndLog.assertTrueAndLog;


public class ProductSteps {

    private Product product;
    private Ad ad;
    public ProductSteps(TestContext textContext){
        product = textContext.getPageManager().getProduct();
        ad=textContext.getPageManager().getAd();
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
        assertTrueAndLog(product.userOnProductsPage(),"User is not on Products Page");
    }


    @And("I can search {string} and add two to cart")
    public void iCanSearchAndAddTwoToCart(String productName) throws InterruptedException {
        product.enterProductToSearch(productName);
        //Add 2 tshirts
        //if there's an ad, close it
        ad.closePopUpAd();

        product.addTshirtsToCart();
    }





}
