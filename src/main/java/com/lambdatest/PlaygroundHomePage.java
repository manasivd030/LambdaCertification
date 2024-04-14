package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaygroundHomePage extends BaseClass {
	private static final String PAGE_URL = "https://www.lambdatest.com/selenium-playground";

    public PlaygroundHomePage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public void navigateToSimpleFormDemo() {
        driver.findElement(By.linkText("Simple Form Demo")).click();
    }

    public void navigateToSliderPage() {
        driver.findElement(By.linkText("Drag & Drop Sliders")).click();
    }

    public void navigateToInputFormSubmitPage() {
        driver.findElement(By.linkText("Input Form Submit")).click();
    }

}
