package com.lambdatest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SliderPage  extends BaseClass{
	public SliderPage(WebDriver driver) {
		super(driver);
	}

	public void moveSliderTo95() {
		// Select the slider "Default value 15" and drag the bar to make it 95
		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
		new Actions(driver).dragAndDropBy(slider, 200, 0).build().perform();
		
	}

}
