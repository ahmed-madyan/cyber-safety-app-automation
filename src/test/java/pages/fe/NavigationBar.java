package pages.fe;

import assertions.Assertions;
import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NavigationBar {
    private static final By COSMOS_TAB_BUTTON = AppiumBy.accessibilityId("Cosmos_Button");
    private static final By MY_SPACE_TAB_BUTTON = AppiumBy.accessibilityId("MySpace_Button");
    private static final By BURGER_MENU_TAB_BUTTON = AppiumBy.accessibilityId("Drawer_BurgerIcon");
    private static final By SEARCH_TAB_BUTTON = AppiumBy.accessibilityId("Drawer_BurgerIcon");

    public static void openCosmosTab() {
        Elements.elementActions().click(COSMOS_TAB_BUTTON);
    }

    public static void openMySpaceTab() {
        Elements.elementActions().click(MY_SPACE_TAB_BUTTON);
    }

    public static void openBurgerMenuTab() {
        Elements.elementActions().click(BURGER_MENU_TAB_BUTTON);
    }

    public static void openSearchTab() {
        Elements.elementActions().click(SEARCH_TAB_BUTTON);
    }

    public static void assertCosmosButtonExists() {
        Assertions.hardAssert().elementDisplayed(COSMOS_TAB_BUTTON);
    }

    public static void assertMySpaceButtonExists() {
        Assertions.hardAssert().elementDisplayed(MY_SPACE_TAB_BUTTON);
    }

    public static void assertBurgerMenuButtonExists() {
        Assertions.hardAssert().elementDisplayed(BURGER_MENU_TAB_BUTTON);
    }

    public static void assertSearchButtonExists() {
        Assertions.hardAssert().elementDisplayed(SEARCH_TAB_BUTTON);
    }

    public static void assertNavigationBarContent() {
        assertBurgerMenuButtonExists();
        assertCosmosButtonExists();
        assertMySpaceButtonExists();
        assertSearchButtonExists();
    }

    public static void assertCosmosScreenSelected() {
        Assertions.hardAssert().elementSelected(COSMOS_TAB_BUTTON);
    }
}