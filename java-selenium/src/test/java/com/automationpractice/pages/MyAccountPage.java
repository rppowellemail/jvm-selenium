package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    private WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assert_page_heading() {
        assert(get_page_heading().equals("My Account"));
    }

    public String get_page_heading() {
        String xpath = "//h1[@class='page-heading']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
                )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement.getText();
    }

    public void click_MyAddresses() {
        WebElement webElement = driver.findElement(By.xpath("//a[@title='Addresses']"));
        webElement.click();
    }

}
