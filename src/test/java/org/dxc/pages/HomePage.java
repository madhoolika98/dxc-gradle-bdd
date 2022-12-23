package org.dxc.pages;

import org.dxc.base.TestBase;
import org.dxc.common.Generic;
import org.dxc.constants.GlobalConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase{

    GlobalConstants globalConstants;
    Generic generic;
    public HomePage.HomePageObjects homePageObjects;

    /**
     * Constructor
     * @param
     */
    public HomePage()
    {
        globalConstants = new GlobalConstants();
        generic = new Generic(TestBase.ldriver,TestBase.lscenario);
        homePageObjects = new HomePage.HomePageObjects();
        PageFactory.initElements(getDriver(),homePageObjects);
    }

    /**
     * Description: Method is used to navigate to ContactUs Page from the Home Page
     * @throws Exception
     */
    public void navigateToContactUs() throws Exception {
        generic.waitForMediumTimeOut();
        homePageObjects.contactUsLink.click();
    }
    /*
       ###################################################################################
       ######################                                      #######################
       ######################    Home Page   -  WebElements      #######################
       ######################                                      #######################
       ###################################################################################
   */


    static class HomePageObjects
    {
        @FindBy(xpath = "(//a[@id='contact-us-link']")
        @CacheLookup
        private WebElement contactUsLink;
    }
}
