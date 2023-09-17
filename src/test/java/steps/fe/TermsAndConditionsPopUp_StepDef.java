package steps.fe;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.fe.TermAndConditionsPopUp;

public class TermsAndConditionsPopUp_StepDef {
    @Then("User should be redirected to terms and conditions pop up")
    public void userShouldBeRedirectedToTermsAndConditionsPopUp() {
        TermAndConditionsPopUp.validateUserRedirectedToTermsAndConditionsPopUp();
    }

    @And("Validate skip button text")
    public void validateSkipButtonText() {
        TermAndConditionsPopUp.validateSkipButtonText();
    }

    @Given("User skip the pop up")
    public void userSkipThePopUp() {
        TermAndConditionsPopUp.skipPopUp();
    }

    @Given("User close the pop up")
    public void userCloseThePopUp() {
        TermAndConditionsPopUp.closePopUp();
    }

    @Then("Validate pop up dialoge")
    public void validatePopUpDialoge() {
        TermAndConditionsPopUp.validatePopUpDialoge();
    }

    @Then("Validate pop up header text")
    public void validatePopUpHeaderText() {
        TermAndConditionsPopUp.validatePopUpHeaderText();
    }
}