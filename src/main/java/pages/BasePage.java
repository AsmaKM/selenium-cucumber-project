package pages;
import app.AppSession;
import org.openqa.selenium.By;

public class BasePage extends Page {
    private final By LOGIN_BUTTON = By.cssSelector("a[title='Login']");
    public BasePage(AppSession appSession) {
        super(appSession);
    }

    public void clickLogin(){
        clickElement(LOGIN_BUTTON);
    }

    public void selectOptionAndSubOptionFromMenu(String optionName, String subOptionName){
     clickElementWithExactText(optionName,"a");
     clickElementWithExactText(subOptionName, "a");
    }

}
