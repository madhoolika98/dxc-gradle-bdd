package org.dxc.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.dxc.base.TestBase;

public class Hook extends TestBase {

    public static String scenarioName;
    WebDriver driver;
    public Scenario lscenario;

    @Before
    public void before(Scenario scenario) throws Exception {
        scenarioName = scenario.getName();
        initSetup(driver, scenario);
        driver = getDriver();
        this.lscenario = scenario;
    }

    @After
    public void after(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            System.out.println("driver::"+driver);
            try {
                scenario.attach(getByteScreenshot(), "image/png", scenario.getName() + " is failed , Please check log output for more details");
            } catch (Exception e) {
                e.getMessage();
            }
        }
        tearDown();
    }

//    @AfterStep
//    public void afterStep(Scenario scenario) throws Exception
//    {
//        scenario.attach(getByteScreenshot(), "image/png", "screenshot");
//    }
}
