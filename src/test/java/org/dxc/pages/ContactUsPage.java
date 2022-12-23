package org.dxc.pages;

import io.cucumber.datatable.DataTable;
import org.dxc.base.TestBase;
import org.dxc.common.Generic;
import org.dxc.constants.GlobalConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage extends TestBase {

    GlobalConstants globalConstants;
    Generic generic;
    public ContactUsPage.ContactUsObjects contactUsObjects;

    /**
     * Constructor
     * @param
     */
    public ContactUsPage()
    {
        globalConstants = new GlobalConstants();
        generic = new Generic(TestBase.ldriver,TestBase.lscenario);
        contactUsObjects = new ContactUsPage.ContactUsObjects();
        PageFactory.initElements(getDriver(),contactUsObjects);
    }

    /**
     * Description: Method is used to validate DXC Home Page is displayed
     * @throws Exception
     */
    public Boolean validateDXCHomePageIsDisplayed() throws Exception
    {
        Boolean isURLValid = false;
        generic.waitForLongTimeOut();
        if(getDriver().getTitle().equalsIgnoreCase(globalConstants.homePageTitle))
        {
            isURLValid =true;
        }
        return isURLValid;
    }

    /**
     * Description: Method is used to navigate to ContactUs Page from the Home Page
     * @throws Exception
     */
    public void navigateToContactUs() throws Exception {
        generic.waitForShortTimeOut();
        generic.getElementByteScreenshot(contactUsObjects.contactUsLink);
        contactUsObjects.contactUsLink.click();
    }

    /**
     * Description: Method is used to validate to ContactUs Page is displayed
     * * @throws Exception
     */
    public Boolean validateContactUsPage() throws Exception {
        Boolean isURLValid = false;
        generic.waitForLongTimeOut();
        if(getDriver().getCurrentUrl().equalsIgnoreCase(globalConstants.contactUsURL))
        {
            isURLValid =true;
        }

        return isURLValid;
    }

    /**
     * Description: Method is used to Add the data given as a sales query
     * * @throws Exception
     * @param dataTable
     */
    public void addSalesQueryInformation(DataTable dataTable) throws Exception
    {
        if(contactUsObjects.cookiesPopUp.isDisplayed())
        {
            contactUsObjects.cookiesPopUp.click();
            generic.waitForShortTimeOut();
        }
        contactUsObjects.salesAndSolutionButton.click();
        generic.waitForMediumTimeOut();
        contactUsObjects.firstNameTextBox.sendKeys(dataTable.asLists().get(1).get(0));
        contactUsObjects.lastNameTextBox.sendKeys(dataTable.asLists().get(1).get(1));
        contactUsObjects.emailTextBox.sendKeys(dataTable.asLists().get(1).get(2));
        contactUsObjects.telephoneTextBox.sendKeys(dataTable.asLists().get(1).get(3));
        contactUsObjects.organizationDropDown.sendKeys(dataTable.asLists().get(1).get(4));
        contactUsObjects.pointOfContactDropDown.sendKeys(dataTable.asLists().get(1).get(5));
        Select dropDown = new Select(contactUsObjects.countryDropDown);
        dropDown.selectByValue(dataTable.asLists().get(1).get(6));
        contactUsObjects.commentTextBox.sendKeys(dataTable.asLists().get(1).get(7));
        generic.getElementByteScreenshot(contactUsObjects.queryContainer);
    }

    /**
     * Description: Verifying the Submit Button is enabled to send a query
     * * @throws Exception
     */
    public Boolean verifyTheSubmitButtonEnabled() throws Exception {
        Boolean isButtonEnabled =false;
        if(contactUsObjects.submitButton.isEnabled())
        {
            isButtonEnabled =true;
        }
        return isButtonEnabled;

    }


    /*
       ###################################################################################
       ######################                                      #######################
       ######################    Contact Us -  WebElements         #######################
       ######################                                      #######################
       ###################################################################################
   */

    class ContactUsObjects {
        public final static String a= "//button[contains(@class,'onetrust-close-btn-handler onetrust-close-btn-ui banner-close-button ot-close-icon')]";
        @FindBy(xpath = a)
        @CacheLookup
        private WebElement cookiesPopUp;

        @FindBy(xpath ="//a[@id='contact-us-link']")
        @CacheLookup
        private WebElement contactUsLink;

        @FindBy(xpath ="//button[@class='cmp-accordion__button'][contains(.,'Sales and Solutions')]")
        @CacheLookup
        private WebElement salesAndSolutionButton;

        @FindBy(xpath ="//input[@id='first_name_sales']")
        @CacheLookup
        private WebElement firstNameTextBox;

        @FindBy(xpath ="//input[@id='last_name_sales']")
        @CacheLookup
        private WebElement lastNameTextBox;

        @FindBy(xpath ="//input[@id='email_sales']")
        @CacheLookup
        private WebElement emailTextBox;

        @FindBy(xpath ="//input[@id='phone_number_sales']")
        @CacheLookup
        private WebElement telephoneTextBox;

        @FindBy(xpath ="//input[@id='organization_sales']")
        @CacheLookup
        private WebElement organizationDropDown;

        @FindBy(xpath ="//select[contains(@id,'country_select_sales')]")
        @CacheLookup
        private WebElement countryDropDown;

        @FindBy(xpath ="//select[@id='Relationships_sales']")
        @CacheLookup
        private WebElement pointOfContactDropDown;

        @FindBy(xpath ="//textarea[@id='comment_sales']")
        @CacheLookup
        private WebElement commentTextBox;

        @FindBy(xpath ="//button[@id='formSubmitSales']")
        @CacheLookup
        private WebElement submitButton;

        @FindBy(xpath ="//div[@class='cmp-accordion__panel cmp-accordion__panel--expanded']")
        @CacheLookup
        private WebElement queryContainer;
    }
}
