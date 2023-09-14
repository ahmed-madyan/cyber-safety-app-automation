package pages.api.error_code_assertions;

import assertions.Assertions;
import io.restassured.response.Response;
import readers.json_reader.JSONDataManager;

public class ErrorCodeAssertions {
    private static final String jsonFilePath = ("src/test/resources/test_data/api/response/error_code_assertions/ErrorCodeAssertions.json");

    /**
     * SC_BAD_REQUEST = 400
     **/
    public static void apiResponsePayloadShouldContainsInvalidBadRequestErrorMessage(Response response) {
        assert response != null;
        Assertions.hardAssert().objectEquals(response.jsonPath().get("message"), JSONDataManager.getJSONData(jsonFilePath, "Profile_InvalidBadRequestErrorMessage", JSONDataManager.Types.STRING));
    }

    /**
     * SC_UNAUTHORIZED = 401
     **/
    public static void apiResponsePayloadShouldContainsInvalidUnauthorizedErrorMessage(Response response) {
        assert response != null;
        Assertions.hardAssert().objectEquals(response.jsonPath().get("message"), JSONDataManager.getJSONData(jsonFilePath, "Profile_InvalidUnauthorizedErrorMessage", JSONDataManager.Types.STRING));
    }

    /**
     * SC_FORBIDDEN = 403
     **/
    public static void apiResponsePayloadShouldContainsInvalidForbiddenErrorMessage(Response response) {
        assert response != null;
        Assertions.hardAssert().objectEquals(response.jsonPath().get("Message"), JSONDataManager.getJSONData(jsonFilePath, "Profile_InvalidForbiddenErrorMessage", JSONDataManager.Types.STRING));
    }

    /**
     * SC_NOT_FOUND = 404
     **/
    public static void apiResponsePayloadShouldContainsInvalidNotFoundErrorMessage(Response response) {
        assert response != null;
        Assertions.hardAssert().objectEquals(response.jsonPath().get("Message"), JSONDataManager.getJSONData(jsonFilePath, "Profile_InvalidNotFoundErrorMessage", JSONDataManager.Types.STRING));
    }
}