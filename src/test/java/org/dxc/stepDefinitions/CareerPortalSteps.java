package org.dxc.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class CareerPortalSteps extends StepManager{


    @When("Clicked on the careers option")
    public void clickedOnTheCareersOption() throws Exception {
        careerPortalPage.getCareerPortalLink();
        Assert.assertTrue(careerPortalPage.checkSearchButton());

    }

    @And("Search for {string} Role")
    public void searchForTheRole(String arg) throws Exception {
        careerPortalPage.searchKeyword(arg);
    }

    @Then("Verify Job Alert Button is displayed")
    public void verifyJobAlertButtonIsDisplayed() throws Exception {
        careerPortalPage.verifyJobAlertButtonDisplay();
    }
}
