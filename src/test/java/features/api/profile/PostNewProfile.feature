@Regression   @Regression_API   @Profile
Feature: Create new profile

  @Create_New_Profile
  @New_Profile_Valid_Request
  Scenario: Validate that POST /profile Endpoint retrieves the newly created profile details
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke create profile api with valid successfully
    Then API response status code should be SC_CREATED.
    And API response payload should contains the new user details

  @New_Profile_InValid_Bad_Request
  Scenario: Validate that POST /profile response should be SC_BAD_REQUEST when invoke api with invalid bad request
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke create profile api with invalid bad request
    Then API response status code should be SC_BAD_REQUEST.
    And API response payload should contains invalid bad request error message.

  @New_Profile_InValid_Request_Unauthorized
  Scenario: Validate that POST /profile response should be SC_UNAUTHORIZED when invoke api with invalid request unauthorized
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke create profile api with invalid request unauthorized
    Then API response status code should be SC_UNAUTHORIZED.
    And API response payload should contains an invalid unauthorized error message.

  @New_Profile_InValid_Request_Forbidden
  Scenario: Validate that POST /profile response should be SC_FORBIDDEN when invoke api with invalid request forbidden
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke create profile api with invalid request forbidden
    Then API response status code should be SC_FORBIDDEN.
    And API response payload should contains an invalid forbidden error message.