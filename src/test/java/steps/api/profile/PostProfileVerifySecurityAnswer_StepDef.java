package steps.api.profile;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.api.profile.PostProfileVerifySecurityAnswer;

public class PostProfileVerifySecurityAnswer_StepDef {
    @When("User invoke POST verify security answer api with valid successfully")
    public void userInvokePOSTVerifySecurityAnswerApiWithValidSuccessfully() {
        PostProfileVerifySecurityAnswer.invokePostProfileVerifySecurityAnswerEndpointWithValidRequest();
    }

    @When("User invoke POST verify security answer api with invalid bad request")
    public void userInvokePOSTVerifySecurityAnswerApiWithInvalidBadRequest() {
        PostProfileVerifySecurityAnswer.invokePostProfileVerifySecurityAnswerEndpointWithInValidBadRequest();
    }

    @When("User invoke POST verify security answer api with invalid request unauthorized")
    public void userInvokePOSTVerifySecurityAnswerApiWithInvalidRequestUnauthorized() {
        PostProfileVerifySecurityAnswer.invokePostProfileVerifySecurityAnswerEndpointWithInValidUnauthorizedRequest();
    }

    @When("User invoke POST verify security answer api with invalid request forbidden")
    public void userInvokePOSTVerifySecurityAnswerApiWithInvalidRequestForbidden() {
        PostProfileVerifySecurityAnswer.invokePostProfileVerifySecurityAnswerEndpointWithInValidForbiddenRequest();
    }

    @When("User invoke POST verify security answer api with invalid request not found")
    public void userInvokePOSTVerifySecurityAnswerApiWithInvalidRequestNotFound() {
        PostProfileVerifySecurityAnswer.invokePostProfileVerifySecurityAnswerEndpointWithInValidNotFoundRequest();
    }

    @And("API response payload should contains success message for verify security answer")
    public void apiResponsePayloadShouldContainsSuccessMessageForVerifySecurityAnswer() {
        PostProfileVerifySecurityAnswer.assertResponsePayloadContainsAllExpectedParameters();
    }
}