package com.capgemini.ourWebdriver;

import cucumber.api.java.After;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Properties;

public class BrowserFactory {

    static OurWebDriver browser;


    public static OurFirefoxDriver createFfDriver() throws MalformedURLException {
        return OurFirefoxDriver.getBrowser();
    }

    public static OurChromeDriver createChromeDriver() throws MalformedURLException {
        return OurChromeDriver.getBrowser();
    }

    public static OurIEDriver createIEDriver() throws MalformedURLException {
        return OurIEDriver.getBrowser();
    }

    public static OurWebDriver getWebDriver() throws MalformedURLException {
        String browserType = getBrowserType();
        return getBrowserOfType(browserType);
    }

    private static OurWebDriver getBrowserOfType(String browserType) {
        if(browserType==null){
            browser = OurFirefoxDriver.getBrowser();
        }
        else if (browserType.equals("chrome")) {
            browser = OurChromeDriver.getBrowser();
        } else if (browserType.equals("ie")) {
            browser = OurIEDriver.getBrowser();

        } else {
            browser = OurFirefoxDriver.getBrowser();
        }
        return browser;
    }

    private static String getBrowserType() {
        Properties prop = new Properties();
        InputStream input;
        String browserType = null;

        try {

            input = new FileInputStream(System.getProperty("user.dir") +"\\browser.properties");
            prop.load(input);
            browserType = prop.getProperty("browser.type");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return browserType;
    }

}
