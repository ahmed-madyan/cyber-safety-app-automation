package pages.api.content;

import api.base_paths.BasePath;
import api.base_uris.BaseURI;
import api.driver.APIActions;
import api.driver.RequestMethod;
import api.pojo.responses.content.Content_Res;
import context.Context;
import context.ScenarioContext;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import logger.Log4JLogger;
import org.testng.Assert;
import readers.json_reader.JSONDataManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.http.HttpStatus.*;

public class GetFullContentList {
    private static Response response = null;
    private static final Map<String, String> headersMap = new HashMap<>();

    public static void invokeContentEndpointWithValidRequest() {
        headersMap.put("token", ScenarioContext.getContext(Context.AUTH_ACCESS_TOKEN).toString());
        Log4JLogger.logINFO(GetFullContentList.class,headersMap.toString());
        response = APIActions
                .setRequestSpecifications()
                .setRequestMethod(RequestMethod.GET)
                .setBaseUri(BaseURI.SIT.getBaseURI())
                .setBasePath(BasePath.CONTENT.getBasePath())
                .setContentType(ContentType.JSON)
                .addHeaders(headersMap)
                .setExpectedStatusCode(SC_OK)
                .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokeContentEndpointWithInValidUnauthorizedRequest() {
        response = APIActions
                .setRequestSpecifications()
                .setRequestMethod(RequestMethod.GET)
                .setBaseUri(BaseURI.SIT.getBaseURI())
                .setBasePath(BasePath.CONTENT.getBasePath())
                .setContentType(ContentType.JSON)
                .setExpectedStatusCode(SC_UNAUTHORIZED)
                .sendRequest();
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void invokeContentEndpointWithInValidForbiddenRequest() {
        String jsonFilePath = ("src/test/resources/test_data/api/request/auth_access_tokens/AuthAccessTokens.json");
        headersMap.put("token", JSONDataManager.getJSONData(jsonFilePath, "AUTH_ACCESS_TOKEN_FORBIDDEN", JSONDataManager.Types.STRING).toString());
        response = APIActions
                .setRequestSpecifications()
                .setRequestMethod(RequestMethod.GET)
                .setBaseUri(BaseURI.SIT.getBaseURI())
                .setBasePath(BasePath.CONTENT.getBasePath())
                .setContentType(ContentType.JSON)
                .addHeaders(headersMap)
                .setExpectedStatusCode(SC_FORBIDDEN)
                .sendRequest();
        Assert.assertEquals(response.getStatusCode(), SC_FORBIDDEN);
        ScenarioContext.setContext(Context.RESPONSE_PAYLOAD, response);
    }

    public static void assertFullContentResponsePayloadValues() {
        final String jsonFilePath = ("src/test/resources/test_data/api/response/content/GetContentList.json");

        List<Content_Res> contentList = response.as(new TypeRef<>() {
        });
        List<?> expectedListOfContentIDs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.contentId", JSONDataManager.Types.LIST);
        List<?> expectedListOfTitles = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.contentTitle", JSONDataManager.Types.LIST);
        List<?> expectedListContentTypes = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.contentType", JSONDataManager.Types.LIST);
        List<?> expectedListOfDuration = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.duration", JSONDataManager.Types.LIST);
        List<?> expectedListOfIconURLs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.iconURL", JSONDataManager.Types.LIST);
        List<?> expectedListOfImageURLs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.imageURL", JSONDataManager.Types.LIST);
        List<?> expectedListOfKeywords = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.keywords", JSONDataManager.Types.LIST);
        List<?> expectedListOfMarginBottoms = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginBottom", JSONDataManager.Types.LIST);
        List<?> expectedListOfMarginLefts = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginLeft", JSONDataManager.Types.LIST);
        List<?> expectedListOfMarginRights = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginRight", JSONDataManager.Types.LIST);
        List<?> expectedListOfMarginTops = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.marginTop", JSONDataManager.Types.LIST);
        List<?> expectedListOfShapeURLs = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.shapeURL", JSONDataManager.Types.LIST);
        List<?> expectedListOfSuggested = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.suggested", JSONDataManager.Types.LIST);
        List<?> expectedListOfTopics = (List<?>) JSONDataManager.getJSONData(jsonFilePath, "Content.topics", JSONDataManager.Types.LIST);
        for (int i = 0; i < contentList.size() - 1; i++) {
            Assert.assertEquals(contentList.get(i).getContentId(), expectedListOfContentIDs.get(i));
            Assert.assertEquals(contentList.get(i).getContentTitle(), expectedListOfTitles.get(i));
            Assert.assertEquals(contentList.get(i).getContentType(), expectedListContentTypes.get(i));
            if (expectedListOfDuration.get(i) == null) {
                Assert.assertEquals(contentList.get(i).getDuration(), 0);
            } else Assert.assertEquals(contentList.get(i).getDuration(), expectedListOfDuration.get(i));
            Assert.assertEquals(contentList.get(i).getIconURL(), expectedListOfIconURLs.get(i));
            Assert.assertEquals(contentList.get(i).getImageURL(), expectedListOfImageURLs.get(i));
            Assert.assertEquals(contentList.get(i).getKeywords(), expectedListOfKeywords.get(i));
            Assert.assertEquals(contentList.get(i).getMarginBottom(), expectedListOfMarginBottoms.get(i));
            Assert.assertEquals(contentList.get(i).getMarginLeft(), expectedListOfMarginLefts.get(i));
            Assert.assertEquals(contentList.get(i).getMarginRight(), expectedListOfMarginRights.get(i));
            Assert.assertEquals(contentList.get(i).getMarginTop(), expectedListOfMarginTops.get(i));
            Assert.assertEquals(contentList.get(i).getShapeURL(), expectedListOfShapeURLs.get(i));
            Assert.assertEquals(contentList.get(i).isSuggested(), expectedListOfSuggested.get(i));
            Assert.assertEquals(contentList.get(i).getTopics(), expectedListOfTopics.get(i));
        }
    }

    public static void assertResponsePayloadContainsAllExpectedParameters() {
        Assert.assertNotNull(response.getBody().jsonPath().get("contentId"));
        Assert.assertNotNull(response.getBody().jsonPath().get("contentTitle"));
        Assert.assertNotNull(response.getBody().jsonPath().get("contentType"));
        Assert.assertNotNull(response.getBody().jsonPath().get("duration"));
        Assert.assertNotNull(response.getBody().jsonPath().get("iconURL"));
        Assert.assertNotNull(response.getBody().jsonPath().get("imageURL"));
        Assert.assertNotNull(response.getBody().jsonPath().get("keywords"));
        Assert.assertNotNull(response.getBody().jsonPath().get("marginBottom"));
        Assert.assertNotNull(response.getBody().jsonPath().get("marginLeft"));
        Assert.assertNotNull(response.getBody().jsonPath().get("marginRight"));
        Assert.assertNotNull(response.getBody().jsonPath().get("marginTop"));
        Assert.assertNotNull(response.getBody().jsonPath().get("shapeURL"));
        Assert.assertNotNull(response.getBody().jsonPath().get("suggested"));
        Assert.assertNotNull(response.getBody().jsonPath().get("topics"));
    }
}