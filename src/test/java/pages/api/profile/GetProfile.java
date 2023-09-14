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
import org.testng.annotations.Test;
import pages.api.firebase.PostAuthenticatedToken;
import readers.json_reader.JSONDataManager;

import java.util.HashMap;

import static api.driver.RequestMethod.GET;
import static org.apache.http.HttpStatus.*;

public class GetProfile {
    private static Response response = null;
    private static final String jsonFilePath = ("src/test/resources/test_data/api/request/profile/Profile.json");
    private static final String endpoint = ("/profile-management-api/profile/{username}");
    private static final HashMap<String, String> headersMap = new HashMap<>();

    @Setter
    @Getter
    private static Profile_Res profile = new Profile_Res();

    @Test
    public static void invokeGetProfileEndpointWithValidRequest() {
        PostAuthenticatedToken.invokeAuthenticatedFireBaseIdentityProviderBasePathWithValidKey();
        PostAuthenticatedToken.extractAuthenticatedJWTToken();
        headersMap.put("token", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .addHeaders(headersMap)
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(SC_OK)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
        setProfile(response.as(Profile_Res.class));
    }

    public static void invokeGetProfileEndpointWithInValidUnauthorizedRequest() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(SC_UNAUTHORIZED)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    //
    public static void invokeGetProfileEndpointWithInValidForbiddenRequest() {
        String jsonFilePath = ("src/test/resources/test_data/api/request/auth_access_tokens/AuthAccessTokens.json");
        headersMap.put("token", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setExpectedStatusCode(SC_FORBIDDEN)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokeGetProfileEndpointWithInValidNotFoundRequest() {
        headersMap.put("token", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(GET)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", JSONDataManager.getJSONData(jsonFilePath, "notExistUserName", JSONDataManager.Types.STRING).toString()))
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setExpectedStatusCode(SC_NOT_FOUND)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertResponsePayloadContainsAllExpectedParameters() {
        Assertions.hardAssert().attributeToBe(response.jsonPath().get("age"), JSONDataManager.getJSONData(jsonFilePath, "age", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().attributeToBe(response.jsonPath().get("avatar"), JSONDataManager.getJSONData(jsonFilePath, "avatar", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().attributeToBe(response.jsonPath().get("displayName"), JSONDataManager.getJSONData(jsonFilePath, "displayName", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().attributeToBe(response.jsonPath().get("parentConsent"), JSONDataManager.getJSONData(jsonFilePath, "parentConsent", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().attributeToBe(response.jsonPath().get("parentEmail"), JSONDataManager.getJSONData(jsonFilePath, "parentEmail", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().attributeToBe(response.jsonPath().get("securityQuestion"), JSONDataManager.getJSONData(jsonFilePath, "securityQuestion", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().attributeToBe(response.jsonPath().get("username"), JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString());
    }
}