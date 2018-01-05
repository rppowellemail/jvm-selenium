package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;

public class RegistrationPage {
    private WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assert_entry_title() {
        String xpath = "//h1[@class='entry-title']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
            ExpectedConditions.and(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                    ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
            )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        assert(webElement.getText() == "Registration");
    }

    public void send_input_FirstName(String firstname) {
        WebElement webElement = driver.findElement(By.id("name_3_firstname"));
        webElement.sendKeys(firstname);
    }

    public void send_input_LastName(String lastname) {
        WebElement webElement = driver.findElement(By.id("name_3_lastname"));
        webElement.sendKeys(lastname);
    }


    public void set_radioboxes_Hobby(String[] hobbies) {
        WebElement hobbies_container = driver.findElement(By.xpath("//div[@class='radio_wrap']"));

        List<WebElement> checkboxes = hobbies_container.findElements(By.xpath("//input[@type='checkbox']"));

        HashMap<String, WebElement> checkboxhash = new HashMap<>();
        for (WebElement checkbox : checkboxes) {
            String k = checkbox.getAttribute("value");
            // System.out.println("Found Hobby checkbox: "+k);
            checkboxhash.put(k, checkbox);
        }

        for (String hobby : hobbies) {
            WebElement checkbox = checkboxhash.get(hobby);
            if (checkbox!=null && !checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public void send_input_Phonenumber(String phonenumber) {
        WebElement webElement = driver.findElement(By.id("phone_9"));
        webElement.sendKeys(phonenumber);
    }

    public void send_input_Username(String username) {
        WebElement webElement = driver.findElement(By.id("username"));
        webElement.sendKeys(username);
    }

    public void send_input_Email(String email) {
        WebElement webElement = driver.findElement(By.id("email_1"));
        webElement.sendKeys(email);
    }

    public void send_input_Password(String password) {
        WebElement webElement = driver.findElement(By.id("password_2"));
        webElement.sendKeys(password);
    }

    public void send_input_ConfirmPassword(String password) {
        WebElement webElement = driver.findElement(By.id("confirm_password_password_2"));
        webElement.sendKeys(password);
    }

    public void click_input_Submit() {
        WebElement webElement = driver.findElement(By.xpath("//input[@type='submit' and @name='pie_submit']"));
        webElement.click();
    }

    public void assert_registration_completed_message() {
        String xpath = "//p[@class='piereg_message']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))
                )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        assert(webElement.getText() == "Thank you for your registration");
    }
}
