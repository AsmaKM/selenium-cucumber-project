package testSteps;

import io.cucumber.java.en.And;

import pages.Home;
import properties.TestContext;

import static org.junit.jupiter.api.Assertions.assertTrue;

import pages.Ad;

public class CloseAdSteps {
    private Ad ad;
    private Home home;
    public CloseAdSteps(TestContext textContext){
        ad = textContext.getPageManager().getAd();
    }

    @And("I close the pop up ad")
    public void iCloseThePopUpAd() throws InterruptedException {

        ad.closePopUpAd();
    }
}
