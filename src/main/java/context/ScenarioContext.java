package context;

import log4j_logger.Log4JLogger;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final Map<String, Object> scenarioContext = new HashMap<>();

    public static void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
        Log4JLogger.logINFO(ScenarioContext.class, "Context" + key + " :" + value);
    }

    public static Object getContext(Context key) {
        Object value = scenarioContext.get(key.toString());
        Log4JLogger.logINFO(ScenarioContext.class, "Context" + key + " :" + value);
        return value;
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }
}
