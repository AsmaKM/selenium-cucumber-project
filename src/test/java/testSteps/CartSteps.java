package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Home;
import pages.Cart;
import properties.TestContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class CartSteps {

    private Cart cart;
    private Home home;


    public CartSteps(TestContext textContext){
        cart = textContext.getPageManager().getCart();
    }


    @Then("I can see all the Products I added")
    public void iCanSeeAllTheProductsIAdded() {
        //I can go to cart
        cart.goToCart();
        //see all the products that's added
        cart.userCanSeeAddedProducts();
            assertTrue(cart.userCanSeeAddedProducts(),"User can not see the added products.");

        }

    @And("I can remove one I don't like")
    public void iCanRemoveOneIDonTLike() {
        cart.removeOneFromCart();
    }

}