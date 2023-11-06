package runners;

import driver.DriverInitializer;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/features/fe"},
                glue = {"steps"},
                tags = ("@OnBoardingScreen"),
                plugin =
                        {
                                "pretty",
                                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                        }
        )


public class TestRunnerFE extends DriverInitializer {
}