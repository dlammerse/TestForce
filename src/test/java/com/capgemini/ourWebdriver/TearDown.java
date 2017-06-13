package com.capgemini.ourWebdriver;

import com.capgemini.ourWebdriver.BrowserFactory;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import java.net.MalformedURLException;

public class TearDown {

    WebDriver browser;

    public TearDown() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();
    }


    @After
    public void afterScenario() {
        browser.quit();
    }
}
