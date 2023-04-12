package testSteps;

import io.cucumber.java.en.And;
import pages.Home;
import pages.Contact;
import properties.TestContext;

import static utils.AssertAndLog.assertTrueAndLog;

public class ContactSteps {
    private Contact contact;
    private Home home;

    public ContactSteps(TestContext textContext){
        contact = textContext.getPageManager().getContact();
    }


    @And("I go to Contact Us Page")
    public void iGoToContactUsPage() {
    contact.goToContactUsPage();
    }

    @And("I fill the form with name :{string}, email:{string}, subject: {string} and message: {string} and submit it")
    public void iFillTheFormWithNameEmailSubjectAndMessageAndSubmitIt(String name, String email, String subject, String msg) {
        contact.fillTheForm(name, email, subject, msg);
        contact.submitForm();
        assertTrueAndLog(contact.formSubmitted(), "Contact form was not submitted!");
    }
}
