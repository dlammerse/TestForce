package com.capgemini;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {


    public WebDriver createFfDriver() {
        WebDriver driver = new FirefoxDriver();
        return driver;
    }
}
