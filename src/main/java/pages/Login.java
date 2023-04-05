package pages;

import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class Login{
    WebDriver driver;
    AppSession appSession;

    // Elements
    // username field


    private final By USERNAME_INPUT = By.cssSelector("form[action='/login'] input[type='email']");
    // password field
    private final By PASSWORD_INPUT = By.cssSelector("form[action='/login'] input[type='password']");
    // login button
    private final By LOGIN_BUTTON = By.cssSelector("form[action='/login'] button[type='submit']");

    public Login(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }

    public void attemptToLogin(String username, String password){
       // Enter username
    driver.findElement(USERNAME_INPUT).sendKeys(username);
        //Enter password
    driver.findElement(PASSWORD_INPUT).sendKeys(password);


        //Click Login
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void attemptToUnsuccessfulLogin(String username, String password){
        // Enter username
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        //Enter password
        driver.findElement(PASSWORD_INPUT).sendKeys(password);


        //Click Login
        driver.findElement(LOGIN_BUTTON).click();
    }




}
