package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MyAddressesPage {
    private WebDriver driver;

    public MyAddressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void assert_page_heading() {
        assert(get_page_heading().equals("My Addresses"));
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

    public void iterate_addresses() {
        WebElement addresses = driver.findElement(By.className("addresses"));
        System.out.println(addresses);
        List<WebElement> addressList = addresses.findElements(By.xpath("//*[contains(concat(' ', normalize-space(@class), ' '), ' address ')]"));
        for (WebElement address : addressList) {
            WebElement x;
            x = address.findElement(By.xpath("//ul/li[2]/span[1]"));
            System.out.println("Firstname:" + x.getText());
            x = address.findElement(By.xpath("//ul/li[2]/span[2]"));
            System.out.println("Lastname:" + x.getText());

            x = address.findElement(By.xpath("//ul/li[3]/span[1]"));
            System.out.println("Company:" + x.getText());

            x = address.findElement(By.xpath("//ul/li[4]/span[1]"));
            System.out.println("Address1:" + x.getText());
            x = address.findElement(By.xpath("//ul/li[4]/span[2]"));
            System.out.println("Address2:" + x.getText());

            x = address.findElement(By.xpath("//ul/li[5]/span[1]"));
            System.out.println("City:" + x.getText());
            x = address.findElement(By.xpath("//ul/li[5]/span[2]"));
            System.out.println("State:" + x.getText());
            x = address.findElement(By.xpath("//ul/li[5]/span[3]"));
            System.out.println("Postcode:" + x.getText());

            x = address.findElement(By.xpath("//ul/li[6]/span[1]"));
            System.out.println("Country:" + x.getText());

            x = address.findElement(By.xpath("//ul/li[7]/span[1]"));
            System.out.println("Phone:" + x.getText());

            x = address.findElement(By.xpath("//ul/li[8]/span[1]"));
            System.out.println("Phonemobile:" + x.getText());
        }
    }
}
