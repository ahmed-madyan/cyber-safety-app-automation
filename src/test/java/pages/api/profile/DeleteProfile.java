package pages.api.profile;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import context.Context;
import context.ScenarioContext;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static org.apache.http.HttpStatus.SC_ACCEPTED;

public class DeleteProfile {
    private static final HashMap<String, String> headersMap = new HashMap<>();

    public static Response invokeDeleteProfileEndpointWithValidUsername(String username) {
        headersMap.put("authorizationToken", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        return
                APIActions
                        .setRequestSpecifications()
                        .setRequestMethod(RequestMethod.DELETE)
                        .setBaseUri(BaseURI.SIT.getBaseURI())
                        .setBasePath(BasePath.PROFILE.getBasePath().replace("{username}", username))
                        .addHeaders(headersMap)
                        .setContentType(ContentType.JSON)
                        .setExpectedStatusCode(SC_ACCEPTED)
                        .sendRequest();
    }
}