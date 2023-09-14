package steps.api.firebase;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.api.firebase.PostAnonymousToken;
import pages.api.firebase.PostAuthenticatedToken;

public class FireBase_StepDef {
    @Given("I invoke the anonymous fireBase identity provider base path with a valid key.")
    public void iInvokeAnonymousFireBaseIdentityProviderBasePathWithValidKey() {
        PostAnonymousToken.invokeAnonymousFireBaseIdentityProviderBasePathWithValidKey();
    }

    @Then("I should have the anonymous access token extracted from the response payload.")
    public void iShouldHaveTheAnonymousAccessTokenExtractedFromTheResponsePayload() {
        PostAnonymousToken.extractAnonymousJWTToken();
    }

    @Given("I invoke the authenticated fireBase identity provider base path with a valid request.")
    public void iInvokeTheAuthenticatedFireBaseIdentityProviderBasePathWithAValidKey() {
        PostAuthenticatedToken.invokeAuthenticatedFireBaseIdentityProviderBasePathWithValidKey();
    }

    @Then("I should have the authorized access token extracted from the response payload.")
    public void iShouldHaveTheAuthorizedAccessTokenExtractedFromTheResponsePayload() {
        PostAuthenticatedToken.extractAuthenticatedJWTToken();
    }
}