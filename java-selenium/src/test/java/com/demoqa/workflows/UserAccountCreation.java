package com.demoqa.workflows;

import com.demoqa.models.UserAccount;
import com.demoqa.pages.DefaultPage;
import com.demoqa.pages.RegistrationPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

import java.io.File;
import java.io.IOException;

public class UserAccountCreation {

    public static void main(String[] args) {
        UserAccountCreation u = new UserAccountCreation();
        u.doUserAccountCreation();
    }

    public void doUserAccountCreation() {
        String baseUrl = "http://demoqa.com/";
        WebDriver driver = WebDriverFactory.createWebDriver();

        driver.get(baseUrl);

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotFilename = this.getClass().getSimpleName() + "-screenshot.png";
        System.out.println("Saving screenshot '" + screenshotFilename + "'");
        try {
            FileUtils.copyFile(scrFile, new File(screenshotFilename));

        } catch (IOException e) {
            e.printStackTrace();
        }

        UserAccount u = UserAccount.generateUserAccountFromDatestring(UserAccount.generateDateString());

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

        System.out.println("Registration complete for " + u.getUsername());

    }
}
