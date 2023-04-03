package properties;

import app.AppSession;
import app.PageManager;
import lombok.Getter;
import lombok.Setter;

public class TestContext {
    @Getter private AppSession appSession;
    @Getter private PageManager pageManager;
    @Getter @Setter String testStep;

    public TestContext() throws InterruptedException {
        appSession = new AppSession(TestProps.BROWSER, TestProps.BASE_URL);
        appSession.setDefaultTimeout(15);
        pageManager = new PageManager(appSession);
    }

}