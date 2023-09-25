package context;

import io.restassured.response.Response;
import log4j_logger.Log4JLogger;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private static final Map<String, Object> scenarioContext = new HashMap<>();

    public static void setContext(Context key, Object value) {
        scenarioContext.put(key.toString(), value);
        if (key.equals(Context.RESPONSE_PAYLOAD)) {
            Response response = (Response) value;
            Log4JLogger.logINFO(ScenarioContext.class, " Set context key " + key + " with value: " + response.getBody().prettyPrint());
        } else {
            Log4JLogger.logINFO(ScenarioContext.class, " Set context key " + key + " with value: " + value.toString());
        }
    }

    public static Object getContext(Context key) {
        Object value = scenarioContext.get(key.toString());
        if (key.equals(Context.RESPONSE_PAYLOAD)) {
            Response response = (Response) value;
            Log4JLogger.logINFO(ScenarioContext.class, "Get context key " + key + " value: " + response.getBody().prettyPrint());
        } else {
            Log4JLogger.logINFO(ScenarioContext.class, "Get context key " + key + " value: " + value.toString());
        }
        return value;
    }

    public Boolean isContains(Context key) {
        return scenarioContext.containsKey(key.toString());
    }
}