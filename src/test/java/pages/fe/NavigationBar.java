package pages.fe;

import assertions.Assertions;
import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NavigationBar {
    private static final By cosmosTab_Button = AppiumBy.accessibilityId("Cosmos_Button");
    private static final By mySpaceTab_Button = AppiumBy.accessibilityId("MySpace_Button");
    private static final By burgerMenuTab_Button = AppiumBy.accessibilityId("Drawer_BurgerIcon");
    private static final By searchTab_Button = AppiumBy.accessibilityId("Duplicated!!");

    public static void openCosmosTab() {
        Elements.elementActions().click(cosmosTab_Button);
    }

    public static void openMySpaceTab() {
        Elements.elementActions().click(mySpaceTab_Button);
    }

    public static void openBurgerMenuTab() {
        Elements.elementActions().click(burgerMenuTab_Button);
    }

    public static void openSearchTab() {
        Elements.elementActions().click(searchTab_Button);
    }

    public static void assertCosmosButtonExists() {
        Assertions.hardAssert().elementDisplayed(cosmosTab_Button);
    }

    public static void assertMySpaceButtonExists() {
        Assertions.hardAssert().elementDisplayed(mySpaceTab_Button);
    }

    public static void assertBurgerMenuButtonExists() {
        Assertions.hardAssert().elementDisplayed(burgerMenuTab_Button);
    }

    public static void assertSearchButtonExists() {
        Assertions.hardAssert().elementDisplayed(searchTab_Button);
    }

    public static void assertNavigationBarContent() {
        assertBurgerMenuButtonExists();
        assertCosmosButtonExists();
        assertMySpaceButtonExists();
        assertSearchButtonExists();
    }

    public static void assertCosmosScreenSelected() {
        Assertions.hardAssert().elementSelected(cosmosTab_Button);
    }
}