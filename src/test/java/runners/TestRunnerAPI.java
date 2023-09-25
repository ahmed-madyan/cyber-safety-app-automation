package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/features"},
                glue = {"steps"},
                tags = ("@Regression_API"),
                plugin = {"pretty",
                        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        )

public class TestRunnerAPI extends AbstractTestNGCucumberTests {
}