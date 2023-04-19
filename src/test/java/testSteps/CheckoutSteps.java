package testSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.Checkout;
import pages.Home;
import pages.Ad;
import properties.TestContext;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static utils.AssertAndLog.assertTrueAndLog;

public class CheckoutSteps {

    private Home home;
    private Checkout checkout;
    private Ad ad;
   public CheckoutSteps(TestContext textContext){ checkout=textContext.getPageManager().getCheckout();}

    @And("I can place an order with card information")
    public void iCanPlaceAnOrderWithCardInformation() throws InterruptedException {
        //Click Proceed to Checkout and confirm it's the checkout Page
        checkout.goToCheckoutPage();
        //if there's an ad
        assertTrueAndLog(checkout.userOnCheckOutPage(), "User is not on Checkout Page");

        //I can proceed to place an order
        checkout.UserCanProceedToPlaceOrder();
        assertTrueAndLog(checkout.UserOnPaymentPage(),"User can not proceed to Payment Page.");


        //pay and confirm order
        checkout.attemptToPayAndConfirmOrder();
        assertTrueAndLog(checkout.confirmPlacedOrder(),"The order was not placed Successfully.");
    }

    @Then("I click the download invoice button")
    public void iCanDownloadTheInvoice() throws InterruptedException {
        checkout.downloadTheInvoice();

    }


    @Then("the invoice is downloaded")
    public void theInvoiceIsDownloaded() throws IOException {
        //wait until the invoice is downloaded
        // Create object of SimpleDateFormat class and decide the format
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm");
        Date start_date=new Date();
        Date end_date=new Date();
        int secs = start_date.getSeconds();
        start_date.setSeconds(secs - 30);
        int mm= end_date.getMinutes();
        end_date.setMinutes(mm+1);

        checkout.waitForFileToDownload(20000, "C:\\Users\\afawzia\\Downloads", end_date, start_date, "invoice");
//        assertTrueAndLog(checkout.waitForFileToDownload(20000, "C:\\Users\\afawzia\\Downloads", end_date, start_date, "invoice" ),"The file was not downloaded.");
        //validate the downloaded invoice
            assertTrueAndLog(checkout.theInvoiceExists("C:\\Users\\afawzia\\Downloads", end_date, start_date, "invoice"), "The invoice is not downloaded.");

    }


}
