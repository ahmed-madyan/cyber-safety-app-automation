package pages.fe;

import assertions.Assertions;
import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;
import readers.json_reader.JSONDataManager;

public class TermAndConditionsPopUp {
    private static final By POP_UP_HEADER = AppiumBy.accessibilityId("Before_Start_Title_component");
    private static final By POP_UP_CLOSE_BUTTON = AppiumBy.accessibilityId("Before_Start_Card_Close_component");
    private static final By POP_UP_SKIP_BUTTON = AppiumBy.accessibilityId("skip_button");
    private static final By POP_UP_DIALOG_1 = AppiumBy.accessibilityId("Before_Start_Dialog1_component");
    private static final By POP_UP_DIALOG_2 = AppiumBy.accessibilityId("Before_Start_Dialog2_component");
    private static final By POP_UP_DIALOG_TC = AppiumBy.accessibilityId("Before_Start_Dialog_TC_component");
    private static final String TEST_DATA_FILE_PATH = ("src/test/resources/test_data/fe/expected/TermsAndConditions.json");
    private static final JSONObject TEST_DATA = JSONDataManager.parseJSON(TEST_DATA_FILE_PATH);

    public static void validateUserRedirectedToTermsAndConditionsPopUp() {
        Assertions.hardAssert().elementDisplayed(POP_UP_HEADER);
        Assertions.hardAssert().elementDisplayed(POP_UP_CLOSE_BUTTON);
        Assertions.hardAssert().elementDisplayed(POP_UP_SKIP_BUTTON);
        Assertions.hardAssert().elementDisplayed(POP_UP_DIALOG_1);
        Assertions.hardAssert().elementDisplayed(POP_UP_DIALOG_2);
        Assertions.hardAssert().elementDisplayed(POP_UP_DIALOG_TC);
    }

    public static void closePopUp() {
        Elements.elementActions().click(POP_UP_CLOSE_BUTTON);
    }

    public static void skipPopUp() {
        Elements.elementActions().click(POP_UP_SKIP_BUTTON);
    }

    public static void validateSkipButtonText() {
        Assertions.hardAssert().elementTextToBe(POP_UP_SKIP_BUTTON, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "popUp_SkipButton", JSONDataManager.Types.STRING).toString());
    }

    public static void validatePopUpHeaderText() {
        Assertions.hardAssert().elementTextToBe(POP_UP_HEADER, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "popUp_Header", JSONDataManager.Types.STRING).toString());
    }

    public static void validatePopUpDialoge() {
        Assertions.hardAssert().elementTextToBe(POP_UP_DIALOG_1, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "popUp_Dialog_1", JSONDataManager.Types.STRING).toString());
        Assertions.hardAssert().elementTextToBe(POP_UP_DIALOG_TC, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "popUp_Dialog_TC", JSONDataManager.Types.STRING).toString());
//        Assertions.hardAssert().elementTextToBe(POP_UP_DIALOG_2, JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "popUp_Dialog_2", JSONDataManager.Types.STRING).toString());
    }
}