package org.dxc.pages;

import org.dxc.base.TestBase;
import org.dxc.common.Generic;
import org.dxc.constants.GlobalConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SwitchControlPage extends TestBase {

    GlobalConstants globalConstants;
    Generic generic;
    public HomePage homePage;
    public SwitchTabObjects switchTabObjects;
    public String mainWindow ;

    /**
     * Constructor
     * @param
     */
    public SwitchControlPage()
    {
        globalConstants = new GlobalConstants();
        generic = new Generic(TestBase.ldriver,TestBase.lscenario);
        homePage = new HomePage();
        switchTabObjects = new SwitchTabObjects();
        PageFactory.initElements(getDriver(),switchTabObjects);
    }

    public void search() throws InterruptedException {
        switchTabObjects.searchTextBox.sendKeys("Customer");
        generic.waitForMediumTimeOut();

    }
    public void switchToInsuranceTab() {
        mainWindow = ldriver.getWindowHandle();
        ldriver.switchTo().newWindow(WindowType.TAB);
        ldriver.get(globalConstants.insuranceURL);
    }

    public void verifySubscribeNowLink() throws InterruptedException {
        generic.waitForShortTimeOut();
        Assert.assertTrue(switchTabObjects.subscribeNowLink.isDisplayed(),
                "Subscribe Now Link is displayed");
    }

    public void close() throws InterruptedException {
        ldriver.close();
        generic.waitForMediumTimeOut();

    }

    public void switchToCustomerStories() throws InterruptedException {

        ldriver.switchTo().window(mainWindow);
        generic.waitForShortTimeOut();
        ldriver.switchTo().newWindow(WindowType.WINDOW);
        ldriver.get(globalConstants.customerStoriesURL);
    }

    public void searchAmericanAirlines() throws InterruptedException {
        generic.waitForShortTimeOut();
        Assert.assertTrue(switchTabObjects.americanAirlines.isDisplayed(),
                "American Airlines Customer is displayed");
    }

    public void menuInHomePage() throws InterruptedException {
        ldriver.switchTo().window(mainWindow);
        generic.waitForShortTimeOut();
        Assert.assertTrue(switchTabObjects.mainMenu.isDisplayed(),
                "Main Menu is displayed");
    }


    /*
      ###################################################################################
      ######################                                      #######################
      ######################    Career Portal -  WebElements         #######################
      ######################                                      #######################
      ###################################################################################
  */
    static class SwitchTabObjects {

        @FindBy(css = "div[class='header-logo hidden-xs'] section[class='pcs-widget'] div[class='pcs-content-v1-pcs-header-logo-default-default pcs-widget'] div img[alt='Company Logo']")
        @CacheLookup
        private WebElement dxcLogo;

        @FindBy(css = "#search-input")
        @CacheLookup
        private WebElement searchTextBox;

        @FindBy(css ="a[id='cta-52072411a8'] span[class='cmp-button__text']")
        @CacheLookup
        private WebElement subscribeNowLink;

        @FindBy(css = "body > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > main:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > picture:nth-child(1) > img:nth-child(3)")
        @CacheLookup
        private WebElement americanAirlines;

        @FindBy(css = "#mega-menu-wrapper")
        @CacheLookup
        private WebElement mainMenu;
    }
}
