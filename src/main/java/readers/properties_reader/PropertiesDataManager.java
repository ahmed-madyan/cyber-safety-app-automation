package readers.properties_reader;

import exceptions.Exceptions;
import log4j_logger.Log4JLogger;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Properties;

public class PropertiesDataManager {
    private static final String PROJECT_PATH = System.getProperty("user.dir");
    private static final Properties properties = new Properties();
    private static final String BROWSERSTACK_CAPABILITIES_PATH = ("/src/main/resources/BrowserStackCapabilities.properties");
    private static final String EXECUTION_CAPABILITIES_PATH = ("/src/main/resources/ExecutionPlatformCapabilities.properties");
    private static final String MOBILE_CAPABILITIES_PATH = ("/src/main/resources/MobileCapabilities.properties");

    private static Properties readProperty(String filePathContentRoot) {
        try {
            InputStream fileInputStream = new FileInputStream((PROJECT_PATH + filePathContentRoot));
            properties.load(fileInputStream);
        } catch (Exception e) {
            Log4JLogger.logINFO(e.getMessage() + "\n" + Arrays.toString(e.getStackTrace()) + "\n");
            Exceptions.handle(e);
        }
        return properties;
    }

    public static String getProperty(String key, String filePathContentRoot) {
        Log4JLogger.logINFO("Test data file path: " + PROJECT_PATH + filePathContentRoot);
        Log4JLogger.logINFO("Desired key: " + key);
        return readProperty(filePathContentRoot).getProperty(key).trim();
    }

    public static void setProperty(String key, String value, String filePathContentRoot) {
        try {
            OutputStream fileOutputStream = new FileOutputStream((PROJECT_PATH + filePathContentRoot));
            properties.put(key, value.trim());
            properties.store(fileOutputStream, null);
        } catch (Exception e) {
            Log4JLogger.logINFO(e.getMessage() + "\n" + e.getMessage() + "\n");
            Exceptions.handle(e);
        }
    }

    public static String getProperty(String key, Capability capability) {
        String filePathContentRoot = null;
        switch (capability) {
            case BROWSERSTACK -> filePathContentRoot = BROWSERSTACK_CAPABILITIES_PATH;
            case EXECUTION -> filePathContentRoot = EXECUTION_CAPABILITIES_PATH;
            case MOBILE -> filePathContentRoot = MOBILE_CAPABILITIES_PATH;
        }
        return readProperty(filePathContentRoot).getProperty(key).trim();
    }

    public static void setProperty(String key, String value, Capability capability) {
        String filePathContentRoot = null;
        switch (capability) {
            case BROWSERSTACK -> filePathContentRoot = BROWSERSTACK_CAPABILITIES_PATH;
            case EXECUTION -> filePathContentRoot = EXECUTION_CAPABILITIES_PATH;
            case MOBILE -> filePathContentRoot = MOBILE_CAPABILITIES_PATH;
        }
        try {
            OutputStream fileOutputStream = new FileOutputStream((PROJECT_PATH + filePathContentRoot));
            properties.put(key, value.trim());
            properties.store(fileOutputStream, null);
        } catch (Exception e) {
            Log4JLogger.logINFO(e.getMessage() + "\n" + e.getMessage() + "\n");
            Exceptions.handle(e);
        }
    }

    public static void editProperty(String key, String value, Capability capability) {
        String filePathContentRoot = null;
        switch (capability) {
            case BROWSERSTACK -> filePathContentRoot = BROWSERSTACK_CAPABILITIES_PATH;
            case EXECUTION -> filePathContentRoot = EXECUTION_CAPABILITIES_PATH;
            case MOBILE -> filePathContentRoot = MOBILE_CAPABILITIES_PATH;
        }
        try {
            PropertiesConfiguration conf = new PropertiesConfiguration((PROJECT_PATH + filePathContentRoot));
            conf.setProperty(key, value);
            conf.save();
        } catch (Exception e) {
            Log4JLogger.logINFO(e.getMessage() + "\n" + e.getMessage() + "\n");
            Exceptions.handle(e);
        }
    }

    public enum Capability {
        BROWSERSTACK,
        EXECUTION,
        MOBILE
    }
}