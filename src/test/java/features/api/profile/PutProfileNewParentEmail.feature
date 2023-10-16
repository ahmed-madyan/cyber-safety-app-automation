@Regression   @Regression_API   @Put_Profile
Feature: Update user's parent-email

  @Put_Profile_New_Parent_Email_Valid_Request
  Scenario: Validate that PUT /profile/{username}/parent-email
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke PUT parent email api with valid successfully
    Then API response status code should be SC_OK.
    And API response payload should contains success message with the new parent email

  @Put_Profile_New_Parent_Email_InValid_Bad_Request
  Scenario: Validate that PUT /profile/{username}/parent-email response should be SC_BAD_REQUEST when invoke api with invalid bad request
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke PUT parent email api with invalid bad request
    Then API response status code should be SC_BAD_REQUEST.
    And API response payload should contains invalid bad request error message.

  @Put_Profile_New_Parent_Email_InValid_Request_Unauthorized
  Scenario: Validate that PUT /profile/{username}/parent-email response should be SC_UNAUTHORIZED when invoke api with invalid request unauthorized
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke PUT parent email api with invalid request unauthorized
    Then API response status code should be SC_UNAUTHORIZED.
    And API response payload should contains an invalid unauthorized error message.

  @Put_Profile_New_Parent_Email_InValid_Request_Forbidden
  Scenario: Validate that PUT /profile/{username}/parent-email response should be SC_FORBIDDEN when invoke api with invalid request forbidden
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke PUT parent email api with invalid request forbidden
    Then API response status code should be SC_FORBIDDEN.
    And API response payload should contains an invalid forbidden error message.

  @Put_Profile_New_Parent_Email_InValid_Request_NotFound
  Scenario: Validate that PUT /profile/{username}/parent-email response should be SC_NOT_FOUND when invoke api with invalid request not found
    Given I invoke the authenticated fireBase identity provider base path with a valid request.
    Then I should have the authorized access token extracted from the response payload.
    When User invoke PUT parent email api with invalid request not found
    Then API response status code should be SC_NOT_FOUND.
    And API response payload should contains an invalid not found error message.