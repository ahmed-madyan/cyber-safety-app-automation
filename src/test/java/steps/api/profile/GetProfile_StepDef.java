package steps.api.profile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.api.profile.GetProfile;

public class GetProfile_StepDef {
    @When("User invoke Get profile api with valid successfully")
    public void userInvokeGetProfileApiWithValidSuccessfully() {
        GetProfile.invokeGetProfileEndpointWithValidRequest();
    }

    @And("API response payload should contains the profile details")
    public void apiResponsePayloadShouldContainsTheProfileDetails() {
        GetProfile.assertResponsePayloadContainsAllExpectedParameters();
    }

    @When("User invoke Get profile api with invalid request unauthorized")
    public void userInvokeGetProfileApiWithInvalidRequestUnauthorized() {
        GetProfile.invokeGetProfileEndpointWithInValidUnauthorizedRequest();
    }

    @When("User invoke Get profile api with invalid request forbidden")
    public void userInvokeGetProfileApiWithInvalidRequestForbidden() {
        GetProfile.invokeGetProfileEndpointWithInValidForbiddenRequest();
    }

    @When("User invoke Get profile api with invalid request not found")
    public void userInvokeGetProfileApiWithInvalidRequestNotFound() {
        GetProfile.invokeGetProfileEndpointWithInValidNotFoundRequest();
    }
}