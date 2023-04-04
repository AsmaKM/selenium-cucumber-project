package testSteps;

import io.cucumber.java.en.And;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Checkout;
import pages.Home;
import pages.Product;
import properties.TestContext;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutSteps {

    private Home home;
    private Checkout checkout;

    public CheckoutSteps(TestContext textContext){ checkout=textContext.getPageManager().getCheckout();}

    @And("I can go to checkout page")
    public void iCanGoToCheckoutPage() {
        //Click Proceed to Checkout and confirm it's the checkout Page
        checkout.goToCheckoutPage();
        assertTrue(checkout.userOnCheckOutPage(), "User is not on Checkout Page");

    }

    @And("I can proceed to place order")
    public void iCanProceedToPlaceOrder() {
        checkout.UserCanProceedToPlaceOrder();
        assertTrue(checkout.UserOnPaymentPage(),"User can not proceed to Payment Page.");

    }

    @And("I can place an order with NameOnCard: {string}, CardNumber:{int}, CVC: {int}, ExpiryMonth: {int} and ExpiryYear: {int}")
    public void iCanPlaceAnOrderWithNameOnCardCardNumberCVCExpiryMonthAndExpiryYear(String nameOnCard, int cardNumber, int cvc, int expiryMonth, int expiryYear) {
        checkout.attemptToPayAndConfirmOrder(nameOnCard, cardNumber, cvc, expiryMonth, expiryYear);
        assertTrue(checkout.confirmPlacedOrder(),"The order was not placed Successfully.");
    }

    @Then("I click the download invoice button")
    public void iCanDownloadTheInvoice() {
        checkout.downloadTheInvoice();

    }


    @Then("the invoice is downloaded")
    public void theInvoiceIsDownloaded() throws InterruptedException {



            // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm");
        Date date1=new Date();
        Date date=new Date();

        int mm= date.getMinutes();
        date.setMinutes(mm+1);



        assertTrue(checkout.theInvoiceExists("C:\\Users\\afawzia\\Downloads", date, date1, "invoice"),"The invoice is not downloaded.");



        // This is finally working!
        // 1. Commit
        // 2. Push to remote
        // 3. Pull request
        // 4. Merge
    }


}
