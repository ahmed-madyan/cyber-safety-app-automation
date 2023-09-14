package elements.gesture_actions;

import driver.DriverInitializer;
import elements.Elements;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GestureActions {
    public GestureActions() {
    }

    private IOSGestures iosGestures() {
        return new IOSGestures();
    }

    private AndroidGestures androidGestures() {
        return new AndroidGestures();
    }

    public GestureActions swipe(@NotNull final By elementLocated, @NotNull final GestureDirection gestureDirection) {
        switch (DriverInitializer.getPlatform()) {
            case "Android" -> Elements.gestureActions().androidGestures().swipe(elementLocated, gestureDirection);
            case "iOS" -> Elements.gestureActions().iosGestures().swipe(elementLocated, gestureDirection);
        }
        return this;
    }

    public GestureActions swipe(@NotNull final WebElement element, @NotNull final GestureDirection gestureDirection) {
        switch (DriverInitializer.getPlatform()) {
            case "Android" -> Elements.gestureActions().androidGestures().swipe(element, gestureDirection);
            case "iOS" -> Elements.gestureActions().iosGestures().swipe(element, gestureDirection);
        }
        return this;
    }
}