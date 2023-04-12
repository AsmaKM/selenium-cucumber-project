package pages;

import app.AppSession;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.WebDriver;

import java.util.NoSuchElementException;

public class Login{
    WebDriver driver;
    AppSession appSession;
    String username="asmaqac@gmail.com";
    String password="qaconsultants";


    private final By USERNAME_INPUT = By.xpath("//form[@action='/login'] //input[@type='email']");
    // password field
    private final By PASSWORD_INPUT = By.xpath("//form[@action='/login'] //input[@type='password']");
    // login button
    private final By LOGIN_BUTTON = By.xpath("//form[@action='/login'] //button[@type='submit']");
    public Login(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }

    public void attemptToLoginWithValidCredentials(){
       // Enter username
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        //Enter password
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        //Click Login
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void attemptToLoginWithWrongCredentials(String username, String password) {
        // Enter username
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        //Enter password
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        //Click Login
        driver.findElement(LOGIN_BUTTON).click();
    }
}
