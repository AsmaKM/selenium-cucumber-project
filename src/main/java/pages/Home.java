package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Home{
    AppSession appSession;
    WebDriver driver;
    private final By LOGIN_BUTTON = By.xpath("//a[@href='/login']");
    private final By LOGOUT_BUTTON= By.xpath("//div[@class='shop-menu pull-right']//a[@href='/logout']");
    private final By MESSAGE_BUTTON= By.xpath("//p[text()='Your email or password is incorrect!']");




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
    }


    public void clickLoginButton() {

        driver.findElement(LOGIN_BUTTON).click();
    }

    public boolean userLoggedIn(){
        driver.findElement(LOGOUT_BUTTON).isDisplayed();
        return true;
    }



        public boolean userNotLoggedIn(){
        driver.findElement(MESSAGE_BUTTON).isDisplayed();
        return true;
    }
}