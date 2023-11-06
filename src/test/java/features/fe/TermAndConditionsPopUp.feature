@Regression @Regression_FE @TermsAndConditions
Feature: terms and conditions - pop up

  Background: Skip to cosmos screen
    When User navigates to on boarding screen
    And Swipe On Boarding Cards
    And User clicks Go on Topics Screen
    Then User should be redirected to terms and conditions pop up

  @TermsAndConditions_TC1   @TermsAndConditions_Content
  Scenario: Validate terms and conditions dialogues
    Then Validate pop up header text
    Then Validate pop up dialoge
    And Validate skip button text

  @TermsAndConditions_TC2   @TermsAndConditions_Skip_Button
  Scenario: Validate that pop up skip button will redirect the user to the cosmos screen
    Given User skip the pop up
    Then User should be redirected to the Cosmos screen

  @TermsAndConditions_TC3   @TermsAndConditions_Close_Button
  Scenario: Validate that pop up close button will redirect the user to the cosmos screen
    Given User close the pop up
    Then User should be redirected to the Cosmos screen