package assertions;

import elements.Elements;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import logger.Log4JLogger;
import org.openqa.selenium.By;
import org.testng.asserts.Assertion;

public class Assert {
    public Assert() {
    }

    public Assert elementCheckable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isCheckable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checkable");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is checkable");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementChecked(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isChecked(elementLocated), "Element located with {" + elementLocated.toString() + "} is not checked");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is checked");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementClickable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not clickable");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is clickable");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementEnabled(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isEnabled(elementLocated), "Element located with {" + elementLocated.toString() + "} is not enabled");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is enabled");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementFocusable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isFocusable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focusable");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is focusable");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementFocused(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isFocused(elementLocated), "Element located with {" + elementLocated.toString() + "} is not focused");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is focused");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementLongClickable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isLongClickable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not long-clickable");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is long-clickable");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementPassword(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isPassword(elementLocated), "Element located with {" + elementLocated.toString() + "} is not password");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is password");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementScrollable(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isScrollable(elementLocated), "Element located with {" + elementLocated.toString() + "} is not scrollable");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is scrollable");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementSelected(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isSelected(elementLocated), "Element located with {" + elementLocated.toString() + "} is not selected");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is selected");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementDisplayed(@NotNull final By elementLocated) {
        try {
            new Assertion().assertTrue(Elements.elementState().isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is not displayed");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementNotDisplayed(@NotNull final By elementLocated) {
        try {
            new Assertion().assertFalse(Elements.elementState().isDisplayed(elementLocated), "Element located with {" + elementLocated.toString() + "} is displayed");
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element located with {" + elementLocated + "} is displayed");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementTextToBe(@NotNull final By elementLocated, final String expectedText) {
        try {
            new Assertion().assertEquals(Elements.elementActions().getText(elementLocated).trim(), expectedText.trim());
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element text {" + Elements.elementActions().getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} is equals to the expected text {" + expectedText.trim() + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementTextContains(@NotNull final By elementLocated, final String expectedText) {
        try {
            new Assertion().assertTrue(Elements.elementActions().getText(elementLocated).trim().contains(expectedText.trim()));
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Element text {" + Elements.elementActions().getText(elementLocated).trim() + "} located with {" + elementLocated.toString() + "} contains the expected text {" + expectedText.trim() + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }
    public Assert textToBe(@NotNull final String actualText, @NotNull final String expectedText) {
        try {
            new Assertion().assertEquals(actualText, expectedText);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Actual text {" + actualText + "} is equals to the expected text {" + expectedText + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert attributeToBe(@NotNull final String attribute, @NotNull final boolean expected) {
        try {
            new Assertion().assertEquals(attribute, expected);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert attributeToBe(@NotNull final String attribute, @NotNull final String expected) {
        try {
            new Assertion().assertEquals(attribute, expected);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementAttributeToBe(@NotNull final By elementLocated, @NotNull final String attribute, @NotNull final boolean expected) {
        try {
            new Assertion().assertEquals(Elements.elementActions().getAttribute(elementLocated, attribute), expected);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Attribute {" + attribute + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert elementAttributeToBe(@NotNull final By elementLocated, @NotNull final String attribute, @NotNull final String value) {
        try {
            new Assertion().assertEquals(Elements.elementActions().getAttribute(elementLocated, attribute).trim(), value.trim());
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Attribute {" + attribute + "} is equals to the expected {" + value + "}");
        } catch (Exception e) {
           Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert objectEquals(@NotNull final Object actual, @NotNull final Object expected) {
        try {
            new Assertion().assertEquals(actual, expected);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Actual {" + actual + "} is equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert objectNotEquals(@NotNull final Object actual, @NotNull final Object expected) {
        try {
            new Assertion().assertNotEquals(actual, expected);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Actual {" + actual + "} not equals to the expected {" + expected + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert assertTrue(@NotNull final boolean condition) {
        try {
            new Assertion().assertTrue(condition);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Actual condition is: {" + condition + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public Assert assertFalse(@NotNull final boolean condition) {
        try {
            new Assertion().assertFalse(condition);
            Log4JLogger.logINFO(Assert.class, Thread.currentThread().getName(), "Actual condition is: {" + condition + "}");
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }
}