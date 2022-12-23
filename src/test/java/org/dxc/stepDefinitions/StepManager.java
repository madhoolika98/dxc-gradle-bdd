package org.dxc.stepDefinitions;

import org.dxc.pages.*;

public class StepManager extends PageManager{

    PageManager pageManager;
    HomePage homePage;
    ContactUsPage contactUsPage;
    CareerPortalPage careerPortalPage;
    AwardRecognitionPage awardRecognitionPage;
    SwitchControlPage switchControlPage;


    public StepManager() {
        initializePages();
    }


    public void initializePages() {
        pageManager = new PageManager();
        homePage = pageManager.getHomePage();
        contactUsPage = pageManager.getContactUsPage();
        careerPortalPage = pageManager.getCareerPortalPage();
        awardRecognitionPage = pageManager.getAwardRecognitionPage();
        switchControlPage = pageManager.getswitchTabPage();
    }


}
