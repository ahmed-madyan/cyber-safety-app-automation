package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/features"},
                glue = {"steps"},
                tags = ("@Get_Profile_Valid_Request"),
                plugin =
                        {
                                "pretty",
                                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
                        }
        )

public class TestRunnerAPI extends AbstractTestNGCucumberTests {
}