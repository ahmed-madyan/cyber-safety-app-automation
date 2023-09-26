package driver;

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
        BrowserStackBuildIdentifier.generateBuildIdentifierDateTime();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters("PlatformName")
    protected void initializeDriver(@Optional("Android") String platformName) {
        setPlatform(platformName);
        PropertiesConfigurations.setConfigProperties();
        Log4JLogger.logINFO(DriverInitializer.class, "Execution Address: " + PropertiesConfigurations.getExecutionAddress());
        switch (PropertiesConfigurations.getExecutionAddress()) {
            case "local" -> setDriver(DriverLocalServiceInitializer.localServiceInitialization());
            case "remote" -> setDriver(BrowserStackInitializer.browserStackInitialization(platformName));
            default -> {
                Log4JLogger.logWARN(getClass(), "Kindly set the execution platform address.");
                throw new RuntimeException();
            }
        }
        Log4JLogger.logINFO(DriverInitializer.class, "Session Id: " + getDriver().getSessionId());
        Waits.fluentlyWait().visibilityOfElementLocated(AppiumBy.accessibilityId("onBoarding_Card_description_0"));
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDownDriver() {
        //Tear the driver instance down
        switch (PropertiesConfigurations.getExecutionAddress()) {
            case "local" -> DriverLocalServiceInitializer.localServiceTermination();
            case "remote" -> BrowserStackInitializer.appiumDriver.get().quit();
            default -> {
                Log4JLogger.logWARN(getClass(), "Kindly set the execution platform address.");
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