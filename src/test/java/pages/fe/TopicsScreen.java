package pages.fe;

import assertions.Assertions;
import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import readers.json_reader.JSONDataManager;

public class TopicsScreen {
    private static final By topicsScreen_SkipButton = AppiumBy.accessibilityId("TopicsScreen_Skip_text");
    private static final By topicsScreen_title_text = AppiumBy.accessibilityId("TopicsScreen_title_text");
    private static final By topicsScreen_subTitle_text = AppiumBy.accessibilityId("TopicsScreen_subTitle_text");
    private static final By topicsScreen_Socials = AppiumBy.accessibilityId("Topic_Socials");
    private static final By topicsScreen_DealingWithDrama = AppiumBy.accessibilityId("Topic_Dealing with Drama");
    private static final By topicsScreen_StayingZen = AppiumBy.accessibilityId("Topic_Staying Zen");
    private static final By topicsScreen_BeatBulling = AppiumBy.accessibilityId("Topic_Beat Bulling");
    private static final By topicsScreen_ShieldUp = AppiumBy.accessibilityId("Topic_Shield Up");
    private static final By topicsScreen_GoButton = AppiumBy.accessibilityId("Topic_Shield Up");
    private static final String topicsScreen_TestData_FilePath = ("src/test/resources/test_data/fe/expected/TopicsScreens.json");

    public static void assertThatUserRedirectedToTheTopicsScreen() {
        Assertions.hardAssert().elementDisplayed(topicsScreen_title_text);
    }

    public static void clickSkip() {
        Elements.elementActions().click(topicsScreen_SkipButton);
    }

    public static void clickGo() {
        Elements.elementActions().click(topicsScreen_GoButton);
    }

    public static void assertSkipButtonText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(topicsScreen_SkipButton);
        Assertions.hardAssert().elementAttributeToBe(topicsScreen_SkipButton, "text", expectedText);
    }

    public static void assertGoButtonText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(topicsScreen_GoButton);
        Assertions.hardAssert().elementAttributeToBe(topicsScreen_GoButton, "text", expectedText);
    }

    public static void assertTopicsScreenContent() {
        assertExploreHeaderTitleText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "explore_Header_Title", JSONDataManager.Types.STRING).toString());
        assertExploreHeaderSubTitleText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "explore_Header_Sub_Title", JSONDataManager.Types.STRING).toString());
        assertSkipButtonText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "skip_Button", JSONDataManager.Types.STRING).toString());
        assertGoButtonText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "go_Button", JSONDataManager.Types.STRING).toString());
    }

    public static void assertExploreHeaderTitleText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(topicsScreen_title_text);
        Assertions.hardAssert().elementAttributeToBe(topicsScreen_title_text, "text", expectedText);
    }

    public static void assertExploreHeaderSubTitleText(String expectedText) {
        Assertions.hardAssert().elementDisplayed(topicsScreen_subTitle_text);
        Assertions.hardAssert().elementAttributeToBe(topicsScreen_subTitle_text, "text", expectedText);
    }

    public static void selectTopicSocials() {
        Elements.elementActions().click(topicsScreen_Socials);
    }

    public static void selectTopicDealingWithDrama() {
        Elements.elementActions().click(topicsScreen_DealingWithDrama);
    }

    public static void selectTopicStayingZen() {
        Elements.elementActions().click(topicsScreen_StayingZen);
    }

    public static void selectTopicBeatBulling() {
        Elements.elementActions().click(topicsScreen_BeatBulling);
    }

    public static void selectTopicShieldUp() {
        Elements.elementActions().click(topicsScreen_ShieldUp);
    }
}