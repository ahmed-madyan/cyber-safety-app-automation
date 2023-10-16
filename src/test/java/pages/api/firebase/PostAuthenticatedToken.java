package pages.api.firebase;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.keys.FireBaseAPIKey;
import api.pojo.requests.firebase.AuthenticatedToken_Req;
import api.pojo.responses.firebase.AuthenticatedToken_Res;
import context.Context;
import context.ScenarioContext;
import io.restassured.response.Response;
import readers.json_reader.JSONDataManager;

import java.util.HashMap;
import java.util.Map;

public class PostAuthenticatedToken {
    private static Response response;
    private static final Map<String, String> queryParametersMap = new HashMap<>();

    public static void invokeAuthenticatedFireBaseIdentityProviderBasePathWithValidKey() {
        String jsonFilePath = ("src/test/resources/test_data/api/request/profile/Profile.json");
        AuthenticatedToken_Req authenticatedTokenReq = new AuthenticatedToken_Req();
        authenticatedTokenReq.setEmail(JSONDataManager.getJSONData(jsonFilePath, "username", JSONDataManager.Types.STRING).toString());
        authenticatedTokenReq.setPassword(JSONDataManager.getJSONData(jsonFilePath, "pinCode", JSONDataManager.Types.STRING).toString());
        authenticatedTokenReq.setReturnSecureToken(true);

        queryParametersMap.put("key", FireBaseAPIKey.KEY_PROD.getFireBaseAPIKey());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.FIREBASE_AUTHENTICATION.getBaseURI())
                        .setBasePath(BasePath.AUTHENTICATION_TOKEN.getBasePath())
                        .addQueryParams(queryParametersMap)
                        .setBody(authenticatedTokenReq)
                        .sendRequest();
    }

    public static void extractAuthenticatedJWTToken() {
        AuthenticatedToken_Res authenticatedTokenRes = response.as(AuthenticatedToken_Res.class);
        ScenarioContext.setContext(Context.AUTH_ACCESS_TOKEN, authenticatedTokenRes.getIdToken());
    }
}