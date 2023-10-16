package pages.api.profile;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.pojo.requests.profile.PostProfile_Req;
import assertions.Assertions;
import context.Context;
import context.ScenarioContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import readers.json_reader.JSONDataManager;

import java.util.HashMap;

public class PatchProfile {
    private static Response response = null;
    private static final String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/profile/Profile.json");
    private static final HashMap<String, String> headersMap = new HashMap<>();
    private static final PostProfile_Req newProfile_req = new PostProfile_Req();
    private static final String username = JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString();
    private static final String new_Username = RandomStringUtils.random(20, true, true);
    private static final JSONObject jsonObject = new JSONObject();

    public static void invokePatchProfileEndpointWithValidRequest() {
        newProfile_req.setUsername(new_Username);
        newProfile_req.setDisplayName("Test");
        newProfile_req.setAge(12);
        newProfile_req.setAvatar(5);
        newProfile_req.setParentEmail(null);
        newProfile_req.setParentConsent(null);
        newProfile_req.setSecurityQuestion(1);
        newProfile_req.setSecurityAnswer("Test");
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PATCH)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", username))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(newProfile_req)
                        .setExpectedStatusCode(HttpStatus.SC_OK)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
        rollbackUsernameChanges();
    }

    public static void invokePatchProfileEndpointWithInValidBadRequest() {
        jsonObject.put("username", "");
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PATCH)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_BAD_REQUEST)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePatchProfileEndpointWithInValidUnauthorizedRequest() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PATCH)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(HttpStatus.SC_UNAUTHORIZED)
                        .sendRequest();


        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePatchProfileEndpointWithInValidForbiddenRequest() {
        String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/auth_access_tokens/AuthAccessTokens.json");
        headersMap.put("authorizationToken", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PATCH)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", username))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setExpectedStatusCode(HttpStatus.SC_FORBIDDEN)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePatchProfileEndpointWithInValidNotFoundRequest() {
        jsonObject.put("username", "username");
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PATCH)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "notExistUserName", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_FORBIDDEN)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    private static void rollbackUsernameChanges() {
        newProfile_req.setUsername(username);
        newProfile_req.setDisplayName("Test");
        newProfile_req.setAge(12);
        newProfile_req.setAvatar(5);
        newProfile_req.setParentEmail(null);
        newProfile_req.setParentConsent(null);
        newProfile_req.setSecurityQuestion(1);
        newProfile_req.setSecurityAnswer("Test");
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PATCH)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", new_Username))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(newProfile_req)
                        .setExpectedStatusCode(HttpStatus.SC_OK)
                        .sendRequest();
    }

    public static void assertResponsePayloadContainsAllExpectedParameters() {
        Assertions.hardAssert().objectEquals(response.jsonPath().get("age").toString(), JSONDataManager.getJSONData(jsonFilePath, "age", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().objectEquals(response.jsonPath().get("avatar").toString(), JSONDataManager.getJSONData(jsonFilePath, "avatar", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().objectEquals(response.jsonPath().get("displayName").toString(), JSONDataManager.getJSONData(jsonFilePath, "displayName", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().objectEquals(response.jsonPath().get("parentConsent").toString(), JSONDataManager.getJSONData(jsonFilePath, "parentConsent", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().objectEquals(response.jsonPath().get("parentEmail").toString(), JSONDataManager.getJSONData(jsonFilePath, "parentEmail", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().objectEquals(response.jsonPath().get("securityQuestion").toString(), JSONDataManager.getJSONData(jsonFilePath, "securityQuestion", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().objectEquals(response.jsonPath().get("username").toString(), JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString());
    }
}