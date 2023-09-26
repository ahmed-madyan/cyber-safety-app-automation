package unit_test;

import driver.DriverInitializer;
import logger.Log4JLogger;
import readers.json_reader.JSONDataManager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class UnitTest {
    private static final String TEST_DATA_FILE_PATH = ("src/test/resources/test_data/fe/expected/OnBoardingScreens.json");

    public static void main(String[] args) {
        System.out.println(new Exception().getStackTrace()[0].getMethodName());
        String string = JSONDataManager.getJSONData(TEST_DATA_FILE_PATH, "onBoarding_Card_Title_4", JSONDataManager.Types.STRING).toString().trim();
        Log4JLogger.logINFO(UnitTest.class,string);
//        String date = ("2022-09-09T00:00:00Z");
//        Log4JLogger.logINFO(UnitTest.class,"Year: " + extractYearFromISODate(date) + "\nMonth: " + extractMonthFromISODate(date));
    }

    private static String extractYearFromISODate(String isoExtendedDate) {
        return String.valueOf(LocalDateTime.parse(isoExtendedDate, DateTimeFormatter.ISO_DATE_TIME).getYear());
    }

    private static String extractMonthFromISODate(String isoExtendedDate) {
        return LocalDateTime.parse(isoExtendedDate, DateTimeFormatter.ISO_DATE_TIME).getMonth().name();
    }
}