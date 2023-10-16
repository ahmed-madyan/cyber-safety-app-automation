package pages.api.profile;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.pojo.requests.profile.PostProfile_Req;
import api.pojo.responses.profile.Profile_Res;
import assertions.Assertions;
import context.Context;
import context.ScenarioContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import readers.json_reader.JSONDataManager;

import java.util.HashMap;
import java.util.Random;

public class PostNewProfile {
    private static Response response = null;
    private static final PostProfile_Req reqNewProfile = new PostProfile_Req();
    @Setter  @Getter
    private static Profile_Res profile = new Profile_Res();
    private static final HashMap<String, String> headersMap = new HashMap<>();
    private static String randomUsername;
    private static String randomDisplayName;
    private static int randomAge;
    private static int randomAvatar;
    private static int randomSecurityQuestion;

    public static void invokePostNewProfileEndpointWithValidRequest() {
        randomUsername = RandomStringUtils.random(20, true, true);
        randomDisplayName = RandomStringUtils.random(20, true, true);
        randomAge = new Random().nextInt((50 - 10) + 1) + 10;
        randomAvatar = new Random().nextInt((9 - 1) + 1) + 1;
        randomSecurityQuestion = new Random().nextInt(5);
        reqNewProfile.setUsername(randomUsername);
        reqNewProfile.setDisplayName(randomDisplayName);
        reqNewProfile.setAge(randomAge);
        reqNewProfile.setAvatar(randomAvatar);
        reqNewProfile.setParentEmail(null);
        reqNewProfile.setParentConsent(null);
        reqNewProfile.setSecurityQuestion(randomSecurityQuestion);
        reqNewProfile.setSecurityAnswer("Test");
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.POST_PROFILE.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(reqNewProfile)
                        .setExpectedStatusCode(HttpStatus.SC_CREATED)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
        setProfile(response.as(Profile_Res.class));
        DeleteProfile.invokeDeleteProfileEndpointWithValidUsername(randomUsername);
    }

    public static void invokePostNewProfileEndpointWithInValidBadRequest() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.POST_PROFILE.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setBody(new JSONObject(new HashMap<String,String>()).put("username", "Bad Request"))
                        .setExpectedStatusCode(HttpStatus.SC_BAD_REQUEST)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePostNewProfileEndpointWithInValidUnauthorizedRequest() {
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.POST_PROFILE.getBasePath())
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(HttpStatus.SC_UNAUTHORIZED)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokePostNewProfileEndpointWithInValidForbiddenRequest() {
        String jsonFilePath = ("src/test/resources/test_data/" + ScenarioContext.getContext(Context.TARGET_ENVIRONMENT).toString() + "/api/auth_access_tokens/AuthAccessTokens.json");
        headersMap.put("authorizationToken", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.PROD.getBaseURI())
                        .setBasePath(BasePath.POST_PROFILE.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addHeaders(headersMap)
                        .setExpectedStatusCode(HttpStatus.SC_BAD_REQUEST)
                        .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertResponsePayloadContainsAllExpectedParameters() {
        Assertions.hardAssert().objectEquals(getProfile().getUsername(), randomUsername);
        Assertions.hardAssert().objectEquals(getProfile().getDisplayName(), randomDisplayName);
        Assertions.hardAssert().objectEquals(getProfile().getAge(), randomAge);
        Assertions.hardAssert().objectEquals(getProfile().getAvatar(), randomAvatar);
        Assertions.hardAssert().objectEquals(getProfile().isParentConsent(), false);
        Assertions.hardAssert().objectEquals(getProfile().getSecurityQuestion(), randomSecurityQuestion);
    }
}