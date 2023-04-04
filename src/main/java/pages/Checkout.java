package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.File;
import java.util.Date;

public class Checkout {

    WebDriver driver;
    AppSession appSession;

    private final By PROCEED_TO_CHECKOUT_BUTTON = By.cssSelector("a[class='btn btn-default check_out']");

    private final By TOTAL_AMOUNT_TEXT = By.cssSelector("td[colspan='2'] b");

    private final By PLACE_ORDER_BUTTON = By.cssSelector("a[href='/payment']");
    private final By PAYMENT_TEXT = By.cssSelector("h2[class='heading']");
    private final By NAME_ON_CARD_INPUT = By.cssSelector("input[class='form-control'][data-qa='name-on-card']");
    private final By CARD_NUMBER_INPUT = By.cssSelector("input[name='card_number'][data-qa='card-number']");
    private final By CVC_INPUT = By.cssSelector("input[name='cvc'][data-qa='cvc']");
    private final By EXPIRY_MONTH_INPUT = By.cssSelector("input[class='form-control card-expiry-month'][data-qa='expiry-month']");
    private final By EXPIRY_YEAR_INPUT = By.cssSelector("input[name='expiry_year'][data-qa='expiry-year']");
    private final By PAY_AND_CONFIRM_ORDER_BUTTON = By.cssSelector("button[class='form-control btn btn-primary submit-button']");

    private final By CONFIRMATION_TEXT = By.cssSelector("h2[class='title text-center'] b");
    private final By DOWNLOAD_INVOICE_BUTTON = By.cssSelector("a[class='btn btn-default check_out']");



    public Checkout(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }

    public void goToCheckoutPage(){
        // Click Proceed to checkout
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();

    }
    public boolean userOnCheckOutPage(){
        try{
            //Find the "Total Amount" to confirm user is on Checkout Page
            driver.findElement(TOTAL_AMOUNT_TEXT);
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }


    public void UserCanProceedToPlaceOrder() {
        driver.findElement(PLACE_ORDER_BUTTON).click();
    }
    public boolean UserOnPaymentPage() {
        try{
            driver.findElement(PAYMENT_TEXT);
        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public void attemptToPayAndConfirmOrder(String nameOnCard, int cardNumber, int cvc, int expiryMonth, int expiryYear) {
        //
        WebElement searchElement= driver.findElement(NAME_ON_CARD_INPUT);
        searchElement.clear();
        searchElement.sendKeys(nameOnCard);
        //
        searchElement= driver.findElement(CARD_NUMBER_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(cardNumber));
        //
        searchElement= driver.findElement(CVC_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(cvc));
        //
        searchElement= driver.findElement(EXPIRY_MONTH_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(expiryMonth));
        //
        searchElement= driver.findElement(EXPIRY_YEAR_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(expiryYear));

        // input card information
//        driver.findElement(NAME_ON_CARD_INPUT).sendKeys(nameOnCard);
//        driver.findElement(CARD_NUMBER_INPUT).sendKeys(String.valueOf(cardNumber));
//        driver.findElement(CVC_INPUT).sendKeys(String.valueOf(cvc));
//        driver.findElement(EXPIRY_MONTH_INPUT).sendKeys(String.valueOf(expiryMonth));
//        driver.findElement(EXPIRY_YEAR_INPUT).sendKeys(String.valueOf(expiryYear));


        // click pay and confirm order to proceed
        driver.findElement(PAY_AND_CONFIRM_ORDER_BUTTON).click();


    }
    public boolean confirmPlacedOrder(){
        try{
            driver.findElement(CONFIRMATION_TEXT);

        } catch (NoSuchElementException e){
            return false;
        }
        return true;
    }

    public void downloadTheInvoice() {
        //Download Invoice
        driver.findElement(DOWNLOAD_INVOICE_BUTTON).click();
    }
    public boolean theInvoiceExists(String downloadPath, Date date, Date date1, String filename) throws InterruptedException {
        Thread.sleep(5000);

        // Retrieve the files under download folder



        File dir = new File(downloadPath);
        File[] listOfFiles = dir.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                // Get files with name Invoice
                // Confirm there is one that was downloaded no later than 1 min ago
                if(listOfFiles[i].lastModified() > date1.getTime() && listOfFiles[i].lastModified() < date.getTime() && listOfFiles[i].getName().contains(filename)){
                    //doSomething();
                    return true;
                }
            }
        }
        return false;
    }
}
