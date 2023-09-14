package steps.fe;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;
import pages.fe.OnBoardingScreen;
import readers.json_reader.JSONDataManager;

public class OnBoardingScreen_StepDef {
    private static final String test_Data_File_Path = ("src/test/resources/test_data/fe/expected/OnBoardingScreens.json");
    private static final JSONObject test_Data = JSONDataManager.parseJSON(test_Data_File_Path);

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
        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardOne(test_Data.get("onBoarding_Card_Title_1").toString(), test_Data.get("onBoarding_Card_Description_1").toString());
    }

    @Then("On boarding title and description text for card two should be displayed")
    public void onBoardingTitleAndDescriptionTextForCardTwoShouldBeDisplayed() {
        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardTwo(test_Data.get("onBoarding_Card_Title_2").toString(), test_Data.get("onBoarding_Card_Description_2").toString());
    }

    @Then("On boarding title and description text for card three should be displayed")
    public void onBoardingTitleAndDescriptionTextForCardThreeShouldBeDisplayed() {
        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardThree(test_Data.get("onBoarding_Card_Title_3").toString(), test_Data.get("onBoarding_Card_Description_3").toString());
    }

    @Then("On boarding title and description text for card four should be displayed")
    public void onBoardingTitleAndDescriptionTextForCardFourShouldBeDisplayed() {
//        OnBoardingScreen.assertOnBoardingTitleAndDescriptionTextForCardFour(test_Data.get("onBoarding_Card_Title_4").toString(), test_Data.get("onBoarding_Card_Description_4").toString());
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
        OnBoardingScreen.assertOnBoardingButtonComponentTextForCardFour(test_Data.get("onBoarding_Card_Button_Component").toString());
    }
}