package log4j_logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JLogger {
    private static Logger logger = LogManager.getLogger(Log4JLogger.class);

    public static void logFATAL(String s) {
        logger.log(Level.FATAL, s);
    }

    public static void logERROR(String s) {
        logger.log(Level.ERROR, s);
    }

    public static void logWARN(String s) {
        logger.log(Level.WARN, s);
    }

    public static void logINFO(String s) {
        logger.log(Level.INFO, s);
    }

    public static void logDEBUG(String s) {
        logger.log(Level.DEBUG, s);
    }

    public static void logTRACE(String s) {
        logger.log(Level.TRACE, s);
    }

    public static void logALL(String s) {
        logger.log(Level.ALL, s);
    }

    public static void main(String[] args) {
        logINFO("Ahmed");
    }
}