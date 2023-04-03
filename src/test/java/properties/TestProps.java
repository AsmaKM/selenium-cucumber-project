package properties;

import utils.Utils;

/**
 * Used to get values related to the test execution specifications. For example: browser, default timeout
 * Retrieve values of properties with the following precedence:
 *      1. Command arguments -D<argument>=<value>
 *      2. Defined properties file
 *      3. Default value, if applicable
 *
 *    The values can then be easily accessed by typing: TestProps.<PROPERTY_NAME>
 */

public class TestProps {

    private static final String TEST_PROPERTIES_FILE = "test.properties";
    public static final String BASE_URL = Utils.getMandatoryProperty("baseUrl",TEST_PROPERTIES_FILE);
    public static final String BROWSER = Utils.getPropertyOrDefault("browser",TEST_PROPERTIES_FILE,"chrome");
    public static final int DEFAULT_TIMEOUT = Utils.getPropertyOrDefault("defaultTimeout",TEST_PROPERTIES_FILE,10);
    public static final int EXTENDED_TIMEOUT = Utils.getPropertyOrDefault("extendedTimeout",TEST_PROPERTIES_FILE,60);

}
