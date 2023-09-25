package elements.gesture_actions;

import com.google.common.collect.ImmutableMap;
import driver.DriverManager;
import elements.Elements;
import elements.element_actions.ElementActions;
import elements.element_actions.ElementState;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import waits.Waits;

import java.util.Map;
import java.util.Objects;

public class AndroidGestures {
    public AndroidGestures() {
    }

    public ElementActions elementActions() {
        return new ElementActions();
    }

    public ElementState elementState() {
        return new ElementState();
    }

    protected AndroidGestures longClick(@NotNull final By elementLocated, @NotNull final int durationOfSeconds) {
        Waits.fluentlyWait().elementToBeClickable(elementLocated);
        try {
            DriverManager.executeScript("mobile: longClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) Elements.elementActions().findElement(elementLocated)).getId(),
                    "duration", (durationOfSeconds * 1000)
            ));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    protected AndroidGestures doubleClick(@NotNull final By elementLocated) {
        Waits.fluentlyWait().elementToBeClickable(elementLocated);
        try {
            DriverManager.executeScript("mobile: doubleClickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) Elements.elementActions().findElement(elementLocated)).getId()
            ));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    protected AndroidGestures click(@NotNull final By elementLocated) {
        Waits.fluentlyWait().elementToBeClickable(elementLocated);
        try {
            DriverManager.executeScript("mobile: clickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) Elements.elementActions().findElement(elementLocated)).getId()
            ));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    protected AndroidGestures click(@NotNull final WebElement element) {
        try {
            DriverManager.executeScript("mobile: clickGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId()
            ));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }


    protected AndroidGestures swipe(@NotNull final By elementLocated, @NotNull final GestureDirection gestureDirection) {
        try {
            do {
                ((JavascriptExecutor) Objects.requireNonNull(DriverManager.getDriverInstance())).
                        executeScript("mobile: swipeGesture", Map.of(
                                "elementId", ((RemoteWebElement) Objects.requireNonNull(DriverManager.getDriverInstance()).findElement(elementLocated)).getId(),
                                "direction", gestureDirection.toString().toLowerCase(),
                                "percent", 1.0
                        ));
            } while (Elements.elementState().isDisplayed(elementLocated));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    protected AndroidGestures swipe(@NotNull final WebElement element, @NotNull final GestureDirection gestureDirection) {
        try {



            DriverManager.executeScript("mobile: swipeGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", gestureDirection.toString().toLowerCase(),
                    "percent", 1.0
            ));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    protected AndroidGestures scrollToElement(@NotNull final By elementLocated, @NotNull final GestureDirection gestureDirection) {
        boolean canScrollMore = false;
        try {
            DriverManager.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) Elements.elementActions().findElement(elementLocated)).getId(),
                    "direction", gestureDirection.toString().toLowerCase(),
                    "percent", 3.0
            ));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    protected AndroidGestures scrollWithCoordinates(@NotNull final GestureDirection gestureDirection) {
        try {
            DriverManager.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", gestureDirection.toString().toLowerCase(),
                    "percent", 3.0
            ));
        } catch (
                Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    protected AndroidGestures drag(@NotNull final By elementLocated, @NotNull final int xEndCoordinate, @NotNull final int yEndCoordinate) {
        Waits.fluentlyWait().elementToBeClickable(elementLocated);
        try {
            DriverManager.executeScript("mobile: dragGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) Elements.elementActions().findElement(elementLocated)).getId(),
                    "endX", xEndCoordinate,
                    "endY", yEndCoordinate
            ));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }
}