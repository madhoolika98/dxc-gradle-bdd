package org.dxc.pages;

import org.dxc.base.TestBase;
import org.dxc.common.Generic;
import org.dxc.constants.GlobalConstants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.Duration;

public class AwardRecognitionPage extends TestBase {

    GlobalConstants globalConstants;
    Generic generic;
    public HomePage homePage;
    public AwardRecognitionObjects awardRecognitionObjects;

    /**
     * Constructor
     * @param
     */
    public AwardRecognitionPage()
    {
        globalConstants = new GlobalConstants();
        generic = new Generic(TestBase.ldriver,TestBase.lscenario);
        homePage = new HomePage();
        awardRecognitionObjects = new AwardRecognitionObjects();
        PageFactory.initElements(getDriver(),awardRecognitionObjects);
    }


    public void navigateToAwardsLink() throws InterruptedException {
        awardRecognitionObjects.aboutUsLink.click();
        generic.waitForMediumTimeOut();
        WebDriverWait wt = new WebDriverWait(ldriver, Duration.ofSeconds(30));
        wt.until(ExpectedConditions.visibilityOf(awardRecognitionObjects.subLinksOfAboutUs));

        awardRecognitionObjects.awardRecognitionLink.click();
        wt.until(ExpectedConditions.visibilityOf(awardRecognitionObjects.breadCrumbsOfAwardPage));
        generic.waitForMediumTimeOut();
    }

    public void searchForAward(String awardDescription)throws Exception{

        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollBy(0,600)");

        awardRecognitionObjects.recognitionsFromPartner.click();
        generic.waitForMediumTimeOut();
        Assert.assertTrue(awardRecognitionObjects.recognitionsFromPartner.getText().contains("More recognition from our partners"),
                "'More recognition from our partners' Link is displayed");

        if(awardDescription.contains("Inner")){
            js.executeScript("window.scrollBy(0,1000)");
            generic.waitForMediumTimeOut();
            awardRecognitionObjects.award1Text.click();
            Assert.assertEquals(awardRecognitionObjects.award1Text.getText(),
                awardDescription,"Award Description are similar");
        }

        else {
            js.executeScript("window.scrollBy(0,600)");
            generic.waitForMediumTimeOut();
            awardRecognitionObjects.award2Text.click();
            Assert.assertEquals(awardRecognitionObjects.award2Text.getText(),
                    awardDescription, "Award Description are similar");
        }

    }


    /*
    ###################################################################################
    ######################                                      #######################
    ###################    AwardRecognition -  WebElements         ####################
    ######################                                      #######################
    ###################################################################################
*/
    static class AwardRecognitionObjects {

        @FindBy(xpath ="//a[contains(text(),'About Us')]")
        @CacheLookup
        private WebElement aboutUsLink;

        @FindBy(xpath = "//div[@id='about-us-menu']//div[@class='mega-menu__items']")
        @CacheLookup
        private WebElement subLinksOfAboutUs;

        @FindBy(xpath = "//a[normalize-space()='Awards and Recognition']")
        @CacheLookup
        private WebElement awardRecognitionLink;

        @FindBy(xpath = "//div[@class='breadcrumb']")
        @CacheLookup
        private WebElement breadCrumbsOfAwardPage;

        @FindBy(css = "#accordion-46d804d789-item-f5165cd15b-button")
        @CacheLookup
        private WebElement recognitionsFromPartner;

        @FindBy(xpath = "//td[contains(.,'2021 Business Applications Inner Circle')]")
        @CacheLookup
        private WebElement award1Text;

        @FindBy(xpath = "//td[contains(.,'Excellence in New Business Development, APJ')]")
        @CacheLookup
        private WebElement award2Text;

    }
}
