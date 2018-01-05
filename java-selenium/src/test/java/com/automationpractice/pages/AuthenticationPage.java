package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assert_page_heading() {
        assert(get_page_heading().equals("AUTHENTICATION"));
    }

    public String get_page_heading() {
        String xpath = "//h1[@class='page-heading']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.textToBe(By.xpath(xpath), "AUTHENTICATION")
                )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement.getText();
    }

    public void send_input_EmailCreate(String email) {
        WebElement webElement = driver.findElement(By.id("email_create"));
        webElement.sendKeys(email);
    }

    public void click_button_CreateAnAccount() {
        WebElement webElement = driver.findElement(By.id("SubmitCreate"));
        webElement.click();
    }

    public void send_input_Email(String email) {
        WebElement webElement = driver.findElement(By.id("email"));
        webElement.sendKeys(email);
    }

    public void send_input_Password(String password) {
        WebElement webElement = driver.findElement(By.id("passwd"));
        webElement.sendKeys(password);
    }

    public void click_button_SignIn() {
        WebElement webElement = driver.findElement(By.id("SubmitLogin"));
        webElement.click();
    }
}
