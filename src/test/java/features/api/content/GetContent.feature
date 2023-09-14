@Regression   @Regression_API   @Content_Management
Feature:  Validate positive and negative scenarios for the Get Content endpoint.

  Background: Extract anonymous user jwt token.
    Given I invoke the anonymous fireBase identity provider base path with a valid key.
    Then I should have the anonymous access token extracted from the response payload.

  @GET_Full_List_Of_Content
  @Content_Valid_Request
  Scenario: Validate that the Get /content Endpoint retrieves the list of content when sending a valid request.
    Given the User invokes the content API with valid successfully.
    Then API response status code should be SC_OK.
    And API response payload should contain a list of content items that include all contents for all content types.

  @Content_InValid_Request_Unauthorized
  Scenario: Validate that Get /content response should be SC_UNAUTHORIZED when invoking API with an invalid request unauthorized.
    Given User invoke the content API with an invalid request unauthorized.
    Then API response status code should be SC_UNAUTHORIZED.
    And API response payload should contain an invalid unauthorized error message.

  @Content_InValid_Request_Forbidden
  Scenario: Validate that the Get /content response should be SC_FORBIDDEN when invoking API with an invalid request forbidden.
    Given User invoke the content API with an invalid request forbidden.
    Then API response status code should be SC_FORBIDDEN.
    And API response payload should contain an invalid forbidden error message.