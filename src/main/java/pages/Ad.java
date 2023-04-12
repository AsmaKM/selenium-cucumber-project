package pages;
import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Ad {

    WebDriver driver;
    AppSession appSession;

    private final By AD_FRAME=By.xpath("//iframe[contains(@id,'aswift')  and contains(@style,'visibility: visible')]");
    private final By AD_CLOSE_BUTTON=By.xpath("//div[@id='dismiss-button']");
    private final By SECOND_AD_FRAME=By.xpath("//iframe[@id='ad_iframe']");

    public Ad(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }


    public void closePopUpAd() throws InterruptedException {

        if (driver.findElement(AD_FRAME).isDisplayed()) {
            //if there's an iframe then switch to it
            driver.switchTo().frame(driver.findElement(AD_FRAME));
            if (driver.findElements(AD_CLOSE_BUTTON).size()>0 && driver.findElement(AD_CLOSE_BUTTON).isEnabled()){
                    // if there's only one iframe then just click the close button
            driver.findElement(AD_CLOSE_BUTTON).click();
            driver.switchTo().defaultContent();


            } else {


           // {
                //If there's a second frame then switch to it and
                //click the close button
                driver.switchTo().frame(driver.findElement(SECOND_AD_FRAME));
                driver.findElement(AD_CLOSE_BUTTON).click();
                driver.switchTo().defaultContent();
            }
        }
    }
}
