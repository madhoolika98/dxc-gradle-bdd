package org.dxc.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ContactUsSteps extends StepManager{

    @Given("Navigated to the DXC Homepage")
    public void navigatedToTheDXCHomepage() throws Exception {
        Assert.assertTrue(contactUsPage.validateDXCHomePageIsDisplayed(),"DXC Homepage is not displayed");
    }

    @When("Clicked on the contact us option")
    public void clickedOnTheContactUsOption() throws Exception {
        contactUsPage.navigateToContactUs();
    }

    @Then("The Home Page is redirected to Contact Us Page")
    public void theHomePageIsRedirectedToContactUsPage() throws Exception {
        Assert.assertTrue(contactUsPage.validateContactUsPage(),"DXC Contact Us page is not displayed");
    }

    @And("Added Information regarding a Sales Query")
    public void addedInformationRegardingASalesQuery(DataTable dataTable) throws Exception {
       contactUsPage.addSalesQueryInformation(dataTable);
    }

    @Then("Verify the Submit Button is enabled")
    public void verifyTheSubmitButtonIsEnabled() throws Exception {
        Assert.assertTrue(contactUsPage.verifyTheSubmitButtonEnabled(),"The Submit Button is not enabled");
    }
}
