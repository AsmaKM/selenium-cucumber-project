package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Ad;
import pages.Home;
import pages.Cart;
import properties.TestContext;

import static utils.AssertAndLog.assertTrueAndLog;

public class CartSteps {

    private Cart cart;
    private Home home;
    private Ad ad;

    public CartSteps(TestContext textContext){
        cart = textContext.getPageManager().getCart();
    }


    @Then("I can see all the Products I added")
    public void iCanSeeAllTheProductsIAdded() throws InterruptedException {
        //I can go to cart
        cart.goToCart();
        //If there's an ad after going to cart


        //see all the products that's added
        cart.userCanSeeAddedProducts();
        assertTrueAndLog(cart.userCanSeeAddedProducts(),"User can not see the added products.");

        }

    @And("I can remove one I don't like")
    public void iCanRemoveOneIDonTLike() {
        cart.removeOneFromCart();
    }

}