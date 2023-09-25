package elements.mobile_actions;

import com.google.common.collect.ImmutableMap;
import driver.DriverManager;
import elements.Elements;
import elements.element_actions.ElementActions;
import exceptions.Exceptions;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import log4j_logger.Log4JLogger;
import org.openqa.selenium.By;

public class IOSActions {
    public IOSActions() {
    }

    public ElementActions elementActions() {
        return new ElementActions();
    }

    public IOSActions startBundleId(@NotNull final String bundleId) {
        try {
            DriverManager.executeScript("mobile:launchApp", ImmutableMap.of("bundleId", bundleId));
        } catch (Exception e) {
            Exceptions.handle(getClass(), e);
        }
        return this;
    }

    public IOSActions setPicker(@NotNull final By elementLocated, @NotNull final String value) {
        Elements
                .elementActions()
                .sendKeys(elementLocated, value);
        Log4JLogger.logINFO(IOSActions.class,"Picker value changed to be: " + Elements.elementActions().getText(elementLocated));
        return this;
    }

    public IOSActions setSlider(@NotNull final By elementLocated, @NotNull final String value) {
        Elements
                .elementActions()
                .sendKeys(elementLocated, value);
        Log4JLogger.logINFO(IOSActions.class,"Slider value changed to be: " + Elements.elementActions().getAttribute(elementLocated, "value"));
        return this;
    }
}