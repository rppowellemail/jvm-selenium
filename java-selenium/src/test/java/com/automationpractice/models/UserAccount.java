package com.automationpractice.models;

public class UserAccount {
    public String login;
    public String password;
    public String email;
    public String firstname;
    public String lastname;
    public String address1;
    public String city;
    public String state;
    public String postcode;
    public String phonenumber;

    public static UserAccount generateUserAccountFromDatestring(String datestring) {
        UserAccount u = new UserAccount();
        u.setLogin("test-"+datestring);
        u.setEmail(datestring + "@test.com");
        u.setPassword("password-"+datestring);
        u.setFirstname("test");
        u.setLastname("test");
        u.setAddress1("12345 Test");
        u.setCity("Los Angeles");
        u.setPostcode("90210");
        u.setPhonenumber("3103214321");
        u.setState("California");
        return u;
    }

    public UserAccount () {

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

}
