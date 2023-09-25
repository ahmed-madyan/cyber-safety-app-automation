package exceptions;

import log4j_logger.Log4JLogger;

import java.util.Arrays;

public class Exceptions {
    public static void handle(Exception exception) {
        Log4JLogger.logERROR("Error message: " + exception.getMessage());
        Log4JLogger.logERROR("Error Cause: " + exception.getCause());
        Log4JLogger.logERROR("StackTrace: " + Arrays.toString(exception.getStackTrace()) + "Error Cause: " + exception.getCause());
    }
}