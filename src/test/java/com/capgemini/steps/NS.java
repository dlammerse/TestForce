package com.capgemini.steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.capgemini.BrowserFactory;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

/**
 * Created by DLAMMERS on 19/4/2016.
 */
public class NS {
    WebDriver browser;

    public NS() throws MalformedURLException {
        this.browser = new BrowserFactory().createFfDriver();

    }


    @Given("^I am at www.ns.nl$")
    public void iAmAtWwwNsNl() throws Throwable {
        browser.get("https://www.ns.nl");
        WebElement element = browser.findElement(By.cssSelector(""));
        element.click();
        element.sendKeys();
        element.getText();
    }
}
