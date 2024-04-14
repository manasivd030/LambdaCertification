package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormDemoPage extends BaseClass {
	public SimpleFormDemoPage(WebDriver driver) {
        super(driver);
    }

    public void validateURLContainsSimpleFormDemo() {
        // Validate that the URL contains "simple-form-demo"
        assert driver.getCurrentUrl().contains("simple-form-demo");
    }

    public void enterMessageAndValidate() {
        // Enter message
        WebElement messageInput = driver.findElement(By.id("user-message"));
        messageInput.sendKeys("Welcome to LambdaTest");

        // Click "Get Checked Value"
        WebElement showMessageButton = driver.findElement(By.id("showInput"));
        showMessageButton.click();

        // Validate whether the same text message is displayed
        WebElement messageDisplay = driver.findElement(By.id("message"));
        String displayedMessage = messageDisplay.getText();
        assert displayedMessage.equals("Welcome to LambdaTest");
    }

}
