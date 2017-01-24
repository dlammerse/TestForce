package com.capgemini;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by DLAMMERS on 24/1/2017.
 */
public abstract class OurWebDriver implements WebDriver {

    OurWebDriver(){
    }

    public static WebDriver getDriver(String browserType){
        if (browserType.equals("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\geckodriver.exe");
            return new FirefoxDriver();
        }
        else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
            return new ChromeDriver();
        }
    }

}
