package pages.fe;

import elements.Elements;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class NotificationPopUp {
    private static final By POP_UP_NOTIFICATIONS_ALLOW = AppiumBy.accessibilityId("Allow");
    public static void allowNotifications(){
        Elements.elementActions().click(POP_UP_NOTIFICATIONS_ALLOW);
    }
}