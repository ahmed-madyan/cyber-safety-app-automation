package pages.fe;

import assertions.Assertions;
import elements.Elements;
import elements.gesture_actions.GestureDirection;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class OnBoardingScreen {
    private static final By onBoarding_Card_title_1 = AppiumBy.accessibilityId("onBoarding_Card_title_0");
    private static final By onBoarding_Card_description_1 = AppiumBy.accessibilityId("onBoarding_Card_description_0");
    private static final By onBoarding_Card_title_2 = AppiumBy.accessibilityId("onBoarding_Card_title_1");
    private static final By onBoarding_Card_description_2 = AppiumBy.accessibilityId("onBoarding_Card_description_1");
    private static final By onBoarding_Card_title_3 = AppiumBy.accessibilityId("onBoarding_Card_title_2");
    private static final By onBoarding_Card_description_3 = AppiumBy.accessibilityId("onBoarding_Card_description_2");
    private static final By onBoarding_Card_title_4 = AppiumBy.accessibilityId("onBoarding_Card_title_3");
    private static final By onBoarding_Card_description_4 = AppiumBy.accessibilityId("onBoarding_Card_description_3");
    private static final By onBoarding_Button_Component_4 = AppiumBy.accessibilityId("onBoarding_Button_Component");
    private static final By onBoarding_Button_Text = AppiumBy.accessibilityId("Button_text");
    private static final By pagination_Dot_1 = AppiumBy.accessibilityId("Pagination_Dot_0");
    private static final By pagination_Dot_2 = AppiumBy.accessibilityId("Pagination_Dot_1");
    private static final By pagination_Dot_3 = AppiumBy.accessibilityId("Pagination_Dot_2");
    private static final By pagination_Dot_4 = AppiumBy.accessibilityId("Pagination_Dot_3");

    public static void swipeOnBoardingCards() {
        swipeOnBoardingCard_1();
        swipeOnBoardingCard_2();
        swipeOnBoardingCard_3();
        clickOnBoardingButton();
    }

    public static void swipeOnBoardingCard_1() {
        Elements.gestureActions().swipe(onBoarding_Card_title_1, GestureDirection.LEFT);
    }

    public static void swipeOnBoardingCard_2() {
        Elements.gestureActions().swipe(onBoarding_Card_title_2, GestureDirection.LEFT);
    }

    public static void swipeOnBoardingCard_3() {
        Elements.gestureActions().swipe(onBoarding_Card_title_3, GestureDirection.LEFT);
    }

    public static void clickOnBoardingButton() {
        Elements.touchActions().tap(onBoarding_Button_Component_4);
    }

    public static void assertThatUserNavigatedToOnBoardingScreen() {
        Assertions.hardAssert().elementDisplayed(onBoarding_Card_description_1);
    }

    public static void assertThatAllElementsInTheFirstOnBoardingScreenExists() {
        Assertions.hardAssert().elementDisplayed(onBoarding_Card_description_1);
        Assertions.hardAssert().elementDisplayed(onBoarding_Card_title_1);
        Assertions.hardAssert().elementDisplayed(pagination_Dot_1);
        Assertions.hardAssert().elementDisplayed(pagination_Dot_2);
        Assertions.hardAssert().elementDisplayed(pagination_Dot_3);
        Assertions.hardAssert().elementDisplayed(pagination_Dot_4);
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardOne(String expectedValue_Title, String expectedValue_Description) {
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_title_1, expectedValue_Title);
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_description_1, expectedValue_Description);
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardTwo(String expectedValue_Title, String expectedValue_Description) {
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_title_2, expectedValue_Title);
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_description_2, expectedValue_Description);
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardThree(String expectedValue_Title, String expectedValue_Description) {
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_title_3, expectedValue_Title);
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_description_3, expectedValue_Description);
    }

    public static void assertOnBoardingTitleAndDescriptionTextForCardFour(String expectedValue_Title, String expectedValue_Description) {
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_title_4, expectedValue_Title);
        Assertions.hardAssert().elementTextToBe(onBoarding_Card_description_4, expectedValue_Description);
    }

    public static void assertOnBoardingButtonComponentTextForCardFour(String expectedValue_Button) {
        Assertions.hardAssert().elementTextToBe(onBoarding_Button_Text, expectedValue_Button);
    }
}