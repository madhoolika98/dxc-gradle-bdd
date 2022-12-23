package org.dxc.runners;

import io.cucumber.testng.CucumberOptions;
import org.dxc.base.TestBase;
import org.testng.annotations.Test;

import static io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE;

@CucumberOptions(

        features = "src\\test\\resources\\features",
        glue = {"org.dxc.stepDefinitions"},
        tags = "@contactUs",
        monochrome = true,
        dryRun = false,
        snippets = CAMELCASE,
        plugin = {
                "pretty",
                "html:build/cucumber-reports/cucumber-report.html",
                "json:build/cucumber-report.json",
                "rerun:build/cucumber-report.txt",
        }
)

@Test
public class TestRunner extends TestBase {
}
