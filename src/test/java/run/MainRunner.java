package run;
import io.cucumber.core.cli.Main;

/**
 * Main runner can be used to execute tests from terminal or to create an executable .jar file.
 */
public class MainRunner {
    public static void main(String[] args) {

        String[] cucumberArgs = new String[] {
                "-g","testSteps",
                "classpath:features",
                "-p", "pretty",
                "-p","json:test-reports/test_report.json",
                "-p","html:test-reports/test_report.html",
                "-p","rerun:test-reports/failed_scenarios.txt"
//                ,"-t","@login or @banner"
        };
        Main.run(cucumberArgs);
    }

}
