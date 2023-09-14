package steps.api.profile;//package step_definition.api.profile;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.When;
//import page_object_model.api.profile.PutProfileNewParentEmail;
//
//public class PutProfileNewParentEmail_StepDef {
//    @When("User invoke PUT parent email api with valid successfully")
//    public void userInvokePUTParentEmailApiWithValidSuccessfully() {
//        PutProfileNewParentEmail.invokePutProfileNewParentEmailEndpointWithValidRequest();
//    }
//
//    @When("User invoke PUT parent email api with invalid bad request")
//    public void userInvokePUTParentEmailApiWithInvalidBadRequest() {
//        PutProfileNewParentEmail.invokePutProfileNewParentEmailEndpointWithInValidBadRequest();
//    }
//
//    @When("User invoke PUT parent email api with invalid request unauthorized")
//    public void userInvokePUTParentEmailApiWithInvalidRequestUnauthorized() {
//        PutProfileNewParentEmail.invokePutProfileNewParentEmailEndpointWithInValidUnauthorizedRequest();
//    }
//
//    @When("User invoke PUT parent email api with invalid request forbidden")
//    public void userInvokePUTParentEmailApiWithInvalidRequestForbidden() {
//        PutProfileNewParentEmail.invokePutProfileNewParentEmailEndpointWithInValidForbiddenRequest();
//    }
//
//    @When("User invoke PUT parent email api with invalid request not found")
//    public void userInvokePUTParentEmailApiWithInvalidRequestNotFound() {
//        PutProfileNewParentEmail.invokePutProfileNewParentEmailEndpointWithInValidNotFoundRequest();
//    }
//
//    @And("API response payload should contains success message with the new parent email")
//    public void apiResponsePayloadShouldContainsSuccessMessageWithTheNewParentEmail() {
//        PutProfileNewParentEmail.assertResponsePayloadContainsTheParentEmail();
//    }
//}