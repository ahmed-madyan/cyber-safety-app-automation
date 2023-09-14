package steps.api.content;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.api.content.GetFullContentList;

public class GetFullContentList_StepDef {

    @When("the User invokes the content API with valid successfully.")
    public void userInvokeTheContentApiSuccessfully() {
        GetFullContentList.invokeContentEndpointWithValidRequest();
    }

    @And("API response payload should contain a list of content items that include all contents for all content types.")
    public void apiResponsePayloadShouldContainsAListOfContentItemsIncludesAllContentsForAllContentTypes() {
        GetFullContentList.assertResponsePayloadContainsAllExpectedParameters();
        GetFullContentList.assertFullContentResponsePayloadValues();
    }

    @Given("User invoke the content API with an invalid request unauthorized.")
    public void userInvokeTheContentApiWithInvalidRequestUnauthorized() {
        GetFullContentList.invokeContentEndpointWithInValidUnauthorizedRequest();
    }

    @Given("User invoke the content API with an invalid request forbidden.")
    public void userInvokeTheContentApiWithInvalidRequestForbidden() {
        GetFullContentList.invokeContentEndpointWithInValidForbiddenRequest();
    }
}