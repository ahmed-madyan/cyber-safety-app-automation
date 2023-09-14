package steps.api.profile;//package step_definition.api.profile;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.When;
//import page_object_model.api.profile.PatchProfile;
//
//public class PatchProfile_StepDef {
//    @When("User invoke Patch profile api with valid successfully")
//    public void userInvokePatchProfileApiWithValidSuccessfully() {
//        PatchProfile.invokePatchProfileEndpointWithValidRequest();
//    }
//
//    @When("User invoke Patch profile api with invalid bad request")
//    public void userInvokePatchProfileApiWithInvalidBadRequest() {
//        PatchProfile.invokePatchProfileEndpointWithInValidBadRequest();
//    }
//
//    @When("User invoke Patch profile api with invalid request unauthorized")
//    public void userInvokePatchProfileApiWithInvalidRequestUnauthorized() {
//        PatchProfile.invokePatchProfileEndpointWithInValidUnauthorizedRequest();
//    }
//
//    @When("User invoke Patch profile api with invalid request forbidden")
//    public void userInvokePatchProfileApiWithInvalidRequestForbidden() {
//        PatchProfile.invokePatchProfileEndpointWithInValidForbiddenRequest();
//    }
//
//    @When("User invoke Patch profile api with invalid request not found")
//    public void userInvokePatchProfileApiWithInvalidRequestNotFound() {
//        PatchProfile.invokePatchProfileEndpointWithInValidNotFoundRequest();
//    }
//
//    @And("API response payload should contains the new profile details")
//    public void apiResponsePayloadShouldContainsTheNewProfileDetails() {
//        PatchProfile.assertResponsePayloadContainsAllExpectedParameters();
//    }
//}