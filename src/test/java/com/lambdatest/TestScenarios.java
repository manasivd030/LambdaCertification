package com.lambdatest;


import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestScenarios {
    private WebDriver driver;
    private PlaygroundHomePage homePage;
    private SimpleFormDemoPage simpleFormDemoPage;
    private SliderPage sliderPage;
    private InputFormSubmitPage inputFormSubmitPage;

    @Parameters(value = {"browser", "version"})
    @BeforeTest
    public void setUp(String browser, String version) throws Exception {

        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new EdgeDriver();
        }


        DesiredCapabilities capabilities = new DesiredCapabilities();

        // set desired capabilities to launch appropriate browser on Lambdatest
        capabilities.setCapability(CapabilityType.BROWSER_NAME, browser);
        capabilities.setCapability(CapabilityType.BROWSER_VERSION, version);
        capabilities.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN11);
        capabilities.setCapability("build", "TestNG Parallel");
        capabilities.setCapability("build", "buildName");
        capabilities.setCapability("name", "TestNG Parallel");
        capabilities.setCapability("network", true);
        capabilities.setCapability("video", true);
        capabilities.setCapability("console", true);
        capabilities.setCapability("visual", true);
        System.out.println("capabilities" + capabilities);

        homePage = new PlaygroundHomePage(driver);
        simpleFormDemoPage = new SimpleFormDemoPage(driver);
        sliderPage = new SliderPage(driver);
        inputFormSubmitPage = new InputFormSubmitPage(driver);

    }

    @Test(priority = 1)
    public void testScenario1() {
        homePage.openPage();
        homePage.navigateToSimpleFormDemo();
        simpleFormDemoPage.validateURLContainsSimpleFormDemo();
        simpleFormDemoPage.enterMessageAndValidate();
    }

    @Test(priority = 2)
    public void testScenario2() {
        homePage.openPage();
        homePage.navigateToSliderPage();
        sliderPage.moveSliderTo95();
    }

    @Test(priority = 3)
    public void testScenario3() {
        homePage.openPage();
        homePage.navigateToInputFormSubmitPage();
        inputFormSubmitPage.fillFormAndSubmit();
        inputFormSubmitPage.validateSuccessMessage();
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }

}
