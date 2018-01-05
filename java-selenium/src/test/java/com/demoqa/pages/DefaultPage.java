package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultPage {
    private WebDriver driver;

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_Registration() {
        WebElement webElement = driver.findElement(By.xpath("//a[text()='Registration']"));
        webElement.click();
    }
}
