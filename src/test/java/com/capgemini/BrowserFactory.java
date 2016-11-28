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
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
//        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\geckodriver.exe");

        WebDriver driver = new  ChromeDriver();
//        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ns.nl");
        return driver;
    }
}
