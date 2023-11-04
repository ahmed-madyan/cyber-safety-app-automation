package pages.fe;

import assertions.Assertions;
import elements.Elements;
import elements.gesture_actions.GestureDirection;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import readers.json_reader.JSONDataManager;

public class OnBoardingScreen {
    private static final By ON_BOARDING_CARD_TITLE_1 = AppiumBy.name("onBoarding_Card_description_testing");
    private static final By ON_BOARDING_CARD_DESCRIPTION_1 = AppiumBy.accessibilityId("onBoarding_Card_description_testing");
    private static final By ON_BOARDING_CARD_TITLE_2 = AppiumBy.accessibilityId("onBoarding_Card_title_1");
    private static final By ON_BOARDING_CARD_DESCRIPTION_2 = AppiumBy.accessibilityId("onBoarding_Card_description_1");
    private static final By ON_BOARDING_CARD_TITLE_3 = AppiumBy.accessibilityId("onBoarding_Card_title_2");
    private static final By ON_BOARDING_CARD_DESCRIPTION_3 = AppiumBy.accessibilityId("onBoarding_Card_description_2");
    private static final By ON_BOARDING_CARD_TITLE_4 = AppiumBy.accessibilityId("onBoarding_Card_title_3");
    private static final By ON_BOARDING_CARD_DESCRIPTION_4 = AppiumBy.accessibilityId("onBoarding_Card_description_3");
    private static final By ON_BOARDING_BUTTON_COMPONENT_4 = AppiumBy.accessibilityId("onBoarding_Button_Component");
    private static final By ON_BOARDING_BUTTON_TEXT = AppiumBy.accessibilityId("Button_text");
    private static final By PAGINATION_DOT_1 = AppiumBy.accessibilityId("Pagination_Dot_0");
    private static final By PAGINATION_DOT_2 = AppiumBy.accessibilityId("Pagination_Dot_1");
    private static final By PAGINATION_DOT_3 = AppiumBy.accessibilityId("Pagination_Dot_2");
    private static final By PAGINATION_DOT_4 = AppiumBy.accessibilityId("Pagination_Dot_3");
    private static final String TEST_DATA_FILE_PATH = ("src/test/resources/test_data/fe/expected/OnBoardingScreens.json");
    public static void swipeOnBoardingCards() {
        swipeOnBoardingCard_1();
        swipeOnBoardingCard_2();
        swipeOnBoardingCard_3();
        clickOnBoardingButton();
    }

    public static void swipeOnBoardingCard_1() {
        Elements.gestureActions().swipe(ON_BOARDING_CARD_TITLE_1, GestureDirection.LEFT);
    }

    public static void swipeOnBoardingCard_2() {
        Elements.gestureActions().swipe(ON_BOARDING_CARD_TITLE_2, GestureDirection.LEFT);
    }

    public static void swipeOnBoardingCard_3() {
        Elements.gestureActions().swipe(ON_BOARDING_CARD_TITLE_3, GestureDirection.LEFT);
    }

    public static void clickOnBoardingButton() {
        Elements.elementActions().click(ON_BOARDING_BUTTON_COMPONENT_4);
    }

    public static void assertThatUserNavigatedToOnBoardingScreen() {
        Assertions.hardAssert().elementDisplayed(ON_BOARDING_CARD_DESCRIPTION_1);
    }

    public static void assertThatAllElementsInTheFirstOnBoardingScreenExists() {
        Assertions.hardAssert().elementDisplayed(ON_BOARDING_CARD_DESCRIPTION_1);
        Assertions.hardAssert().elementDisplayed(ON_BOARDING_CARD_TITLE_1);
        Assertions.hardAssert().elementDisplayed(PAGINATION_DOT_1);
        Assertions.hardAssert().elementDisplayed(PAGINATION_DOT_2);
        Assertions.hardAssert().elementDisplayed(PAGINATION_DOT_3);
        Assertions.hardAssert().elementDisplayed(PAGINATION_DOT_4);
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardOne() {
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_TITLE_1, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Title_1", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_DESCRIPTION_1, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Description_1", JSONDataManager.Types.STRING).toString());
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardTwo() {
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_TITLE_2, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Title_2", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_DESCRIPTION_2, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Description_2", JSONDataManager.Types.STRING).toString());
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardThree() {
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_TITLE_3, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Title_3", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_DESCRIPTION_3, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Description_3", JSONDataManager.Types.STRING).toString());
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardFour() {
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_TITLE_4, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Title_4", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().elementTextToBe(ON_BOARDING_CARD_DESCRIPTION_4, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Description_4", JSONDataManager.Types.STRING).toString());
    }

    public static void assertOnBoardingButtonComponentTextForCardFour() {

        Assertions.hardAssert().elementTextToBe(ON_BOARDING_BUTTON_TEXT, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Button_Component", JSONDataManager.Types.STRING).toString());
    }
}