package pages.fe;//package page_object_model.fe;
//
//import com.shaft.gui.element.TouchActions;
//import com.shaft.validation.Validations;
//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.By;
//import utilities.reader_manager.json_reader.JSONDataManager;
//import utilities.test_base.TestBase;
//
//public class TopicsScreen {
//    private static final By topicsScreen_SkipButton = AppiumBy.accessibilityId("TopicsScreen_Skip_text");
//    private static final By topicsScreen_title_text = AppiumBy.accessibilityId("TopicsScreen_title_text");
//    private static final By topicsScreen_subTitle_text = AppiumBy.accessibilityId("TopicsScreen_subTitle_text");
//    private static final By topicsScreen_Socials = AppiumBy.accessibilityId("Topic_Socials");
//    private static final By topicsScreen_DealingWithDrama = AppiumBy.accessibilityId("Topic_Dealing with Drama");
//    private static final By topicsScreen_StayingZen = AppiumBy.accessibilityId("Topic_Staying Zen");
//    private static final By topicsScreen_BeatBulling = AppiumBy.accessibilityId("Topic_Beat Bulling");
//    private static final By topicsScreen_ShieldUp = AppiumBy.accessibilityId("Topic_Shield Up");
//    private static final By topicsScreen_GoButton = AppiumBy.accessibilityId("Topic_Shield Up");
//    private static final String topicsScreen_TestData_FilePath = ("src/test/resources/test_data/fe/expected/TopicsScreens.json");
//
//    public static void assertThatUserRedirectedToTheTopicsScreen() {
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_title_text).exists().perform();
//    }
//
//    public static void clickSkip() {
//        TouchActions.getInstance().tap(topicsScreen_SkipButton);
////        ElementActions.performTouchAction(TestBase.getDriver()).tap(topicsScreen_SkipButton);
//    }
//
//    public static void clickGo() {
//        TouchActions.getInstance().tap(topicsScreen_GoButton);
////        ElementActions.performTouchAction(TestBase.getDriver()).tap(topicsScreen_GoButton);
//    }
//
//    public static void assertSkipButtonText(String expectedText) {
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_SkipButton).exists().perform();
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_SkipButton).attribute("text").isEqualTo(expectedText).perform();
//    }
//
//    public static void assertGoButtonText(String expectedText) {
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_GoButton).exists().perform();
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_GoButton).attribute("text").isEqualTo(expectedText).perform();
//    }
//
//    public static void assertTopicsScreenContent() {
//        assertExploreHeaderTitleText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "explore_Header_Title", JSONDataManager.Types.STRING).toString());
//        assertExploreHeaderSubTitleText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "explore_Header_Sub_Title", JSONDataManager.Types.STRING).toString());
//        assertSkipButtonText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "skip_Button", JSONDataManager.Types.STRING).toString());
////        assertGoButtonText(JSONDataManager.getJSONData(topicsScreen_TestData_FilePath, "go_Button", JSONDataManager.Types.STRING).toString());
//    }
//
//    public static void assertExploreHeaderTitleText(String expectedText) {
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_title_text).exists().perform();
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_title_text).attribute("text").isEqualTo(expectedText).perform();
//    }
//
//    public static void assertExploreHeaderSubTitleText(String expectedText) {
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_subTitle_text).exists().perform();
//        Validations.assertThat().element(TestBase.getDriver(), topicsScreen_subTitle_text).attribute("text").isEqualTo(expectedText).perform();
//    }
//
//    public static void selectTopicSocials() {
//        TouchActions.getInstance().tap(topicsScreen_Socials);
////        ElementActions.performTouchAction(TestBase.getDriver()).tap(topicsScreen_Socials);
//    }
//
//    public static void selectTopicDealingWithDrama() {
//        TouchActions.getInstance().tap(topicsScreen_DealingWithDrama);
////        ElementActions.performTouchAction(TestBase.getDriver()).tap(topicsScreen_DealingWithDrama);
//    }
//
//    public static void selectTopicStayingZen() {
//        TouchActions.getInstance().tap(topicsScreen_StayingZen);
////        ElementActions.performTouchAction(TestBase.getDriver()).tap(topicsScreen_StayingZen);
//    }
//
//    public static void selectTopicBeatBulling() {
//        TouchActions.getInstance().tap(topicsScreen_BeatBulling);
////        ElementActions.performTouchAction(TestBase.getDriver()).tap(topicsScreen_BeatBulling);
//    }
//
//    public static void selectTopicShieldUp() {
//        TouchActions.getInstance().tap(topicsScreen_ShieldUp);
////        ElementActions.performTouchAction(TestBase.getDriver()).tap(topicsScreen_ShieldUp);
//    }
//}