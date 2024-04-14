package com.lambdatest;


import java.net.MalformedURLException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenarios {
	private WebDriver driver;
    private PlaygroundHomePage homePage;
    private SimpleFormDemoPage simpleFormDemoPage;
    private SliderPage sliderPage;
    private InputFormSubmitPage inputFormSubmitPage;
    private ChromeOptions browserOptions;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        driver = new ChromeDriver();
       homePage = new PlaygroundHomePage(driver);
       simpleFormDemoPage = new SimpleFormDemoPage(driver);
       sliderPage = new SliderPage(driver);
       inputFormSubmitPage = new InputFormSubmitPage(driver);
       browserOptions = setupChromeOptions();
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
    
    public ChromeOptions setupChromeOptions() throws MalformedURLException {

    	ChromeOptions browserOptions = new ChromeOptions();
    	browserOptions.setPlatformName("Windows 10");
    	browserOptions.setBrowserVersion("123.0");
    	HashMap<String, Object> ltOptions = new HashMap<String, Object>();
    	ltOptions.put("username", "vaidya.mansi95@gmail.com");
    	ltOptions.put("accessKey", "924134");
    	ltOptions.put("visual", true);
    	ltOptions.put("video", true);
    	ltOptions.put("network", true);
    	ltOptions.put("project", "Untitled");
    	ltOptions.put("tunnel", true);
    	ltOptions.put("selenium_version", "4.0.0");
    	ltOptions.put("w3c", true);
    	browserOptions.setCapability("LT:Options", ltOptions);
    	return browserOptions;
    }

  @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
