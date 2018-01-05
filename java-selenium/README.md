
# java-selenium

This project contains java classes to use Selenium do various tasks on websites.

The selenium setup is expecting to use chromedriver and compatible chrome.

The are 2 sites:

* automationpractice.com
* demoqa.com

The `UserRegistrationHappyPath` is run via JUnit as an integration test, verifying expected behavior (account is registered) when valid user information is filed in the registration form and submitted.

The classes under `pages` package implement a java-to-selenium type interface to interact with various elements on delivered webbrowser pages.  These webpage elements are found in the webpage by id, class, and xpath.  Interacting with webpage elements include reading/sending text, clicking buttons/links, and toggling radio checkboxes.

When this code runs, information is currently logged to console, and screenshots are saved to local project directory.

This was verified working for:
* Chrome Version 63.0.3239.132 / chromedriver 2.34
