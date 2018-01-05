package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {
    private WebDriver driver;

    public CreateAnAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assert_page_heading() {
        assert(get_page_heading().equals("Create An Account"));
    }

    public String get_page_heading() {
        String xpath = "//h1[@class='page-heading']";
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(
                ExpectedConditions.and(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)),
                        ExpectedConditions.textToBe(By.xpath(xpath), "CREATE AN ACCOUNT")
                )
        );
        WebElement webElement = driver.findElement(By.xpath(xpath));
        return webElement.getText();
    }

    public void select_radio_TitleMr() {
        WebElement webElement = driver.findElement(By.xpath("//div[@class='radio' and @id='uniform-id_gender1']"));
        webElement.click();
    }

    public void select_radio_TitleMrs() {
        WebElement webElement = driver.findElement(By.xpath("//div[@class='radio' and @id='uniform-id_gender2']"));
        webElement.click();
    }

    public void send_input_Firstname(String firstname) {
        WebElement webElement = driver.findElement(By.id("customer_firstname"));
        webElement.sendKeys(firstname);
    }

    public void send_input_Lastname(String lastname) {
        WebElement webElement = driver.findElement(By.id("customer_lastname"));
        webElement.sendKeys(lastname);
    }

    public void send_input_Password(String password) {
        WebElement webElement = driver.findElement(By.id("passwd"));
        webElement.sendKeys(password);
    }

    public void send_input_Address1(String address1) {
        WebElement webElement = driver.findElement(By.id("address1"));
        webElement.sendKeys(address1);
    }

    public void send_input_City(String city) {
        WebElement webElement = driver.findElement(By.id("city"));
        webElement.sendKeys(city);
    }

    public void send_input_Postcode(String postcode) {
        WebElement webElement = driver.findElement(By.id("postcode"));
        webElement.sendKeys(postcode);
    }

    public void send_input_Phonenumber(String phonenumber) {
        WebElement webElement = driver.findElement(By.id("phone"));
        webElement.sendKeys(phonenumber);
    }

    public void select_State(String state) {
        Select dropdown = new Select(driver.findElement(By.id("id_state")));
        dropdown.selectByVisibleText(state);
    }

    public void click_button_Register() {
        WebElement webElement = driver.findElement(By.id("submitAccount"));
        webElement.click();
    }
}
