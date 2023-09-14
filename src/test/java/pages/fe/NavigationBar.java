package pages.fe;//package page_object_model.fe;
//
//import com.shaft.gui.element.ElementActions;
//import com.shaft.validation.Validations;
//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.By;
//import utilities.test_base.TestBase;
//
//public class NavigationBar {
//    private static final By cosmosTab_Button = AppiumBy.accessibilityId("Cosmos_Button");
//    private static final By mySpaceTab_Button = AppiumBy.accessibilityId("MySpace_Button");
//    private static final By burgerMenuTab_Button = AppiumBy.accessibilityId("Drawer_BurgerIcon");
//    private static final By searchTab_Button = AppiumBy.accessibilityId("Duplicated!!");
//
//    public static void openCosmosTab() {
//        ElementActions.performTouchAction(TestBase.getDriver()).tap(cosmosTab_Button);
//    }
//
//    public static void openMySpaceTab() {
//        ElementActions.performTouchAction(TestBase.getDriver()).tap(mySpaceTab_Button);
//    }
//
//    public static void openBurgerMenuTab() {
//        ElementActions.performTouchAction(TestBase.getDriver()).tap(burgerMenuTab_Button);
//    }
//
//    public static void openSearchTab() {
//        ElementActions.performTouchAction(TestBase.getDriver()).tap(searchTab_Button);
//    }
//
//    public static void assertCosmosButtonExists() {
//        Validations.assertThat().element(TestBase.getDriver(), cosmosTab_Button).exists().perform();
//    }
//
//    public static void assertMySpaceButtonExists() {
//        Validations.assertThat().element(TestBase.getDriver(), mySpaceTab_Button).exists().perform();
//    }
//
//    public static void assertBurgerMenuButtonExists() {
//        Validations.assertThat().element(TestBase.getDriver(), burgerMenuTab_Button).exists().perform();
//    }
//
//    public static void assertSearchButtonExists() {
//        Validations.assertThat().element(TestBase.getDriver(), searchTab_Button).exists().perform();
//    }
//
//    public static void assertNavigationBarContent() {
//        assertBurgerMenuButtonExists();
//        assertCosmosButtonExists();
//        assertMySpaceButtonExists();
//        assertSearchButtonExists();
//    }
//
//    public static void assertCosmosScreenSelected() {
//        Validations.assertThat().element(TestBase.getDriver(), cosmosTab_Button).isSelected();
//    }
//}