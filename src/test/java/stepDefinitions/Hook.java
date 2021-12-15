package stepDefinitions;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver;
import utils.HELPER;

public class Hook {

    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
        System.out.println("Test setup!");
        Driver.get().manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario) {

        if (scenario.isFailed()) {
            HELPER.getScreenshot(scenario.getName());
        } else {
            System.out.println("Test completed!");
        }
        Driver.close();
    }
}
