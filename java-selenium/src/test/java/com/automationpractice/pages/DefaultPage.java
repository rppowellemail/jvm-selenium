package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DefaultPage {
    private WebDriver driver;

    public DefaultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_menubar_SignIn() {
        WebElement e = driver.findElement(By.className("login"));
        e.click();
    }
}
