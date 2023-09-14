package pages.api.firebase;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.keys.FireBaseAPIKey;
import api.pojo.responses.firebase.AnonymousToken_Res;
import context.ScenarioContext;
import context.Context;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class PostAnonymousToken {
    private static Response response;

    public static void invokeAnonymousFireBaseIdentityProviderBasePathWithValidKey() {
        Map<String, String> queryParametersMap = new HashMap<>();
        queryParametersMap.put("key", FireBaseAPIKey.KEY.getFireBaseAPIKey());
        response =
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.POST)
                        .setBaseUri(BaseURI.FIREBASE_ANONYMOUS.getBaseURI())
                        .setBasePath(BasePath.ANONYMOUS_TOKEN.getBasePath())
                        .setContentType(ContentType.JSON)
                        .addQueryParams(queryParametersMap)
                        .setExpectedStatusCode(HttpStatus.SC_OK)
                        .sendRequest();
    }

    public static void extractAnonymousJWTToken() {
        AnonymousToken_Res fireBase = response.as(AnonymousToken_Res.class);
        ScenarioContext.setContext(Context.AUTH_ACCESS_TOKEN, fireBase.getIdToken());
        System.out.println("AUTH_ACCESS_TOKEN:\n" + ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN));
    }
}