package pages.api.profile;//package page_object_model.api.profile;
//
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import org.json.simple.JSONObject;
//import utilities.api_driver.RequestBuilder;
//import utilities.api_driver.RequestMethod;
//import utilities.context.ScenarioContext;
//import utilities.context.Context;
//import utilities.reader_manager.json_reader.JSONDataManager;
//
//import java.util.HashMap;
//
//public class PutProfileNewPinCode {
//    private static Response response = null;
//    private static final String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/profile/Profile.json");
//    private static final String endpoint = ("/profile-management-api/profile/{username}/new-pin-code");
//    private static final HashMap<String, String> headersMap = new HashMap<>();
//    private static final JSONObject jsonObject = new JSONObject();
//
//    public static void invokePutProfileNewPinCodeEndpointWithValidRequest() {
//        jsonObject.put("newPinCode", JSONDataManager.getJSONData(jsonFilePath, "newPinCode", JSONDataManager.Types.STRING).toString());
//        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()),
//                jsonObject, RequestMethod.PUT, headersMap, null, null, null, HttpStatus.SC_OK, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//        rollbackProfileNewPinCodeEndpointWithValidRequest();
//    }
//
//    public static void invokePutProfileNewPinCodeEndpointWithInValidBadRequest() {
//        jsonObject.put("newPinCode", JSONDataManager.getJSONData(jsonFilePath, "invalidNewPinCode", JSONDataManager.Types.STRING).toString());
//        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()),
//                jsonObject, RequestMethod.PUT, headersMap, null, null, null, HttpStatus.SC_BAD_REQUEST, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void invokePutProfileNewPinCodeEndpointWithInValidUnauthorizedRequest() {
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}", ""),
//                null, RequestMethod.PUT, null, null, null, null, HttpStatus.SC_UNAUTHORIZED, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void invokePutProfileNewPinCodeEndpointWithInValidForbiddenRequest() {
//        String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/auth_access_tokens/AuthAccessTokens.json");
//        headersMap.put("authorizationToken", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}", ""),
//                null, RequestMethod.PUT, headersMap, null, null, null, HttpStatus.SC_FORBIDDEN, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void invokePutProfileNewPinCodeEndpointWithInValidNotFoundRequest() {
//        jsonObject.put("newPinCode", JSONDataManager.getJSONData(jsonFilePath, "pinCode", JSONDataManager.Types.STRING).toString());
//        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "notExistUserName", JSONDataManager.Types.STRING).toString()),
//                jsonObject, RequestMethod.PUT, headersMap, null, null, null, HttpStatus.SC_NOT_FOUND, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    private static void rollbackProfileNewPinCodeEndpointWithValidRequest() {
//        jsonObject.put("newPinCode", JSONDataManager.getJSONData(jsonFilePath, "pinCode", JSONDataManager.Types.STRING).toString());
//        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()),
//                jsonObject, RequestMethod.PUT, headersMap, null, null, null, HttpStatus.SC_OK, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void assertResponsePayloadContainsAllExpectedParameters() {
////        Validations.assertThat().object(response.jsonPath().get("success")).isEqualTo(true);
//    }
//}