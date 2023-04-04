package pages;
import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact {
    WebDriver driver;
    AppSession appSession;
    private final By CONTACT_US_BUTTON = By.cssSelector("a[href='/contact_us']");
    private final By CONTACT_US_SUBMIT_BUTTON = By.cssSelector("input[name='submit']");
    private final By CONTACT_NAME_INPUT = By.cssSelector("input[name='name']");
    private final By CONTACT_EMAIL_INPUT = By.cssSelector("input[name='email']");
    private final By CONTACT_SUBJECT_INPUT = By.cssSelector("input[name='subject']");
    private final By CONTACT_MESSAGE_INPUT = By.cssSelector("textarea[id='message']");
    private final By CONTACT_FORM_SUBMISSION_MESSAGE = By.cssSelector("div[class='status alert alert-success']");

    public Contact(AppSession appSession){
        driver = appSession.getDriverManager().getDriver();
    }

    public void goToContactUsPage(){
        // Click Products
        driver.findElement(CONTACT_US_BUTTON).click();

    }


    public void fillTheForm(String name,String email,String subject,String msg) {
        driver.findElement(CONTACT_NAME_INPUT).sendKeys(name);
        driver.findElement(CONTACT_EMAIL_INPUT).sendKeys(email);
        driver.findElement(CONTACT_SUBJECT_INPUT).sendKeys(subject);
        driver.findElement(CONTACT_MESSAGE_INPUT).sendKeys(msg);


    }

    public void submitForm() {
        driver.findElement(CONTACT_US_SUBMIT_BUTTON).click();
        driver.switchTo().alert().accept();
    }

    public boolean formSubmitted() {
        try {
            driver.findElement(CONTACT_FORM_SUBMISSION_MESSAGE);
        } catch (NoSuchElementException e){
            return false;
        }
        return true;

    }
}
