package pages.api.profile;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import assertions.Assertions;
import context.Context;
import context.ScenarioContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import readers.json_reader.JSONDataManager;

import java.util.HashMap;

public class PostProfileVerifySecurityAnswer {
    private static Response response = null;
    private static final String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/profile/Profile.json");
    private static final String endpoint = ("/profile-management-api/profile/{username}/verify-security-answer");
    private static final HashMap<String, String> headersMap = new HashMap<>();
    private static final JSONObject jsonObject = new JSONObject();

    public static void invokePostProfileVerifySecurityAnswerEndpointWithValidRequest() {
        jsonObject.put("securityQuestion", 4);
        jsonObject.put("securityAnswer", "556677");
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.VERIFY_SECURITY_ANSWER.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_OK)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidBadRequest() {
        jsonObject.put("securityQuestion", 4);
        jsonObject.put("securityAnswer", null);
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.VERIFY_SECURITY_ANSWER.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_BAD_REQUEST)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidUnauthorizedRequest() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.VERIFY_SECURITY_ANSWER.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setExpectedStatusCode(HttpStatus.SC_UNAUTHORIZED)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidForbiddenRequest() {
        String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/auth_access_tokens/AuthAccessTokens.json");
        headersMap.put("authorizationToken", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.VERIFY_SECURITY_ANSWER.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setExpectedStatusCode(HttpStatus.SC_FORBIDDEN)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePostProfileVerifySecurityAnswerEndpointWithInValidNotFoundRequest() {
        jsonObject.put("securityQuestion", 4);
        jsonObject.put("securityAnswer", "556677");
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.VERIFY_SECURITY_ANSWER.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "notExistUserName", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_NOT_FOUND)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertResponsePayloadContainsAllExpectedParameters() {
        Assertions.hardAssert().objectEquals(response.jsonPath().get("securityQuestion"), JSONDataManager.getJSONData(jsonFilePath, "securityQuestion", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().objectEquals(response.jsonPath().get("success"), true);
    }
}