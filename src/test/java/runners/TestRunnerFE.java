package runners;

import driver.BrowserStackBuildIdentifier;
import driver.DriverInitializer;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/features"},
                glue = {"steps"},
                tags = ("@OnBoardingScreen"),
                plugin = {"pretty",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunnerFE extends DriverInitializer {
//    @BeforeClass(alwaysRun = true)
//    public void generateBuildIdentifier() {
//        BrowserStackBuildIdentifier.generateBuildNumber();
//        BrowserStackBuildIdentifier.generateBuildIdentifierDateTime();
//    }
}