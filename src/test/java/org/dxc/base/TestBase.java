package org.dxc.base;

import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.dxc.constants.GlobalConstants;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase extends AbstractTestNGCucumberTests {

    public static WebDriver ldriver;
    GlobalConstants globalConstants;
    String browserMode = null;
    String targetBrowser = null;
    String environment = null;
    public static Scenario lscenario;

    public void initSetup(WebDriver driver, Scenario scenario) throws Exception {
        globalConstants = new GlobalConstants();
        getEnvironmentProperties();
        if (browserMode != null && targetBrowser != null && environment != null) {
            if (targetBrowser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", globalConstants.chromeDriverPath);
                driver = new ChromeDriver(this.getChromeWebDriverOptions(browserMode));
            } else if (targetBrowser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", globalConstants.edgeDriverPath);
                //Headless version is not supported for edge
                driver = new EdgeDriver();
            }
            driver.manage().window().maximize();
            Thread.sleep(1000);
            switch (environment) {
                case "qa":
                    driver.get(globalConstants.appURLQA);
                    break;
                case "prod":
                    driver.get(globalConstants.appURLProd);
                    break;
            }
            Thread.sleep(1000);
            this.ldriver = driver;
            this.lscenario = scenario;
        }
    }

    public WebDriver getDriver() {
        return ldriver;
    }
    public Scenario getScenario() {
        return lscenario;
    }

    private void getEnvironmentProperties()
    {
        if(System.getProperty("mode")!=null || System.getProperty("browser") !=null || System.getProperty("env")!=null)
        {
            System.out.println(System.getProperty("mode"));
            browserMode = System.getProperty("mode");
            targetBrowser = System.getProperty("browser");
            environment = System.getProperty("env");
        }
        else
        {
            browserMode = "headmode";
            targetBrowser = "chrome";
            environment = "qa";
        }

    }

    public void tearDown() throws Exception {
        System.out.println("Scenario Execution Completed Successfully");
        //Closing the WebDriver
        ldriver.close();
        ldriver.quit();
    }

    public String[] getBrowserArguments(String browserMode) {
        String[] browserArguments = null;

        String argumentsString = null;
        switch (browserMode) {
            case "headless":
                argumentsString = globalConstants.HeadlessMode;
                break;

            case "headmode":
                argumentsString = globalConstants.HeadMode;
                break;
        }
        if (argumentsString != null && (argumentsString = argumentsString.trim()).length() > 0) {
            browserArguments = argumentsString.split(";");

            if (browserArguments != null && browserArguments.length == 0) {
                // Return null instead of empty array.
                browserArguments = null;
            }
        }

        argumentsString = null;

        return browserArguments;
    }

    public ChromeOptions getChromeWebDriverOptions(String browserMode) {
        ChromeOptions chromeBrowserOptions = null;
        String[] browserArguments = getBrowserArguments(browserMode);
        chromeBrowserOptions = new ChromeOptions();
        if (browserArguments != null && browserArguments.length > 0) {
            chromeBrowserOptions.addArguments(browserArguments);
        }

        browserArguments = null;

        return chromeBrowserOptions;
    }

    public static byte[] getByteScreenshot() {
        byte[] screenshot = ((TakesScreenshot) ldriver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }

}