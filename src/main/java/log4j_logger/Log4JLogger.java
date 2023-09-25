package log4j_logger;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4JLogger {
    private static ThreadLocal<Logger> logger = new ThreadLocal<>();

    public static void logFATAL(Class<?> c, String s) {
        logger.get().log(Level.FATAL, s);
    }

    public static void logERROR(Class<?> c, String s) {
        logger.set(LogManager.getLogger(c));
        logger.get().log(Level.ERROR, s);
    }

    public static void logWARN(Class<?> c, String s) {
        logger.set(LogManager.getLogger(c));
        logger.get().log(Level.WARN, s);
    }

    public static void logINFO(Class<?> c, String s) {
        logger.set(LogManager.getLogger(c));
        logger.get().log(Level.INFO, s);
    }

    public static void logINFO(Class<?> c, String s, Object object) {
        logger.set(LogManager.getLogger(c));
        logger.get().log(Level.INFO, s, object);
    }

    public static void logDEBUG(Class<?> c, String s) {
        logger.set(LogManager.getLogger(c));
        logger.get().log(Level.DEBUG, s);
    }

    public static void logTRACE(Class<?> c, String s) {
        logger.set(LogManager.getLogger(c));
        logger.get().log(Level.TRACE, s);
    }

    public static void logALL(Class<?> c, String s) {
        logger.set(LogManager.getLogger(c));
        logger.get().log(Level.ALL, s);
    }

    public static void main(String[] args) {
        logINFO(Log4JLogger.class, "Ahmed");
    }
}