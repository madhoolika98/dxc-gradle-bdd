package org.dxc.stepDefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SwitchControlSteps extends StepManager {

    @When("In Home Page search for Customer")
    public void inHomePageSearchForCustomer() throws InterruptedException {
        switchControlPage.search();
    }
    @When("Add new tab and navigate to Insurance Software and BPS Page")
    public void addNewTabAndNavigateToInsurancePage() {
        switchControlPage.switchToInsuranceTab();
    }

    @And("Verify subscribe now link is displayed")
    public void verifySubscribeNowLinkIsDisplayed() throws InterruptedException {
        switchControlPage.verifySubscribeNowLink();
    }

    @Then("Close the Insurance Software and BPS tab")
    public void closeTheInsuranceSoftwareAndBPSTab() throws InterruptedException {
        switchControlPage.close();
    }

    @When("Add new window and navigate to Customer Stories Page")
    public void addNewWindowAndNavigateToCustomerStoriesPage() throws InterruptedException {
        switchControlPage.switchToCustomerStories();
    }

    @And("Verify American Airlines is displayed")
    public void verifyAmericanAirlinesIsDisplayed() throws InterruptedException {
        switchControlPage.searchAmericanAirlines();
    }

    @Then("Close Customer Stories Window")
    public void closeCustomerStoriesWindow() throws InterruptedException {
        switchControlPage.close();
        switchControlPage.menuInHomePage();
    }

}
