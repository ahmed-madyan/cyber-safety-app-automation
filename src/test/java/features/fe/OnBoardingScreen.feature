@Regression @Regression_FE @OnBoardingScreen
Feature: On Boarding - 4 Screens

  @OnBoardingScreen_TC1
  Scenario: Validate on boarding 4 screens text
    Given User navigates to on boarding screen
    Then User should see all the elements exists
    And On boarding title and description text for card one should be displayed
    When Swipe to card two
    Then On boarding title and description text for card two should be displayed
    When Swipe to card three
    Then On boarding title and description text for card three should be displayed
    When Swipe to card four
    Then On boarding title and description text for card four should be displayed
    Then On boarding button for card four should be displayed

  @OnBoardingScreen_TC1
  Scenario: Validate on boarding 4 screens text 2
    Given User navigates to on boarding screen
    Then User should see all the elements exists
    And On boarding title and description text for card one should be displayed
    When Swipe to card two
    Then On boarding title and description text for card two should be displayed
    When Swipe to card three
    Then On boarding title and description text for card three should be displayed
    When Swipe to card four
    Then On boarding title and description text for card four should be displayed
    Then On boarding button for card four should be displayed

  @OnBoardingScreen_TC2
  Scenario: Validate that user will be redirected to the topics screen when swiping the on boarding screens
    Given User navigates to on boarding screen
    When Swipe On Boarding Cards
#    Then User should be redirected to the topics screen