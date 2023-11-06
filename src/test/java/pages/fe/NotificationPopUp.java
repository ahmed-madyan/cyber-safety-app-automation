package pages.fe;

import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NotificationPopUp {
    private static final By POP_UP_NOTIFICATIONS_ALLOW_IOS = AppiumBy.accessibilityId("Allow");
    private static final By POP_UP_NOTIFICATIONS_ALLOW_ANDROID = AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button");
    public static void allowNotifications(String platformName) {
        switch (platformName) {
            case "Android":
                Elements.elementActions().click(POP_UP_NOTIFICATIONS_ALLOW_ANDROID);
            case "iOS":
                Elements.elementActions().click(POP_UP_NOTIFICATIONS_ALLOW_IOS);
        }
    }
}