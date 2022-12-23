package org.dxc.constants;

import java.nio.file.Path;

public class GlobalConstants {

    /**
     * Description: Purpose of this class is to store Global Variables in the Project
     */
    public String chromeDriverPath = Path.of("driver","chrome","chromedriver.exe").toAbsolutePath().toString();
    public String edgeDriverPath = Path.of("driver","edge","msedgedriver.exe").toAbsolutePath().toString();
    public String appURLQA = "https://dxc.com/us/en";
    public String appURLProd = "https://dxc.com/us/en";
    public String homePageTitle = "DXC Technology";
    public String contactUsURL = "https://dxc.com/us/en/contact-us";
    public String insuranceURL = "https://dxc.com/us/en/services/insurance-software-bps";
    public String customerStoriesURL ="https://dxc.com/us/en/insights/customer-stories";
    public String VERIFY_TEXT_EXACTMATCH = "EXACTMATCH";
    public String VERIFY_TEXT_EXACTMATCHIGNORECASE = "EXACTMATCHIGNORECASE";
    public String VERIFY_TEXT_PARTIAL = "PARTIAL";

    // Headless Mode
    public String HeadlessMode = "--lang=en-GB;--headless;--disable-gpu;--window-size=1920,1080;";
    //HeadMode
    public String HeadMode = "--lang=en-GBlp-";

    public long SHORT_TIMEOUT = 2;
    public long MEDIUM_TIMEOUT = 8;
    public long LONG_TIMEOUT = 10;

}
