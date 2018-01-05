package com.demoqa.models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UserAccount {
    public String firstname;
    public String lastname;
    public String[] hobbies;
    public String phonenumber;
    public String username;
    public String email;
    public String password;

    public static String generateDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd'T'HH-mm-ss");
        Random r = new Random();
        return dateFormat.format(new Date()) + "-" + String.format("%04d", r.nextInt(10000));
    }

    public static UserAccount generateUserAccountFromDatestring(String datestring) {
        UserAccount u = new UserAccount();
        u.setUsername("test-"+datestring);
        u.setPassword("password-"+datestring);
        u.setEmail(datestring + "@test.com");
        u.setFirstname("firstname-"+datestring);
        u.setLastname("lastname-"+datestring);
        u.setPhonenumber("3103214321");
        String[] hobbies = {"reading"};
        u.setHobbies(hobbies);
        return u;
    }

    public UserAccount () {

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
