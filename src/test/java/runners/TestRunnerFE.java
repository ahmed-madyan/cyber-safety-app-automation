package runners;

import driver.DriverInitializer;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/features"},
                glue = {"steps"},
                tags = ("@Regression_FE"),
                plugin = {"pretty",
                        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class TestRunnerFE extends DriverInitializer {
}