package testSteps;

import io.cucumber.java.en.Given;
import pages.Home;
import pages.Login;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import properties.TestContext;

import static utils.AssertAndLog.assertTrueAndLog;

public class LoginSteps {

    private Login login;
    private Home home;

    public LoginSteps(TestContext testContext){
       // basePage = testContext.getPageManager().getBasePage();
        login = testContext.getPageManager().getLogin();
        home = testContext.getPageManager().getHome();
    }

    @Given("I go to Login page")
    public void iGoToLoginPage() throws InterruptedException {
        // From automation page click login.
        home.go();
        home.clickLoginButton();
    }

    @When("I try to login with valid credentials")
    public void iTryToLoginWithValidCredentials() {
        // Enter username and password in input fields
        login.attemptToLoginWithValidCredentials();

    }

    @Then("I am logged in")
    public void iAmLoggedIn() {
        // Username is displayed
        home.userLoggedIn();
        assertTrueAndLog(home.userLoggedIn(),"User is not logged in");

    }

    @When("I try to login with wrong username:{string} and password: {string}")
    public void iTryToLoginWithWrongUsernameAndPassword(String username, String password) {
        // Enter username and password in input fields
        login.attemptToLoginWithWrongCredentials(username,password);

    }

    @Then("I am not logged in")
    public void iAmNotLoggedIn() {
        // Wrong Username or Password message is displayed
        home.userNotLoggedIn();
        assertTrueAndLog(home.userNotLoggedIn(), "User's Email or Password is incorrect!");

    }




}