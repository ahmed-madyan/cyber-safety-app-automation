package driver;

import log4j_logger.Log4JLogger;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import readers.properties_reader.PropertiesDataManager;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Arrays;

public class BrowserStackBuildIdentifier {
    @Setter
    @Getter
    public static int buildNumber;
    @Setter
    @Getter
    public static String dateTime;
    static ChromeOptions chromeOptions = new ChromeOptions();
    static WebDriver driver;
    static FluentWait<WebDriver> driverWait;
    public static void generateBuildIdentifierDateTime() {
        setDateTime((new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Timestamp(System.currentTimeMillis()))));
        Log4JLogger.logINFO("Date Time: " + getDateTime());

    }

    public static void generateBuildNumber() {
        chromeOptions.addArguments("--headless=new");
        driver = new ChromeDriver(chromeOptions);
        driverWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        driver.get(BrowserStack.SIGN_IN_URL.getData());

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email_login")));
        driver.findElement(By.id("user_email_login")).sendKeys(BrowserStack.USERNAME.getData());

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_password")));
        driver.findElement(By.id("user_password")).sendKeys(BrowserStack.PASSWORD.getData());

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_submit")));
        driver.findElement(By.id("user_submit")).click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("builds-sidebar-button")));
        driver.findElement(By.className("builds-sidebar-button")).click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='sidebar-filters__head-text']")));
        driver.findElement(By.xpath("//span[@class='sidebar-filters__head-text']")).click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("project-search")));
        driver.findElement(By.id("project-search")).sendKeys(PropertiesDataManager.getProperty("projectName", PropertiesDataManager.Capability.BROWSERSTACK));

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='list__item']")));
        driver.findElement(By.xpath("//div[@class='list__item']")).click();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("build__content")));
        String firstBuild;
        if (driver.findElements(By.className("build__content")).size() > 1) {
            firstBuild = driver.findElements(By.className("build__content")).get(0).getText();
        } else {
            firstBuild = driver.findElement(By.className("build__content")).getText();
        }
        String[] code = StringUtils.substringsBetween(firstBuild, "No.", "at");
        String previousBuildNumber = Arrays.toString(code).replaceAll("[\\[\\]]", "");
        Log4JLogger.logINFO("previousBuildNumber" + previousBuildNumber);
        int buildInt = 0;
        if (previousBuildNumber.isBlank() || previousBuildNumber.isEmpty() || previousBuildNumber.contains("null")) {
            setBuildNumber(1);
        } else {
            buildInt = Integer.parseInt(previousBuildNumber.trim());
            setBuildNumber(buildInt + 1);
        }
        driver.quit();
        Log4JLogger.logINFO("Build Number: " + getBuildNumber());
    }
}