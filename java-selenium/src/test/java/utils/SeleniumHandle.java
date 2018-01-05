package utils;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SeleniumHandle {

    public WebDriver driver;
    private String browserName;
    private String browserVersion;

    public SeleniumHandle() {
    }

    public void setUp() {
        // declaration and instantiation of objects/variables

        // https://github.com/mozilla/geckodriver
        //System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
        //System.setProperty("webdriver.firefox.marionette","geckodriver");
        //WebDriver driver = new FirefoxDriver();

        //comment the above 2 lines and uncomment below 2 lines to use Chrome
        //System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();

        //driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
        browserName = caps.getBrowserName();
        browserVersion = caps.getVersion();

        System.out.println("Automated test run. We’re running on " + browserName + " " + browserVersion);

    }

    public void tearDown() {
        driver.quit();
    }

}