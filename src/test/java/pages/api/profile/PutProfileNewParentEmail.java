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

public class PutProfileNewParentEmail {
    private static Response response = null;
    private static final String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/profile/Profile.json");
    private static final String endpoint = ("/profile-management-api/profile/{username}/parent-email");
    private static final HashMap<String, String> headersMap = new HashMap<>();
    private static final JSONObject jsonObject = new JSONObject();

    public static void invokePutProfileNewParentEmailEndpointWithValidRequest() {
        jsonObject.put("parentEmail", JSONDataManager.getJSONData(jsonFilePath, "newParentEmail", JSONDataManager.Types.STRING).toString());
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.NEW_PARENT_EMAIL.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_OK)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
        rollbackProfileNewParentEmailEndpointWithValidRequest();
    }

    public static void invokePutProfileNewParentEmailEndpointWithInValidBadRequest() {
        jsonObject.put("parentEmail", JSONDataManager.getJSONData(jsonFilePath, "invalidParentEmail", JSONDataManager.Types.STRING).toString());
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.NEW_PARENT_EMAIL.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_BAD_REQUEST)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePutProfileNewParentEmailEndpointWithInValidUnauthorizedRequest() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.NEW_PARENT_EMAIL.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(HttpStatus.SC_UNAUTHORIZED)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePutProfileNewParentEmailEndpointWithInValidForbiddenRequest() {
        String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/auth_access_tokens/AuthAccessTokens.json");
        headersMap.put("authorizationToken", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.NEW_PARENT_EMAIL.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setExpectedStatusCode(HttpStatus.SC_FORBIDDEN)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePutProfileNewParentEmailEndpointWithInValidNotFoundRequest() {
        jsonObject.put("parentEmail", JSONDataManager.getJSONData(jsonFilePath, "newParentEmail", JSONDataManager.Types.STRING).toString());
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.NEW_PARENT_EMAIL.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "notExistUserName", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_NOT_FOUND)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    private static void rollbackProfileNewParentEmailEndpointWithValidRequest() {
        jsonObject.put("parentEmail", JSONDataManager.getJSONData(jsonFilePath, "parentEmail", JSONDataManager.Types.STRING).toString());
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.PUT)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.NEW_PARENT_EMAIL.getBasePath().replace("{username}",
                                JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(jsonObject)
                        .setExpectedStatusCode(HttpStatus.SC_OK)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertResponsePayloadContainsTheParentEmail() {
        Assertions.hardAssert().objectEquals(
                response.jsonPath().get("parentEmail"),
                (JSONDataManager.getJSONData(jsonFilePath, "newParentEmail", JSONDataManager.Types.STRING).toString()));
        Assertions.hardAssert().objectEquals(response.jsonPath().get("success"), (true));
    }
}