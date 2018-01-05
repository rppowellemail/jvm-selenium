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

public class UserAccountCreation {

    public static void main(String[] args) {
        UserAccountCreation u = new UserAccountCreation();
        u.doUserAccountCreation();
    }

    public void doUserAccountCreation() {
        String baseUrl = "http://automationpractice.com/index.php";
        SeleniumHandle handle = new SeleniumHandle();
        handle.setUp();
        WebDriver driver = handle.driver;

        driver.get(baseUrl);

        UserAccount u = UserAccount.generateUserAccountFromDatestring(UserAccount.generateDateString());

        DefaultPage mainPage = new DefaultPage(driver);
        mainPage.click_menubar_SignIn();

        AuthenticationPage ap = new AuthenticationPage(driver);
        //ap.assert_page_heading();
        assert(ap.get_page_heading() == "AUTHENTICATION");
        ap.send_input_EmailCreate(u.getEmail());
        ap.click_button_CreateAnAccount();

        CreateAnAccountPage cp = new CreateAnAccountPage(driver);
        //cp.assert_page_heading();
        assert(cp.get_page_heading() == "Create An Account Page");
        cp.send_input_Firstname(u.getFirstname());
        cp.send_input_Lastname(u.getLastname());
        cp.send_input_Password(u.getPassword());
        cp.send_input_Address1(u.getAddress1());
        cp.send_input_City(u.getCity());
        cp.send_input_Postcode(u.getPostcode());
        cp.send_input_Phonenumber(u.getPhonenumber());
        cp.select_State(u.getState());
        cp.click_button_Register();

        MyAccountPage myAccountPage = new MyAccountPage(driver);
        assert(myAccountPage.get_page_heading() == "My Account");

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String f = this.getClass().getSimpleName() + "_" + u.getLogin() + "_MyAccounts-screenshot.png";
        System.out.println("Saving screenshot '" + f + "'");
        try {
            FileUtils.copyFile(scrFile, new File(f));
        } catch (IOException e) {
            e.printStackTrace();
        }

        myAccountPage.click_MyAddresses();

        MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
        assert(myAccountPage.get_page_heading() == "My Addresses");

        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        f = this.getClass().getSimpleName() + "_" + u.getLogin() + "_MyAddresses-screenshot.png";
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
