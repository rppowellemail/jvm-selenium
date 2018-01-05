
# java-selenium

This project contains java classes to use Selenium do various tasks on websites.

The selenium setup is expecting to use chromedriver and compatible chrome.

The are 2 sites:

* automationpractice.com
* demoqa.com

The `UserRegistrationHappyPath` is run via JUnit as an integration test, verifying expected behavior when valid user information is filed in the registration form.

The classes under `pages` package implement a java-to-selenium type interface to interact with various elements on delivered webbrowser pages.  These are found in the webpage by id, class, and xpath.o

When run, information is currently logged to console, and screenshots are saved to local project directory.

