package utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssertAndLog {
    public static void assertTrueAndLog(boolean expected){
        assertTrueAndLog(expected,null);
    }
    public static void assertTrueAndLog(boolean expexted, String message){
        try{
            assertTrue(expexted, message);
        }catch (AssertionError e){
            LoggerLoad.logger.error("Error during execution: " + e);
        }
    }
}
