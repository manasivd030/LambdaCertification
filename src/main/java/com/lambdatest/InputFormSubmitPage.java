package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class InputFormSubmitPage extends BaseClass {
    public InputFormSubmitPage(WebDriver driver) {
        super(driver);
    }


    public void fillFormAndSubmit() {
    	driver.findElement(By.name("name")).sendKeys("John Doe");
        driver.findElement(By.id("inputEmail4")).sendKeys("john.doe@example.com");
        driver.findElement(By.name("password")).sendKeys("password123");
        driver.findElement(By.name("company")).sendKeys("LambdaTest");
        driver.findElement(By.name("website")).sendKeys("https://www.example.com");
        Select drpCountry = new Select(driver.findElement(By.name("country")));
        drpCountry.selectByVisibleText("United States");
        driver.findElement(By.name("city")).sendKeys("New York");
        driver.findElement(By.name("address_line1")).sendKeys("123 Main St");
        driver.findElement(By.name("address_line2")).sendKeys("Apt 101");
        driver.findElement(By.id("inputState")).sendKeys("New York");
        driver.findElement(By.name("zip")).sendKeys("10001");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
    }

    public void validateSuccessMessage() {
    	WebElement wrapperDiv = driver.findElement(By.xpath("/html/body/div[1]/div/section[2]/div/div/div/div/p"));
    	String message = wrapperDiv.getText();
    	String expectedMessage = "Thanks for contacting us, we will get back to you shortly.";
    	Assert.assertEquals(message, expectedMessage);
    }
}
