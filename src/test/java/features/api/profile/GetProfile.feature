@Regression   @Regression_API   @Get_Profile
Feature: Retrieve profile details By uuid

  @Get_Profile_Valid_Request
  Scenario: Validate that Get /profile Endpoint retrieve the profile details
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke Get profile api with valid successfully
    Then API response status code should be SC_OK.
    And API response payload should contains the profile details

  @Get_Profile_InValid_Request_Unauthorized
  Scenario: Validate that Get /profile response should be SC_UNAUTHORIZED when invoke api with invalid request unauthorized
    Given User invoke Get profile api with invalid request unauthorized
    Then API response status code should be SC_UNAUTHORIZED.
    And API response payload should contains an invalid unauthorized error message.

  @Get_Profile_InValid_Request_Forbidden
  Scenario: Validate that Get /profile response should be SC_FORBIDDEN when invoke api with invalid request forbidden
    Given User invoke Get profile api with invalid request forbidden
    Then API response status code should be SC_FORBIDDEN.
    And API response payload should contains an invalid forbidden error message.

  @Get_Profile_InValid_Request_NotFound
  Scenario: Validate that Get /profile response should be SC_NOT_FOUND when invoke api with invalid request not found
    Given User invoke Get profile api with invalid request not found
    When User invoke Get profile api with invalid request not found
    Then API response status code should be SC_NOT_FOUND.
    And API response payload should contains an invalid not found error message.