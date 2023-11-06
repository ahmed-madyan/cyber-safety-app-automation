package driver;

import elements.Elements;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import logger.Log4JLogger;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.*;
import readers.properties_reader.PropertiesConfigurations;
import waits.Waits;

public class DriverInitializer extends AbstractTestNGCucumberTests {
    @Setter
    @Getter
    public static String Platform;

    @BeforeSuite(alwaysRun = true)
    public void generateBuildIdentifier() {
        Log4JLogger.logINFO(getClass(), new Object() {
        }.getClass().getEnclosingMethod().getName());
        BrowserStackBuildIdentifier.generateBuildIdentifierDateTime();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("PlatformName")
    protected void initializeDriver(@Optional("Android") String platformName) {
        Log4JLogger.logINFO(getClass(), new Object() {
        }.getClass().getEnclosingMethod().getName(), "platformName: " + platformName);
        setPlatform(platformName);
        PropertiesConfigurations.setConfigProperties();
        Log4JLogger.logINFO(DriverInitializer.class, new Object() {
        }.getClass().getEnclosingMethod().getName(), "Execution Address: " + PropertiesConfigurations.getExecutionAddress());
        switch (PropertiesConfigurations.getExecutionAddress()) {
            case "local" -> setDriver(DriverLocalServiceInitializer.localServiceInitialization());
            case "remote" -> setDriver(BrowserStackInitializer.browserStackInitialization(platformName));
            default -> {
                Log4JLogger.logWARN(getClass(), new Object() {
                }.getClass().getEnclosingMethod().getName(), "Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
        Log4JLogger.logINFO(getClass(), "Session Id: " + getDriver().getSessionId());
        switch (platformName) {
            case "iOS":
                if (Elements.elementState().isDisplayed(AppiumBy.accessibilityId("Allow"))) {
                    Elements.elementActions().click(AppiumBy.accessibilityId("Allow"));
                }
            case "Android":
                if (Elements.elementState().isDisplayed(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"))) {
                    Elements.elementActions().click(AppiumBy.id("com.android.permissioncontroller:id/permission_allow_button"));
                }
        }
        Waits.fluentlyWait().visibilityOfElementLocated(AppiumBy.accessibilityId("onBoarding_Card_description_0"));
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDownDriver() {
        Log4JLogger.logINFO(DriverInitializer.class, new Object() {
        }.getClass().getEnclosingMethod().getName());
        //Tear the driver instance down
        switch (PropertiesConfigurations.getExecutionAddress()) {
            case "local" -> DriverLocalServiceInitializer.localServiceTermination();
            case "remote" -> BrowserStackInitializer.appiumDriver.get().quit();
            default -> {
                Log4JLogger.logWARN(getClass(), new Object() {
                }.getClass().getEnclosingMethod().getName(), "Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
    }

    protected static AppiumDriver getDriver() {
        return BrowserStackInitializer.appiumDriver.get();
    }

    private static void setDriver(AppiumDriver appiumDriver) {
        BrowserStackInitializer.appiumDriver.set(appiumDriver);
    }
}