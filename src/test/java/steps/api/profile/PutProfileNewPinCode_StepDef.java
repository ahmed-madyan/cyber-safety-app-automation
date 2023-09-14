package steps.api.profile;//package step_definition.api.profile;
//
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.When;
//import page_object_model.api.profile.PutProfileNewPinCode;
//
//public class PutProfileNewPinCode_StepDef {
//    @When("User invoke PUT new pin code api with valid successfully")
//    public void userInvokePUTNewPinCodeApiWithValidSuccessfully() {
//        PutProfileNewPinCode.invokePutProfileNewPinCodeEndpointWithValidRequest();
//    }
//
//    @When("User invoke PUT new pin code api with invalid bad request")
//    public void userInvokePUTNewPinCodeApiWithInvalidBadRequest() {
//        PutProfileNewPinCode.invokePutProfileNewPinCodeEndpointWithInValidBadRequest();
//    }
//
//    @When("User invoke PUT new pin code api with invalid request unauthorized")
//    public void userInvokePUTNewPinCodeApiWithInvalidRequestUnauthorized() {
//        PutProfileNewPinCode.invokePutProfileNewPinCodeEndpointWithInValidUnauthorizedRequest();
//    }
//
//    @When("User invoke PUT new pin code api with invalid request forbidden")
//    public void userInvokePUTNewPinCodeApiWithInvalidRequestForbidden() {
//        PutProfileNewPinCode.invokePutProfileNewPinCodeEndpointWithInValidForbiddenRequest();
//    }
//
//    @When("User invoke PUT new pin code api with invalid request not found")
//    public void userInvokePUTNewPinCodeApiWithInvalidRequestNotFound() {
//        PutProfileNewPinCode.invokePutProfileNewPinCodeEndpointWithInValidNotFoundRequest();
//    }
//
//    @And("API response payload should contains success message for the pin code update")
//    public void apiResponsePayloadShouldContainsSuccessMessageForThePinCodeUpdate() {
//        PutProfileNewPinCode.assertResponsePayloadContainsAllExpectedParameters();
//    }
//}