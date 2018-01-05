package com.automationpractice.workflows;

import com.automationpractice.models.UserAccount;
import com.automationpractice.pages.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHandle;

import java.io.File;
import java.io.IOException;

public class UserAccountLogin {

    public static void main(String[] args) {
        UserAccountLogin u = new UserAccountLogin();
        u.doUserAccountLogin();
    }

    public void doUserAccountLogin() {

        String baseUrl = "http://automationpractice.com/index.php";
        SeleniumHandle handle = new SeleniumHandle();
        handle.setUp();
        WebDriver driver = handle.driver;

        driver.get(baseUrl);

        UserAccount u = UserAccount.generateUserAccountFromDatestring("2018-01-04-010");

        DefaultPage mainPage = new DefaultPage(driver);
        mainPage.click_menubar_SignIn();

        AuthenticationPage ap = new AuthenticationPage(driver);
        assert(ap.get_page_heading() == "AUTHENTICATION");
        ap.send_input_Email(u.getEmail());
        ap.send_input_Password(u.getPassword());
        ap.click_button_SignIn();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assert(myAccountPage.get_page_heading() == "My Account");
        myAccountPage.click_MyAddresses();

        MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
        assert(myAddressesPage.get_page_heading() == "My Addresses");

        myAddressesPage.iterate_addresses();

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String f = this.getClass().getSimpleName() + "-screenshot.png";
        System.out.println("Saving screenshot '" + f + "'");
        try {
            FileUtils.copyFile(scrFile, new File(f));
        } catch (IOException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.quit();

    }
}
