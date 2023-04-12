package testSteps;

import io.cucumber.java.*;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import properties.TestContext;
import utils.LoggerLoad;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class CommonSteps{


    private int currentStepDefIndex = 0; // Required for getStepName.
    TestContext testContext;

    public CommonSteps(TestContext testContext){
        this.testContext = testContext;
    }

    @BeforeAll
    public static void beforeAll(){
        String excDateTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        LoggerLoad.logger.info("--------------------------------");
        LoggerLoad.logger.info(String.format("STARTING EXECUTION: %s",excDateTime));
        LoggerLoad.logger.info("-------------------------------------------------------");
    }

    @Before
    public void before(Scenario scenario){
        LoggerLoad.logger.info("Starting Scenario: " + scenario.getName());

    }

    @After
    public void after(Scenario scenario) {
        LoggerLoad.logger.info("Ending Scenario: "+ scenario.getName());
        testContext.getAppSession().getDriverManager().quitDriver();
    }

    @AfterAll
    public static void afterAll(){
        String execDateTime = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").format(new Date());
        LoggerLoad.logger.info("-------------------------------------------------------");
        LoggerLoad.logger.info(String.format("EXECUTION ENDED: %s",execDateTime));
        LoggerLoad.logger.info("-------------------------------------------------------");
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        String stepName = getStepName(scenario) ; // getStepName(scenario) must be called only once.
        testContext.setTestStep(stepName);        // testStep can be retrieved on any other step by doing testContext.getTestStep()
        LoggerLoad.logger.trace("Test Step: "+ testContext.getTestStep());
    }

    private String getStepName(Scenario scenario){
        // IMPORTANT!!!: This method must be called only once in order to show correct step. Check there is only 1 usage.
        String stepName;
        try{
            Field f = scenario.getClass().getDeclaredField("delegate");
            f.setAccessible(true);
            io.cucumber.core.backend.TestCaseState sc = (io.cucumber.core.backend.TestCaseState) f.get(scenario);
            Field f1 = sc.getClass().getDeclaredField("testCase");
            f1.setAccessible(true);
            TestCase testCase = (TestCase) f1.get(sc);
            List<PickleStepTestStep> testSteps = testCase.getTestSteps().stream().filter(x -> x instanceof PickleStepTestStep).map(x -> (PickleStepTestStep) x).collect(Collectors.toList());
            stepName = testSteps.get(currentStepDefIndex).getStep().getKeyword()
                     + testSteps.get(currentStepDefIndex).getStep().getText();
            currentStepDefIndex += 1;
        }catch (Exception e){
            stepName = null;
        }
        return stepName;
    }
}
