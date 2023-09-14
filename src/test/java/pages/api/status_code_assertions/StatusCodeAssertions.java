package pages.api.status_code_assertions;

import io.restassured.response.Response;
import org.apache.http.HttpStatus;

public class StatusCodeAssertions {
    /**
     * SC_OK = 200
     **/
    public static void apiResponseStatusCodeShouldBeSC_OK(Response response) {
        assert response != null;
        response.then().assertThat().statusCode(HttpStatus.SC_OK);
    }

    /**
     * SC_CREATED = 201
     **/
    public static void apiResponseStatusCodeShouldBeSC_CREATED(Response response) {
        assert response != null;
        response.then().assertThat().statusCode(HttpStatus.SC_CREATED);
    }

    /**
     * SC_BAD_REQUEST = 400
     **/
    public static void apiResponseStatusCodeShouldBeSC_BAD_REQUEST(Response response) {
        assert response != null;
        response.then().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    /**
     * SC_UNAUTHORIZED = 401
     **/
    public static void apiResponseStatusCodeShouldBeSC_UNAUTHORIZED(Response response) {
        assert response != null;
        response.then().assertThat().statusCode(HttpStatus.SC_UNAUTHORIZED);
    }

    /**
     * SC_FORBIDDEN = 403
     **/
    public static void apiResponseStatusCodeShouldBeSC_FORBIDDEN(Response response) {
        assert response != null;
        response.then().assertThat().statusCode(HttpStatus.SC_FORBIDDEN);
    }

    /**
     * SC_NOT_FOUND = 404
     **/
    public static void apiResponseStatusCodeShouldBeSC_NOT_FOUND(Response response) {
        assert response != null;
        response.then().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }
}