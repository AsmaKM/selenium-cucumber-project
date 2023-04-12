package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.Date;

//import static io.opentelemetry.sdk.metrics.internal.view.DefaultAggregation.resolve;

public class Checkout {

    WebDriver driver;
    AppSession appSession;
    String nameOnCard="qac";
    int cardNumber=111, cvc=111, expiryMonth=10, expiryYear=2023;

    private final By PROCEED_TO_CHECKOUT_BUTTON = By.xpath("//a[text()='Proceed To Checkout']");
    private final By REVIEW_ORDER_TEXT = By.xpath("//div//h2[text()='Review Your Order']");
    private final By ADDRESS_DETAILS = By.xpath("//div//h2[text()='Address Details']");
    private final By PLACE_ORDER_BUTTON = By.xpath("//div//a[@class='btn btn-default check_out']");
    private final By PAYMENT_TEXT = By.xpath("//div//h2[text()='Payment']");
    private final By NAME_ON_CARD_INPUT = By.xpath("//input[@class='form-control'][@data-qa='name-on-card']");
    private final By CARD_NUMBER_INPUT = By.xpath("//input[@class='form-control card-number'][@data-qa='card-number']");
    private final By CVC_INPUT = By.xpath("//input[@class='form-control card-cvc'][@data-qa='cvc']");
    private final By EXPIRY_MONTH_INPUT = By.xpath("//input[@class='form-control card-expiry-month'][@data-qa='expiry-month']");
    private final By EXPIRY_YEAR_INPUT = By.xpath("//input[@class='form-control card-expiry-year'][@data-qa='expiry-year']");
    private final By PAY_AND_CONFIRM_ORDER_BUTTON = By.xpath("//div//button[@class='form-control btn btn-primary submit-button']");
    private final By CONFIRMATION_TEXT = By.xpath("//div//p[text()='Congratulations! Your order has been confirmed!']");
    private final By DOWNLOAD_INVOICE_BUTTON = By.xpath("//div//a[@class='btn btn-default check_out']");



    public Checkout(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }

    public void goToCheckoutPage(){
        // Click Proceed to checkout
        driver.findElement(PROCEED_TO_CHECKOUT_BUTTON).click();
    }
    public boolean userOnCheckOutPage(){
          //Find the Address details and review order to confirm user is on Checkout PagE
            driver.findElement(REVIEW_ORDER_TEXT).isDisplayed();
            driver.findElement(ADDRESS_DETAILS).isDisplayed();
        return true;
    }

    public void UserCanProceedToPlaceOrder() {
        driver.findElement(PLACE_ORDER_BUTTON).click();
    }
    public boolean UserOnPaymentPage() {
            driver.findElement(PAYMENT_TEXT).isDisplayed();
        return true;
    }

    public void attemptToPayAndConfirmOrder() {
        //clear the box then send the information

        //name
        WebElement searchElement= driver.findElement(NAME_ON_CARD_INPUT);
        searchElement.clear();
        searchElement.sendKeys(nameOnCard);
        //card number
        searchElement= driver.findElement(CARD_NUMBER_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(cardNumber));
        //cvc
        searchElement= driver.findElement(CVC_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(cvc));
        //expiry month
        searchElement= driver.findElement(EXPIRY_MONTH_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(expiryMonth));
        //expiry year
        searchElement= driver.findElement(EXPIRY_YEAR_INPUT);
        searchElement.clear();
        searchElement.sendKeys(String.valueOf(expiryYear));

        // click pay and confirm order to proceed
        driver.findElement(PAY_AND_CONFIRM_ORDER_BUTTON).click();
    }
    public boolean confirmPlacedOrder(){
            driver.findElement(CONFIRMATION_TEXT).isDisplayed();
        return true;
    }

    public void downloadTheInvoice() throws InterruptedException {
        //Download Invoice
        driver.findElement(DOWNLOAD_INVOICE_BUTTON).click();
        //need to change it ........
        Thread.sleep(5000);
        //............................
    }

    //wait until the file is downloaded
//    public void waitForFileToDownload(int totalTimeoutInMillis, String downloadPath, String filename) throws IOException {
//        Wait<WebDriver>wait=new FluentWait<WebDriver>(driver)
//                .withTimeout(Duration.ofSeconds(10))
//                .pollingEvery(Duration.ofMillis(250))
//                .ignoring(NoSuchElementException.class);
//        wait.until(ExpectedConditions);
//
//        File fileToCheck=downloadPath.
//            wait.until((WebDriver wd) -> fileToCheck.exists());

//        }
    public boolean theInvoiceExists(String downloadPath, Date end_date, Date start_date, String filename){
        // Retrieve the files under download folder
        // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        File dir = new File(downloadPath);
        File[] listOfFiles = dir.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                // Get files with name Invoice
                // Confirm there is one that was downloaded no later than 1 min ago
                if(listOfFiles[i].lastModified() > start_date.getTime() && listOfFiles[i].lastModified() < end_date.getTime() && listOfFiles[i].getName().contains(filename)){
                    return true;
                }
            }
        }
        return false;
    }
}
