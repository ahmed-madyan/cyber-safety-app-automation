package pages.fe;

import assertions.Assertions;
import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import readers.json_reader.JSONDataManager;

public class TopicsScreen {
    private static final By TOPICS_SCREEN_SKIP_BUTTON = AppiumBy.accessibilityId("TopicsScreen_Skip_text");
    private static final By TOPICS_SCREEN_TITLE_TEXT = AppiumBy.accessibilityId("TopicsScreen_title_text");
    private static final By TOPICS_SCREEN_SUB_TITLE_TEXT = AppiumBy.accessibilityId("TopicsScreen_subTitle_text");
    private static final By TOPICS_SCREEN_SOCIALS = AppiumBy.accessibilityId("Topic_Socials");
    private static final By TOPICS_SCREEN_DEALING_WITH_DRAMA = AppiumBy.accessibilityId("Topic_Dealing with Drama");
    private static final By TOPICS_SCREEN_STAYING_ZEN = AppiumBy.accessibilityId("Topic_Staying Zen");
    private static final By TOPICS_SCREEN_BEAT_BULLING = AppiumBy.accessibilityId("Topic_Beat Bulling");
    private static final By TOPICS_SCREEN_SHIELD_UP = AppiumBy.accessibilityId("Topic_Shield Up");
    private static final By TOPICS_SCREEN_GO_BUTTON = AppiumBy.accessibilityId("TopicsScreen_Button");
    private static final By TOPICS_SCREEN_GO_BUTTON_TEXT = AppiumBy.accessibilityId("Button_text");
    private static final String TEST_DATA_FILE_PATH = ("src/test/resources/test_data/fe/expected/TopicsScreens.json");

    public static void assertThatUserRedirectedToTheTopicsScreen() {
        Assertions.hardAssert().elementDisplayed(TOPICS_SCREEN_TITLE_TEXT);
    }

    public static void clickSkip() {
        Elements.elementActions().click(TOPICS_SCREEN_SKIP_BUTTON);
    }

    public static void clickGo() {
        Elements.elementActions().click(TOPICS_SCREEN_GO_BUTTON);
    }

    public static void assertSkipButtonText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(TOPICS_SCREEN_SKIP_BUTTON);
        Assertions.hardAssert().elementAttributeToBe(TOPICS_SCREEN_SKIP_BUTTON, "text", expectedText);
    }

    public static void assertGoButtonText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(TOPICS_SCREEN_GO_BUTTON);
        Assertions.hardAssert().elementAttributeToBe(TOPICS_SCREEN_GO_BUTTON_TEXT, "text", expectedText);
    }

    public static void assertTopicsScreenContent() {
        assertExploreHeaderTitleText(JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "explore_Header_Title", JSONDataManager.Types.STRING).toString());
        assertExploreHeaderSubTitleText(JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "explore_Header_Sub_Title", JSONDataManager.Types.STRING).toString());
        assertSkipButtonText(JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "skip_Button", JSONDataManager.Types.STRING).toString());
        assertGoButtonText(JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "go_Button", JSONDataManager.Types.STRING).toString());
    }

    public static void assertExploreHeaderTitleText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(TOPICS_SCREEN_TITLE_TEXT);
        Assertions.hardAssert().elementAttributeToBe(TOPICS_SCREEN_TITLE_TEXT, "text", expectedText);
    }

    public static void assertExploreHeaderSubTitleText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(TOPICS_SCREEN_SUB_TITLE_TEXT);
        Assertions.hardAssert().elementAttributeToBe(TOPICS_SCREEN_SUB_TITLE_TEXT, "text", expectedText);
    }

    public static void selectTopicSocials() {
        Elements.elementActions().click(TOPICS_SCREEN_SOCIALS);
    }

    public static void selectTopicDealingWithDrama() {
        Elements.elementActions().click(TOPICS_SCREEN_DEALING_WITH_DRAMA);
    }

    public static void selectTopicStayingZen() {
        Elements.elementActions().click(TOPICS_SCREEN_STAYING_ZEN);
    }

    public static void selectTopicBeatBulling() {
        Elements.elementActions().click(TOPICS_SCREEN_BEAT_BULLING);
    }

    public static void selectTopicShieldUp() {
        Elements.elementActions().click(TOPICS_SCREEN_SHIELD_UP);
    }
}