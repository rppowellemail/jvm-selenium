package com.demoqa;

import com.demoqa.pages.DefaultPage;
import com.demoqa.pages.RegistrationPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHandle;

import java.io.File;
import java.io.IOException;

public class UserAccountCreation {
    public static void main(String[] args) {
        String baseUrl = "http://demoqa.com/";
        SeleniumHandle handle = new SeleniumHandle();
        handle.setUp();
        WebDriver driver = handle.driver;

        driver.get(baseUrl);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserAccount u = UserAccount.generateUserAccountFromDatestring("2018-01-04-015");

        DefaultPage defaultPage = new DefaultPage(driver);
        defaultPage.click_Registration();

        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.assert_entry_title();

        registrationPage.send_input_FirstName(u.getFirstname());
        registrationPage.send_input_LastName(u.getLastname());
        registrationPage.set_radioboxes_Hobby(u.getHobbies());
        registrationPage.send_input_Phonenumber(u.getPhonenumber());
        registrationPage.send_input_Username(u.getUsername());
        registrationPage.send_input_Email(u.getEmail());
        registrationPage.send_input_Password(u.getPassword());
        registrationPage.send_input_ConfirmPassword(u.getPassword());
        registrationPage.click_input_Submit();

        registrationPage.assert_registration_completed_message();

        driver.close();
        driver.quit();

    }
}
