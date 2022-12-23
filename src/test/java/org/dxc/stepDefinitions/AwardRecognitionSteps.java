package org.dxc.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AwardRecognitionSteps extends StepManager{

    @When("Navigated to Awards and Recognition Page")
    public void navigatedToAwardsAndRecognitionPage() throws InterruptedException {
        awardRecognitionPage.navigateToAwardsLink();
    }

    @Then("Search for the award {string}")
    public void searchForTheAward(String arg) throws Exception {
        awardRecognitionPage.searchForAward(arg);
    }
}
