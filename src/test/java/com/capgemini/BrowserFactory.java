package com.capgemini;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory {


    public WebDriver createFfDriver() throws MalformedURLException {
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
//        System.out.println("Chrome driver is here: " + System.getProperty("webdriver.chrome.driver"));
//        WebDriver driver = new  RemoteWebDriver(new URL("https://www.google.nl"),DesiredCapabilities.chrome());
//        WebDriver driver = new  ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ns.nl");
        return driver;
    }
}
