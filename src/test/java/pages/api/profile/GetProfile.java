package pages.api.profile;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.pojo.responses.profile.Profile_Res;
import assertions.Assertions;
import context.Context;
import context.ScenarioContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import pages.api.firebase.PostAuthenticatedToken;
import readers.json_reader.JSONDataManager;

import java.util.HashMap;

import static api.driver.RequestMethod.GET;
import static org.apache.http.HttpStatus.SC_UNAUTHORIZED;

public class GetProfile {
    private static Response response = null;
    private static final String jsonFilePath = ("src/test/resources/test_data/api/request/profile/Profile.json");
    private static final HashMap<String, String> headersMap = new HashMap<>();

    @Setter
    @Getter
    private static Profile_Res profile = new Profile_Res();

    public static void invokeGetProfileEndpointWithValidRequest() {
        PostAuthenticatedToken.invokeAuthenticatedFireBaseIdentityProviderBasePathWithValidKey();
        PostAuthenticatedToken.extractAuthenticatedJWTToken();
        headersMap.put("token", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .addHeaders(headersMap)
                        .setContentType(ContentType.JSON)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
        setProfile(response.as(Profile_Res.class));
    }

    public static void invokeGetProfileEndpointWithInValidUnauthorizedRequest() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(SC_UNAUTHORIZED)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokeGetProfileEndpointWithInValidForbiddenRequest() {
        String jsonFilePath_Auth = ("src/test/resources/test_data/api/request/auth_access_tokens/AuthAccessTokens.json");
        headersMap.put("token", JSONDataManager.getJSONData(jsonFilePath_Auth, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokeGetProfileEndpointWithInValidNotFoundRequest() {
        headersMap.put("token", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "notExistUserName", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
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