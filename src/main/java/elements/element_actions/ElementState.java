package elements.element_actions;

import driver.DriverManager;
import elements.Elements;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import logger.Log4JLogger;
import org.openqa.selenium.By;

public class ElementState {
    public ElementState() {
    }

    public boolean isCheckable(@NotNull final By elementLocated) {
        boolean isCheckable = Elements.elementActions().getAttribute(elementLocated, "checkable").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element checkable: " + isCheckable);
        return isCheckable;
    }

    public boolean isChecked(@NotNull final By elementLocated) {
        boolean isChecked = Elements.elementActions().getAttribute(elementLocated, "checked").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element checked: " + isChecked);
        return isChecked;
    }

    public boolean isClickable(@NotNull final By elementLocated) {
        boolean isClickable = Elements.elementActions().getAttribute(elementLocated, "clickable").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element clickable: " + isClickable);
        return isClickable;
    }

    public boolean isEnabled(@NotNull final By elementLocated) {
        boolean isEnabled = Elements.elementActions().findElement(elementLocated).isEnabled();
        Log4JLogger.logINFO(getClass(), "Is element enabled: " + isEnabled);
        return isEnabled;
    }

    public boolean isFocusable(@NotNull final By elementLocated) {
        boolean isFocusable = Elements.elementActions().findElement(elementLocated).getAttribute("focusable").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element focusable: " + isFocusable);
        return isFocusable;
    }

    public boolean isFocused(@NotNull final By elementLocated) {
        boolean isFocused = Elements.elementActions().findElement(elementLocated).getAttribute("focused").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element focused: " + isFocused);
        return isFocused;
    }

    public boolean isLongClickable(@NotNull final By elementLocated) {
        boolean isLongClickable = Elements.elementActions().findElement(elementLocated).getAttribute("long-clickable").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element long-clickable: " + isLongClickable);
        return isLongClickable;
    }

    public boolean isPassword(@NotNull final By elementLocated) {
        boolean isPassword = Elements.elementActions().findElement(elementLocated).getAttribute("password").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element password: " + isPassword);
        return isPassword;
    }

    public boolean isScrollable(@NotNull final By elementLocated) {
        boolean isScrollable = Elements.elementActions().findElement(elementLocated).getAttribute("scrollable").equals("true");
        Log4JLogger.logINFO(getClass(), "Is element scrollable: " + isScrollable);
        return isScrollable;
    }

    public boolean isSelected(@NotNull final By elementLocated) {
        boolean isSelected = Elements.elementActions().findElement(elementLocated).isSelected();
        Log4JLogger.logINFO(getClass(), "Is element selected: " + isSelected);
        return isSelected;
    }

    public boolean isDisplayed(@NotNull final By elementLocated) {
        boolean isDisplayed = DriverManager.getDriverInstance().findElement(elementLocated).isDisplayed();
        Log4JLogger.logINFO(getClass(), "Is element displayed: " + isDisplayed);
        return isDisplayed;
    }
}