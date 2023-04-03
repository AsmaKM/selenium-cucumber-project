package pages;

import app.AppSession;
import org.openqa.selenium.WebDriver;

public class Installation extends BasePage{

    private final String PAGE_PATH = "/docs/installation/";
    private WebDriver driver;
    AppSession appSession;

    public Installation(AppSession appSession){
        super(appSession);
        this.appSession = appSession;
        driver = appSession.getDriverManager().getDriver();    }

    public void go(){
        driver.get(appSession.getBaseUrl() + PAGE_PATH);
    }

    public boolean imHere(){
        return driver.getCurrentUrl().contains(PAGE_PATH);
    }

}
