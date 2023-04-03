package testSteps;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import pages.Home;
import pages.Login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import properties.TestContext;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    private BasePage basePage;
    private Login login;
    private Home home;

    public LoginSteps(TestContext testContext){
        basePage = testContext.getPageManager().getBasePage();
        login = testContext.getPageManager().getLogin();
        home = testContext.getPageManager().getHome();
    }

    @Given("I go to Login page")
    public void iGoToLoginPage() throws InterruptedException {
        // From automation page click login.
        home.go();
        home.clickLoginButton();
    }

    @When("I try to login with username:{string} and password: {string}")
    public void iTryToLoginWithUsernameAndPassword(String username, String password) {
        // Enter username and password in input fields
        login.attemptToLogin(username, password);

    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        // Username is displayed
        home.userLoggedIn();
        assertTrue(home.userLoggedIn(),"User is not logged in");

    }

    @When("I try to login with wrong username:{string} and password: {string}")
    public void iTryToLoginWithWrongUsernameAndPassword(String username, String password) {
        // Enter username and password in input fields
        login.attemptToUnsuccessfulLogin(username, password);

    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        // Wrong Username or Password message is displayed
        home.userNotLoggedIn();
        assertTrue(home.userNotLoggedIn(), "User's Email or Password is incorrect!");

    }

    //    @When("I enter email:{string} and password:{string}")
//    public void iEnterEmailAndPassword(String username, String password) {
//        login.attemptToLogin(username, password);
//    }
//
//    @Then("{string} message is displayed")
//    public void messageIsDisplayed(String errorMessage) {
//        assertEquals(errorMessage, login.getErrorMessage());
//    }


       // iFrame
//    WebElement frame1= driver.findElement(By.id("ad_position_box"));
//        driver.switchTo().frame(frame1);
//    WebElement frame2= driver.findElement(By.id("ad_iframe"));
//        driver.switchTo().frame(frame2);
//        driver.findElement(By.cssSelector("div[id='dismiss-button']")).click();
//        driver.switchTo().defaultContent();
//        Thread.sleep(5000);
}