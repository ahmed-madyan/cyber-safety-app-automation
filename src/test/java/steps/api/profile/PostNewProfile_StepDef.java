package steps.api.profile;//package step_definition.api.profile;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.When;
//import page_object_model.api.profile.PostNewProfile;
//
//public class PostNewProfile_StepDef {
//    @When("User invoke create profile api with valid successfully")
//    public void userInvokeCreateProfileApiWithValidSuccessfully() {
//        PostNewProfile.invokePostNewProfileEndpointWithValidRequest();
//    }
//
//    @And("API response payload should contains the new user details")
//    public void apiResponsePayloadShouldContainsTheNewUserDetails() {
//        PostNewProfile.assertResponsePayloadContainsAllExpectedParameters();
//    }
//
//    @Given("User invoke create profile api with invalid bad request")
//    public void userInvokeCreateProfileApiWithInvalidBadRequest() {
//        PostNewProfile.invokePostNewProfileEndpointWithInValidBadRequest();
//    }
//
//    @Given("User invoke create profile api with invalid request unauthorized")
//    public void userInvokeCreateProfileApiWithInvalidRequestUnauthorized() {
//        PostNewProfile.invokePostNewProfileEndpointWithInValidUnauthorizedRequest();
//    }
//
//    @Given("User invoke create profile api with invalid request forbidden")
//    public void userInvokeCreateProfileApiWithInvalidRequestForbidden() {
//        PostNewProfile.invokePostNewProfileEndpointWithInValidForbiddenRequest();
//    }
//}