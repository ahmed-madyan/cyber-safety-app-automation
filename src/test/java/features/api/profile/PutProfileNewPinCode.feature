@Regression   @Regression_API   @Put_Profile
Feature: Update user's pin code.

  @Put_Profile_New_Pin_Code_Valid_Request
  Scenario: Validate that PUT /profile/{username}/new-pin-code
    Given User login with valid authorized credentials
    When User invoke PUT new pin code api with valid successfully
    Then API response status code should be SC_OK
    And API response payload should contains success message for the pin code update

  @Put_Profile_New_Pin_Code_InValid_Bad_Request
  Scenario: Validate that PUT /profile/{username}/new-pin-code response should be SC_BAD_REQUEST when invoke api with invalid bad request
    Given User login with valid authorized credentials
    When User invoke PUT new pin code api with invalid bad request
    Then API response status code should be SC_BAD_REQUEST
    And API response payload should contains invalid bad request error message

  @Put_Profile_New_Pin_Code_InValid_Request_Unauthorized
  Scenario: Validate that PUT /profile/{username}/new-pin-code response should be SC_UNAUTHORIZED when invoke api with invalid request unauthorized
    Given User login with valid authorized credentials
    When User invoke PUT new pin code api with invalid request unauthorized
    Then API response status code should be SC_UNAUTHORIZED
    And API response payload should contains invalid unauthorized error message

  @Put_Profile_New_Pin_Code_InValid_Request_Forbidden
  Scenario: Validate that PUT /profile/{username}/new-pin-code response should be SC_FORBIDDEN when invoke api with invalid request forbidden
    Given User login with valid authorized credentials
    When User invoke PUT new pin code api with invalid request forbidden
    Then API response status code should be SC_FORBIDDEN
    And API response payload should contains invalid forbidden error message

  @Put_Profile_New_Pin_Code_InValid_Request_NotFound
  Scenario: Validate that PUT /profile/{username}/new-pin-code response should be SC_NOT_FOUND when invoke api with invalid request not found
    Given User login with valid authorized credentials
    When User invoke PUT new pin code api with invalid request not found
    Then API response status code should be SC_NOT_FOUND
    And API response payload should contains invalid not found error message