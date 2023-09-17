package steps.fe;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.fe.OnBoardingScreen;

public class OnBoardingScreen_StepDef {
    @Given("User navigates to on boarding screen")
    public void userNavigatesToOnBoardingScreen() {
        OnBoardingScreen.assertThatUserNavigatedToOnBoardingScreen();
    }

    @Then("User should see all the elements exists")
    public void userShouldSeeAllTheElementsExists() {
        OnBoardingScreen.assertThatAllElementsInTheFirstOnBoardingScreenExists();
    }

    @Then("On boarding title and description text for card one should be displayed")
    public void onBoardingTitleAndDescriptionTextForCardOneShouldBeDisplayed() {
        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardOne();
    }

    @Then("On boarding title and description text for card two should be displayed")
    public void onBoardingTitleAndDescriptionTextForCardTwoShouldBeDisplayed() {
        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardTwo();
    }

    @Then("On boarding title and description text for card three should be displayed")
    public void onBoardingTitleAndDescriptionTextForCardThreeShouldBeDisplayed() {
        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardThree();
    }

    @Then("On boarding title and description text for card four should be displayed")
    public void onBoardingTitleAndDescriptionTextForCardFourShouldBeDisplayed() {
//        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardFour();
    }

    @When("Swipe to card two")
    public void swipeTheCardTwo() {
        OnBoardingScreen.swipeOnBoardingCard_1();
    }

    @When("Swipe to card three")
    public void swipeTheCardThree() {
        OnBoardingScreen.swipeOnBoardingCard_2();
    }

    @When("Swipe to card four")
    public void swipeTheCardFour() {
        OnBoardingScreen.swipeOnBoardingCard_3();
    }

    @When("Swipe On Boarding Cards")
    public void swipeOnBoardingCards() {
        OnBoardingScreen.swipeOnBoardingCards();
    }

    @Then("On boarding button for card four should be displayed")
    public void onBoardingButtonForCardFourShouldBeDisplayed() {
        OnBoardingScreen.assertOnBoardingButtonComponentTextForCardFour();
    }
}