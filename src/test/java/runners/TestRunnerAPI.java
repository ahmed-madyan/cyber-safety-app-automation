package runners;

import api.base_uris.BaseURI;
import context.Context;
import context.ScenarioContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import log4j_logger.Log4JLogger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions
        (
                publish = true,
                features = {"src/test/java/features"},
                glue = {"steps"},
                tags = ("@Get_Profile"),
                plugin = {"pretty",
                        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
        )

public class TestRunnerAPI extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("testEnvironment")
    public void initializeConfigurations(@Optional("SIT") String testEnvironment) {
        switch (testEnvironment) {
            case "ST" -> {
                ScenarioContext.setContext(Context.TARGET_ENVIRONMENT, testEnvironment);
                ScenarioContext.setContext(Context.TARGET_BASE_URI, BaseURI.ST);
            }
            case "SIT" -> {
                ScenarioContext.setContext(Context.TARGET_ENVIRONMENT, testEnvironment);
                ScenarioContext.setContext(Context.TARGET_BASE_URI, BaseURI.SIT);
            }
            default -> Log4JLogger.logWARN("Kindly select valid test Environment [<!-- ST or SIT -->].");
        }
    }
}