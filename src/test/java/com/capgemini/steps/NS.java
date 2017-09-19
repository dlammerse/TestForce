package com.capgemini.steps;

import com.capgemini.ourWebdriver.BrowserFactory;
import com.capgemini.ourWebdriver.TearDown;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

/**
 * Created by DLAMMERS on 19/4/2016.
 */
public class NS {
    private WebDriver browser;
    private TearDown tearDown;

    public NS() throws MalformedURLException {
        this.browser = BrowserFactory.getWebDriver();

    }


    @Given("^I am at www.ns.nl$")
    public void iAmAtWwwNsNl() throws Throwable {
        browser.get("https://www.ns.nl/producten/en/s/enkele-reis");
    }

    @And("^I clicked accept in cookie popup$")
    public void iClickedAcceptInCookiePopup() throws Throwable {
        try {
            WebElement iframe = browser.findElement(By.cssSelector(".r42CookieBar"));
            browser.switchTo().frame(iframe);
            browser.findElement(By.cssSelector(".button.accept")).click();
            browser.switchTo().defaultContent();
        } catch (NoSuchElementException e){
            e.printStackTrace();
        }

    }

    @When("^I choose to travel today$")
    public void iChooseToTravelToday() throws Throwable {
        browser.findElement(By.cssSelector("[for=\"Today_TravelDate\"]")).click();
    }


    @And("^I travel from Amsterdam$")
    public void iTravelFromAmsterdam() throws Throwable {
        browser.findElement(By.cssSelector("#displayStationFrom")).sendKeys("Amsterdam Centraal");

    }

//    @After
//    public void afterScenario() {
//        browser.quit();
//    }
}
