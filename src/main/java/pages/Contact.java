package pages;
import app.AppSession;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Contact {
    WebDriver driver;
    AppSession appSession;
    private final By CONTACT_US_BUTTON = By.xpath("//a[text()=' Contact us']");
    private final By CONTACT_US_SUBMIT_BUTTON = By.xpath("//input[@type='submit']");
    private final By CONTACT_NAME_INPUT = By.xpath("//input[@data-qa='name']");
    private final By CONTACT_EMAIL_INPUT = By.xpath("//input[@data-qa='email']");
    private final By CONTACT_SUBJECT_INPUT = By.xpath("//input[@data-qa='subject']");
    private final By CONTACT_MESSAGE_INPUT = By.xpath("//textarea[@data-qa='message']");
    private final By CONTACT_FORM_SUBMISSION_MESSAGE = By.xpath("//div[text()='Success! Your details have been submitted successfully.']");

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
        driver.findElement(CONTACT_FORM_SUBMISSION_MESSAGE).isDisplayed();
        return true;

    }
}
