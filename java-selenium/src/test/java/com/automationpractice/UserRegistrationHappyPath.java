package com.automationpractice;


import com.automationpractice.models.UserAccount;
import com.automationpractice.pages.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utils.WebDriverFactory;

import static org.junit.Assert.assertEquals;

public class UserRegistrationHappyPath {

    public static void main(String[] args) {
        UserRegistrationHappyPath u = new UserRegistrationHappyPath();
        u.testUserRegistrationHappyPath();

    }

    @Test
    public void testUserRegistrationHappyPath() {
        String baseUrl = "http://automationpractice.com/index.php";
        WebDriver driver = WebDriverFactory.createWebDriver();

        driver.get(baseUrl);

        UserAccount u = UserAccount.generateUserAccountFromDatestring(UserAccount.generateDateString());

        DefaultPage mainPage = new DefaultPage(driver);
        mainPage.click_menubar_SignIn();

        AuthenticationPage ap = new AuthenticationPage(driver);
        assertEquals("AuthenticationPage", "AUTHENTICATION", ap.get_page_heading());
        ap.assert_page_heading();
        ap.send_input_EmailCreate(u.getEmail());
        ap.click_button_CreateAnAccount();

        CreateAnAccountPage cp = new CreateAnAccountPage(driver);
        assertEquals("CreateAnAccountPage","CREATE AN ACCOUNT", cp.get_page_heading());
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
        assertEquals("MyAccountPage", "MY ACCOUNT", myAccountPage.get_page_heading());
        myAccountPage.click_MyAddresses();

        MyAddressesPage myAddressesPage = new MyAddressesPage(driver);
        assertEquals("MyAddressesPage", "MY ADDRESSES", myAddressesPage.get_page_heading());

        driver.close();
        driver.quit();

    }
}
