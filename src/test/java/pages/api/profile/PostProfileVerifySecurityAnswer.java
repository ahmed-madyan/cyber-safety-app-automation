package pages.api.profile;//package pages.api.profile;
//
//import api.driver.RequestMethod;
//import assertions.Assertions;
//import context.Context;
//import context.ScenarioContext;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.apache.http.HttpStatus;
//import org.json.simple.JSONObject;
//import readers.json_reader.JSONDataManager;
//
//import java.util.HashMap;
//
//public class PostProfileVerifySecurityAnswer {
//    private static Response response = null;
//    private static final String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/profile/Profile.json");
//    private static final String endpoint = ("/profile-management-api/profile/{username}/verify-security-answer");
//    private static final HashMap<String, String> headersMap = new HashMap<>();
//    private static final JSONObject jsonObject = new JSONObject();
//
//    public static void invokePostProfileVerifySecurityAnswerEndpointWithValidRequest() {
//        jsonObject.put("securityQuestion", 4);
//        jsonObject.put("securityAnswer", "556677");
//        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()),
//                jsonObject, RequestMethod.POST, headersMap, null, null, null, HttpStatus.SC_OK, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidBadRequest() {
//        jsonObject.put("securityQuestion", 4);
//        jsonObject.put("securityAnswer", null);
//        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()),
//                jsonObject, RequestMethod.POST, headersMap, null, null, null, HttpStatus.SC_BAD_REQUEST, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidUnauthorizedRequest() {
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()),
//                null, RequestMethod.POST, null, null, null, null, HttpStatus.SC_UNAUTHORIZED, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidForbiddenRequest() {
//        String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/auth_access_tokens/AuthAccessTokens.json");
//        headersMap.put("authorizationToken", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()),
//                null, RequestMethod.POST, headersMap, null, null, null, HttpStatus.SC_FORBIDDEN, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidNotFoundRequest() {
//        jsonObject.put("securityQuestion", 4);
//        jsonObject.put("securityAnswer", "556677");
//        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
//        response = RequestBuilder.performRequest(ScenarioContext.getContext(Context.TARGET_BASE_URI).toString(),
//                null, endpoint.replace("{username}",
//                        JSONDataManager.getJSONData(jsonFilePath, "notExistUserName", JSONDataManager.Types.STRING).toString()),
//                jsonObject, RequestMethod.POST, headersMap, null, null, null, HttpStatus.SC_NOT_FOUND, true, ContentType.JSON);
//        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
//    }
//
//    public static void assertResponsePayloadContainsAllExpectedParameters() {
//        Assertions.hardAssert().objectEquals(response.jsonPath().get("securityQuestion"), JSONDataManager.getJSONData(jsonFilePath, "securityQuestion", JSONDataManager.Types.STRING).toString());
//        Assertions.hardAssert().objectEquals(response.jsonPath().get("success"), true);
//    }
//}