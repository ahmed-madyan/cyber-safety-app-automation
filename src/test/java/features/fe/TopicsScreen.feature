@Regression @Regression_FE @TopicsScreen
Feature: On Boarding - Topics

  @TopicsScreen_TC1   @TopicsScreen_Content
  Scenario: Validate Topics Screen content
    Given User navigates to on boarding screen
    When Swipe On Boarding Cards
    Then User should be redirected to the topics screen
    And Topics Screen content should be displayed

  @TopicsScreen_TC2   @TopicsScreen_Skip_Button
  Scenario: Validate that skip button will redirect the user to the cosmos screen
    Given User navigates to on boarding screen
    When Swipe On Boarding Cards
    Then User should be redirected to the topics screen
    When User clicks skip on Topics Screen
    Then User should be redirected to terms and conditions pop up

  @TopicsScreen_TC3   @TopicsScreen_Go_Button
  Scenario: Validate that Go button will redirect the user to the cosmos screen
    Given User navigates to on boarding screen
    When Swipe On Boarding Cards
    When User clicks Go on Topics Screen
    Then User should be redirected to terms and conditions pop up