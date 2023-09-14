package waits;

import driver.DriverManager;
import exceptions.ExceptionHandling;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class FluentWaits {
    private static final FluentWait<WebDriver> WAIT = new FluentWait<WebDriver>(DriverManager.getDriverInstance())
            .withTimeout(Duration.ofSeconds(60))
            .pollingEvery(Duration.ofSeconds(5))
            .ignoring(NoSuchElementException.class);

    public static void presenceOfElementLocated(final By elementLocated) {
        try {
            WAIT.until(ExpectedConditions.presenceOfElementLocated(elementLocated));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void visibilityOfElementLocated(final By elementLocated) {
        try {
            presenceOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.visibilityOfElementLocated(elementLocated));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void elementToBeClickable(final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.elementToBeClickable(elementLocated));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void elementToBeSelected(final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.elementToBeSelected(elementLocated));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void elementToBeUnSelected(final By elementLocated) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, false));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void elementSelectionStateToBe(final By elementLocated, final boolean state) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.elementSelectionStateToBe(elementLocated, state));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void textToBePresentInElementLocated(final By elementLocated, final String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.textToBePresentInElementLocated(elementLocated, expectedText));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void textToBe(final By elementLocated, final String expectedText) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.textToBe(elementLocated, expectedText));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void attributeContains(final By elementLocated, final String attribute, final String value) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.attributeContains(elementLocated, attribute, value));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }

    public static void attributeToBe(final By elementLocated, final String attribute, final String value) {
        try {
            visibilityOfElementLocated(elementLocated);
            WAIT.until(ExpectedConditions.attributeToBe(elementLocated, attribute, value));
        } catch (Exception e) {
            ExceptionHandling.handleException(e);
        }
    }
}