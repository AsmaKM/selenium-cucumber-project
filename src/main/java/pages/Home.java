package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class Home{

    AppSession appSession;
    WebDriver driver;
    private final By LOGIN_BUTTON = By.cssSelector("a[href='/login']");
    private final By LOGOUT_BUTTON= By.cssSelector("a[href='/logout']");
    private final By MESSAGE_BUTTON= By.cssSelector("p[style]");
    private final By PRODUCT_BUTTON= By.cssSelector("a[href='/products']");




    public Home(AppSession appSession){
        this.appSession = appSession;
        driver = appSession.getDriverManager().getDriver();
    }

    public void go() throws InterruptedException {
        //Go to homepage
        driver.get(appSession.getBaseUrl());
        //If we need to use ad Blocker
        // Switch the window after installing ad blocker

//        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));
//




    }


    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();

    }

    public boolean userLoggedIn(){
        try{
          driver.findElement(LOGOUT_BUTTON);
        } catch (NoSuchElementException e){
            return false;
        }
        return true;

    }

    public void clickProductsButton() {
        driver.findElement(PRODUCT_BUTTON).click();

    }

        public boolean userNotLoggedIn(){
        try{
            driver.findElement(MESSAGE_BUTTON);
        } catch (NoSuchElementException e){
            return false;
        }
        return true;

    }

}