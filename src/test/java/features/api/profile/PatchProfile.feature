@Regression   @Regression_API   @Edit_Profile
Feature: Update Profile partially

  @Patch_Profile_Valid_Request
  Scenario: Validate that Patch /profile Endpoint retrieve the profile new details
    Given User login with valid authorized credentials
    When User invoke Patch profile api with valid successfully
    Then API response status code should be SC_OK
    And API response payload should contains the new profile details

  @Patch_Profile_InValid_Bad_Request
  Scenario: Validate that Patch /profile response should be SC_BAD_REQUEST when invoke api with invalid bad request
    Given User login with valid authorized credentials
    When User invoke Patch profile api with invalid bad request
    Then API response status code should be SC_BAD_REQUEST
    And API response payload should contains invalid bad request error message

  @Patch_Profile_InValid_Request_Unauthorized
  Scenario: Validate that Patch /profile response should be SC_UNAUTHORIZED when invoke api with invalid request unauthorized
    Given User login with valid authorized credentials
    When User invoke Patch profile api with invalid request unauthorized
    Then API response status code should be SC_UNAUTHORIZED
    And API response payload should contains invalid unauthorized error message

  @Patch_Profile_InValid_Request_Forbidden
  Scenario: Validate that Patch /profile response should be SC_FORBIDDEN when invoke api with invalid request forbidden
    Given User login with valid authorized credentials
    When User invoke Patch profile api with invalid request forbidden
    Then API response status code should be SC_FORBIDDEN
    And API response payload should contains invalid forbidden error message

  @Patch_Profile_InValid_Request_NotFound
  Scenario: Validate that Patch /profile response should be SC_NOT_FOUND when invoke api with invalid request not found
    Given User login with valid authorized credentials
    When User invoke Patch profile api with invalid request not found
    Then API response status code should be SC_NOT_FOUND
    And API response payload should contains invalid not found error message